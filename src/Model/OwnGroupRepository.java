package Model;

import Tables.LogIn;
import Tables.OwnGroup;
import Util.SqlConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OwnGroupRepository {
    private SqlConnect sqlConnect;
    //private Connection connection;
    public OwnGroupRepository(SqlConnect _sqlConnect)
    {
        sqlConnect = _sqlConnect;
    }

    public ObservableList<OwnGroup> Get_group()
    {
        OwnGroup ownGroup;
        ObservableList<OwnGroup> groupList = FXCollections.observableArrayList();
        //List userList = new ArrayList<LogIn>();
        Connection connection = sqlConnect.Get_newConn().get_conn();
        try {
            Statement st = null;
            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM own_group;");
            while (resultSet.next())
            {
                ownGroup = new OwnGroup(resultSet.getString("group_id"), resultSet.getString("group_title"),
                        resultSet.getString("voting_id"));
                groupList.add(ownGroup);
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

        return groupList;
    }

    public boolean Add_Group(String group_title, String voting_id)
    {
        //LogIn logIn;
        boolean key = true;
        try {
            Connection connection = sqlConnect.Get_newConn().get_conn();
            Statement st = null;
            st = connection.createStatement();
            String sql = String.format("INSERT INTO own_group(group_title, voting_id) VALUES('%s','%s');", group_title, voting_id);
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

    public boolean Delete_group(String group_id)
    {
        boolean key = true;
        try {
            Connection connection = sqlConnect.Get_newConn().get_conn();
            Statement st = null;
            st = connection.createStatement();
            String sql = String.format("DELETE FROM own_group WHERE group_id = %s", group_id);
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
