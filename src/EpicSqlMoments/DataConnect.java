package EpicSqlMoments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
    private Connection con;
    private static DataConnect instance = new DataConnect();
    private DataConnect(){
        try {
            con = DriverManager.getConnection(Info.HOST,Info.USER,Info.PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static DataConnect getInstance(){
        return instance;
    }
    public Connection getConnection(){return con;}

}
