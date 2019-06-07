package Model;

import Tables.LogIn;
import Util.RepositoryFactory;
import Util.SqlConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LogInRepository {
    private SqlConnect sqlConnect;
    //private Connection connection;
    public LogInRepository(SqlConnect _sqlConnect)
    {
        sqlConnect = _sqlConnect;
    }

    public ObservableList<LogIn> Get_table()
    {
        LogIn logIn;
        ObservableList<LogIn> userList = FXCollections.observableArrayList();
        //List userList = new ArrayList<LogIn>();
        Connection connection = sqlConnect.Get_newConn().get_conn();
        try {
            Statement st = null;
            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM user_log;");
            while (resultSet.next())
            {
                logIn = new LogIn(resultSet.getString("user_id"), resultSet.getString("login"),
                        resultSet.getString("password"), resultSet.getString("first_login"));
                userList.add(logIn);
            }
            resultSet.close();
            st.close();
            //connection.close();
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error in DB:" + e.toString());
            alert.showAndWait();
            //connection.close();
        }

        return userList;
    }

    public boolean Add_User(String login, String password)
    {
        //LogIn logIn;
        boolean key = true;
        try {
            Connection connection = sqlConnect.Get_newConn().get_conn();
            Statement st = null;
            st = connection.createStatement();
            String sql = String.format("INSERT INTO user_log(login, password, first_login) VALUES('%s','%s', true);", login, password);
            st.executeUpdate(sql);
            st.close();
            //connection.close();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error in DB: " + e.toString());
            alert.showAndWait();
            key = false;
        }
        return key;
    }

    public boolean UpdFirstLogin(boolean value, String login)
    {
        boolean key = false;
        try {
            Connection connection = sqlConnect.Get_newConn().get_conn();
            Statement st = null;
            st = connection.createStatement();
            String sql = String.format( "UPDATE public.user_log SET first_login= %b WHERE login = '%s';", value, login);
            st.executeUpdate(sql);
            st.close();
            key = true;
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error in DB: " + e.toString());
            alert.showAndWait();
            key = false;
        }
        return key;
    }
}
