package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnect {
    private Connection _conn;

    public Connection get_conn() {
        return _conn;
    }

    private static SqlConnect _newConn = null;

    public SqlConnect(Connection conn)
    {
        _conn = conn;
    }

    public  SqlConnect Get_newConn()
    {
        return (_newConn = new SqlConnect(_conn));
    }



    public static void GetConnection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/UserLogin",
                            "postgres", "0814");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
