package Util;

import Model.LogInRepository;
import Model.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;

public class RepositoryFactory {

    LogInRepository logInRepository;
    UserRepository userRepository;

    public LogInRepository getLogInRepository() {
        return logInRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setLogInRepository(LogInRepository logInRepository) {
        this.logInRepository = logInRepository;
    }

    private Connection connection;
    private SqlConnect sqlConnect;

    public RepositoryFactory(String DB_URL, String user, String password)
    {
        try
        {
        //Class.forName("org.postgresql.Driver");
        connection = DriverManager
                .getConnection(DB_URL,
                        user, password);
        sqlConnect = new SqlConnect(connection);
        logInRepository = new LogInRepository(sqlConnect);
        userRepository = new UserRepository(sqlConnect);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

    }

    public LogInRepository Get_LogIn()
    {
        //LogInRepository logInRepository = this.logInRepository;
        return logInRepository;
    }
    public UserRepository Get_users()
    {
        return userRepository;
    }
}