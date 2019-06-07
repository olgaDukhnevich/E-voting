package Tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LogIn {
    public StringProperty User_id;

    private void setUser_id(String user_id) {
        User_id.set(user_id);
    }

    public String getUser_id() {
        return User_id.get();
    }

    public StringProperty Login;

    private void setLogin(String login) {
        this.Login.set(login);
    }

    public String getLogin() {
        return Login.get();
    }

    public StringProperty Password;

    private void setPassword(String password) {
        Password.set(password);
    }

    public String getPassword() {
        return Password.get();
    }

    public StringProperty First_login;

    private void setFirst_login(String first_login) {
        First_login.set(first_login);
    }

    public String getFirst_login() {
        return First_login.get();
    }

    public StringProperty loginProperty(){
        return Login;
    }
    public LogIn(){}

    public  LogIn(String user_id, String login, String password, String first_login)
    {
        User_id = new SimpleStringProperty(user_id);
        Login = new SimpleStringProperty(login);
        Password = new SimpleStringProperty(password);
        First_login = new SimpleStringProperty(first_login);
    }

}
