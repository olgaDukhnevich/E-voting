package View;

import Main.MainApp;
import Tables.LogIn;
import Util.RepositoryFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class EndRegistrationController {
    @FXML
    private TextField NameText;
    @FXML
    private TextField SurnameText;
    @FXML
    private TextField FathersNameText;
    @FXML
    private TextField EmailText;
    @FXML
    private TextField PhoneText;
    @FXML
    private TextField Country;
    @FXML
    private TextField City;
    @FXML
    private ComboBox Gender;
    @FXML
    private DatePicker DateOfBirth;

    private Stage dialogStage;
    public  static String login;
    public  static String user_id;
    RepositoryFactory repositoryFactory =
            new RepositoryFactory("jdbc:postgresql://localhost:5432/E_voting", "postgres", "0814");
    RepositoryFactory repositoryFactory2 =
            new RepositoryFactory("jdbc:postgresql://localhost:5432/UserLogin", "postgres", "0814");
    public ObservableList<String> gender = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        gender.add("male");
        gender.add("female");
        gender.add("other");
        Gender.setItems(gender);
    }

    public void ShowEndReg(Stage primaryStage, String _login, String _user_id)
    {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/EndRegistration.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("End registration");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            EndRegistrationController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            //controller.setPerson(person);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.show();

            login = _login;
            user_id = _user_id;
            //return controller.isOkClicked();

        }
        catch (IOException e){
            e.printStackTrace();
            //return false;
        }
    }



    @FXML
    public void HandleSave()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(Country.getText() + " " + Gender.getValue());
        alert.showAndWait();
        if(isInputValid())
        {
            boolean res = false;


            res = repositoryFactory.Get_users().Add_User(user_id, login, NameText.getText(), SurnameText.getText(), FathersNameText.getText(), EmailText.getText(),
                    PhoneText.getText(), Country.getText(), City.getText(), Gender.getValue().toString(), DateOfBirth.getValue().toString());
            if(res)
            {
                alert.setContentText("Register successfully");
                alert.showAndWait();
                boolean queryRes = repositoryFactory2.Get_LogIn().UpdFirstLogin(false, login);
            }
            else
            {
                alert.setContentText("Registration error");
                alert.showAndWait();
            }
        }
    }

    private boolean isInputValid()
    {
        String errorMessage = "";
        if(NameText.getText() == null || NameText.getText().trim().isEmpty())
            errorMessage += "Enter your name!\n";
        if(SurnameText.getText() == null || SurnameText.getText().trim().isEmpty())
            errorMessage += "Enter your surname!\n";
        if(FathersNameText.getText() == null || FathersNameText.getText().trim().isEmpty())
            errorMessage += "Enter your Father's name\n";
        if(EmailText.getText() == null || EmailText.getText().trim().isEmpty())
            errorMessage += "Enter your email!\n";
        if(PhoneText.getText() == null || PhoneText.getText().trim().isEmpty())
            errorMessage += "Enter your phone!\n";
        //if(Country.getText() == null || Country.getText().trim().isEmpty());
          //  errorMessage += "Enter your country!\n";
        if(City.getText() == null || City.getText().trim().isEmpty())
            errorMessage += "Enter your city\n";
        if(Gender.getValue() == null)
            errorMessage += "Enter your gender\n";
        if(DateOfBirth.getEditor().getText() == null || DateOfBirth.getEditor().getText().trim().isEmpty())
            errorMessage += "Enter your date of birth\n";
        if(errorMessage.length() == 0)
        {
            return true;
        }
        else {
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

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
