package View;

import Main.MainApp;
import Model.LogInRepository;
import Tables.LogIn;
import Util.HashPassword;
import Util.RepositoryFactory;
import Util.SqlConnect;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.util.Arrays;

import static View.MainFileController.ShowMainFile;

public class LoginController {

    @FXML
    private Label loginLabel;
    @FXML
    private  Label passwordLabel;
    @FXML
    private TextField loginText;
    @FXML
    private  PasswordField passwordText;

    private Stage stage;
    private LogIn logIn;
    private MainApp mainApp;
    private boolean onClicked = false;
    RepositoryFactory repositoryFactory =
            new RepositoryFactory("jdbc:postgresql://localhost:5432/UserLogin", "postgres", "0814");

    @FXML
    private void initialize() {
       // LoginController loginController = new LoginController();
        //loginController.HandleReg();
    }

    /**
     * Устанавливает сцену для этого окна.
     *
     * @param dialogStage
     */

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Добавление в таблицу данных из наблюдаемого списка
        //personTable.setItems(mainApp.getPersonData());
    }

    @FXML
    public void HandleEnter()
    {
        if(loginText.getText().trim().isEmpty()|| passwordText.getText().trim().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Empty field");
            alert.setHeaderText("Login or password is empty");
            alert.setContentText("Fill empty fields!");
            alert.showAndWait();
        }

        else {
            //RepositoryFactory repositoryFactory = new RepositoryFactory();
            HashPassword hashPassword = new HashPassword();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            String user_login = loginText.getText();
            String password = hashPassword.GetHash(passwordText.getText()).toString();
            //alert.setContentText(password);
           // alert.showAndWait();
            //String[] loginStr = new String[repositoryFactory.Get_LogIn().Get_table().size()];
            boolean key = false;
            for (LogIn i : repositoryFactory.Get_LogIn().Get_table()) {
                //alert.setContentText(i.getLogin());
                //alert.showAndWait();
                if(loginText.getText().equals(i.getLogin())) {
                    key = true;
                    if(key) {
                        if (user_login.equals(i.getLogin()) && password.equals(i.getPassword())) {
                            if(i.getFirst_login().equals("t"))
                            {
                                String user_id = i.getUser_id();
                                EndRegistrationController registrationController = new EndRegistrationController();
                                        registrationController.ShowEndReg(mainApp.getPrimaryStage(), loginText.getText(), user_id);
                            }
                            else if(i.getFirst_login().equals("f")) {
                                //String user_id = i.getUser_id();
                                MainFileController mainFileController;
                                mainFileController = new MainFileController();
                                mainFileController.ShowMainFile(mainApp.getPrimaryStage());
                                }
                            //TODO:если не первый вход открывем главное окно приложение
                            //alert.initOwner(mainApp.getPrimaryStage());
                            //alert.setContentText("Login: " + user_login + " Password: " + password);
                            //alert.showAndWait();

                        } else if (user_login.equals(i.getLogin()) && !password.equals(i.getPassword())) {
                            //Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("Wrong password");
                            alert.showAndWait();
                        }
                    }
                }
            }
            if(!key)
            {
                alert.setContentText("Invalid login");
                alert.showAndWait();
            }
        }
    }


    @FXML
    public void HandleReg()
    {
        //LogIn logIn = new LogIn();
        RegistrationController.ShowReg(mainApp.getPrimaryStage());

    }

}
