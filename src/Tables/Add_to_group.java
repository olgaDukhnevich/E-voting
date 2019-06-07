package Tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Add_to_group {
    public StringProperty group_id;
    public StringProperty user_login;

    public String getGroup_id() {
        return group_id.get();
    }

    public StringProperty group_idProperty() {
        return group_id;
    }

    public String getUser_login() {
        return user_login.get();
    }

    public StringProperty user_loginProperty() {
        return user_login;
    }

    public  Add_to_group() {}
    public Add_to_group(String _group_id, String _user_login)
    {
        group_id = new SimpleStringProperty(_group_id);
        user_login = new SimpleStringProperty(_user_login);
    }
}

