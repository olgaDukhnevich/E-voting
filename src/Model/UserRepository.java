package Model;

import Util.SqlConnect;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.Statement;

public class UserRepository {
    private SqlConnect sqlConnect;
    //private Connection connection;
    public UserRepository(SqlConnect _sqlConnect)
    {
        sqlConnect = _sqlConnect;
    }

    public boolean Add_User(String user_id, String login, String name, String surname, String fathersName,
                            String email, String phone, String country, String city, String gender, String dateOfBirth)
    {
        //LogIn logIn;
        boolean key = true;
        try {
            Connection connection = sqlConnect.Get_newConn().get_conn();
            Statement st = null;
            st = connection.createStatement();
            String sql = String.format("INSERT INTO public.users(\n" +
                    "\tuser_id, login, user_name, surname, fathers_name, email, phone, country, city, gender, date_of_birth)\n" +
                    "\tVALUES (%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                    user_id, login, name, surname, fathersName, email, phone, country, city, gender, dateOfBirth);
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
}
