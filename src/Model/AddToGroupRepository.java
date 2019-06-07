package Model;

import Tables.Add_to_group;
import Tables.OwnGroup;
import Util.SqlConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddToGroupRepository {
    private SqlConnect sqlConnect;
    //private Connection connection;
    public AddToGroupRepository(SqlConnect _sqlConnect)
    {
        sqlConnect = _sqlConnect;
    }

    public ObservableList<Add_to_group> Get_group()
    {
        Add_to_group add_to_group;
        ObservableList<Add_to_group> add_to_groupList = FXCollections.observableArrayList();
        //List userList = new ArrayList<LogIn>();
        Connection connection = sqlConnect.Get_newConn().get_conn();
        try {
            Statement st = null;
            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM add_to_group;");
            while (resultSet.next())
            {
                add_to_group = new Add_to_group(resultSet.getString("group_id"), resultSet.getString("login"));
                add_to_groupList.add(add_to_group);
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

        return add_to_groupList;
    }

    public boolean Add_voterToGroup(String group_id, String user_login)
    {
        boolean key = true;
        try {
            Connection connection = sqlConnect.Get_newConn().get_conn();
            Statement st = null;
            st = connection.createStatement();
            String sql = String.format("INSERT INTO add_to_group(group_id, login) VALUES('%s','%s');", group_id, user_login);
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

    public boolean Delete_voterFromGroup(String user_login)
    {
        boolean key = true;
        try {
            Connection connection = sqlConnect.Get_newConn().get_conn();
            Statement st = null;
            st = connection.createStatement();
            String sql = String.format("DELETE FROM add_to_group WHERE login = %s", user_login);
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
