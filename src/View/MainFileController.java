package View;

import Main.MainApp;
import Tables.LogIn;
import Util.RepositoryFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.io.PrintStream;

public class MainFileController {
    @FXML
    private TableView<LogIn> tableView;
    @FXML
    private TableColumn<LogIn, String> loginColumn;
    @FXML
    private TableColumn<LogIn, String> passwordColumn;
    //ListView votings;
    private Stage stage;
    private LogIn logIn;
    private MainApp mainApp;
    private boolean onClicked = false;
    private Stage dialogStage;
    String login;
    String user_id;
    RepositoryFactory repositoryFactory =
            new RepositoryFactory("jdbc:postgresql://localhost:5432/UserLogin", "postgres", "0814");

    @FXML
    private void initialize() {
        for (LogIn i:repositoryFactory.Get_LogIn().Get_table()
             ) {
            //votings.getItems().add(i.Login + '\t' + i.Password);
            loginColumn.setCellValueFactory(cellData -> cellData.getValue().Login);
            passwordColumn.setCellValueFactory(cellData -> cellData.getValue().Password);
            tableView.setItems(repositoryFactory.Get_LogIn().Get_table());
        }

        // LoginController loginController = new LoginController();
        //loginController.HandleReg();
    }

    public static void ShowMainFile(Stage primaryStage)
    {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/MainFile.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("E-voting");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            MainFileController controller = loader.getController();
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

    public void ShowEndReg(Stage primaryStage)
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


            //return controller.isOkClicked();

        }
        catch (IOException e){
            e.printStackTrace();
            //return false;
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


}
