package View;

import Main.MainApp;
import Tables.LogIn;
import Util.HashPassword;
import Util.RepositoryFactory;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {
    @FXML
    private TextField login2;
    @FXML
    private PasswordField password2;
    @FXML
    private PasswordField rep_pass2;
    @FXML
    private Button reg;

    private Stage stage;
    private LogIn logIn;
    private MainApp mainApp;
    private boolean okClicked = false;
    RepositoryFactory repositoryFactory =
            new RepositoryFactory("jdbc:postgresql://localhost:5432/UserLogin", "postgres", "0814");
    private Stage dialogStage;

    @FXML
    private void initialize() {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Добавление в таблицу данных из наблюдаемого списка
        //personTable.setItems(mainApp.getPersonData());
    }

    @FXML
    public void HandleCancel()
    {
        dialogStage.close();
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    private boolean isInputValid(){
        String errorMessage = "";
        if(login2.getText() == null || login2.getText().length() == 0)
        {
            errorMessage += "Enter login\n";
        }
        if(password2.getText() == null || password2.getText().length() == 0)
        {
            errorMessage += "Enter password\n";
        }
        if(rep_pass2.getText() == null || rep_pass2.getText().length() == 0)
        {
            errorMessage += "Enter password once more\n";
        }
        if(!rep_pass2.getText().equals(password2.getText()))
        {
            errorMessage += "Passwords are not the same\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }

    }

    @FXML
    public void HandleReg()
    {
        if(isInputValid())
        {
            HashPassword hashPassword = new HashPassword();
            String password = hashPassword.GetHash(password2.getText()).toString();
            //password.Pbkdf2PasswordEncoder();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.initOwner(dialogStage);
            //boolean res = false;
            boolean res = false;
            res = repositoryFactory.Get_LogIn().Add_User(login2.getText(), password);
            if (res) {
                alert1.setContentText("Please, sign in with your login and finish registration.");
                alert1.showAndWait();
                okClicked = true;
                dialogStage.close();
            } else {
                alert1.setContentText("Registration error");
                alert1.showAndWait();
            }
        }
    }
    public static void ShowReg(Stage primaryStage)
    {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/Registration.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Registration");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            RegistrationController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            //controller.setPerson(person);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.show();

            //return controller.isOkClicked();

        }
        catch (IOException e){
            e.printStackTrace();
            //return false;
        }
    }
}
