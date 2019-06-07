package Main;

import View.LoginController;
import View.RegistrationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;



    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("E-voting");
        showLogin();
    }

    public void showLogin() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/Sign_in.fxml"));
            AnchorPane login_f = (AnchorPane) loader.load();
            Scene scene = new Scene(login_f);
            primaryStage.setScene(scene);
            primaryStage.show();
            // Помещаем сведения об адресатах в центр корневого макета.
            //rootLayout.setCenter(personOverview);
            // Даём контроллеру доступ к главному приложению.
            LoginController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
