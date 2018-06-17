import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class MyObject {
    //枚举类
    public enum MyEnumSingleton {
        connectionFactory;
        private Connection connection;
        private MyEnumSingleton() {
            try {
                System.out.println("调用了MyObject的构造");
                String url = "jdbc:sqlserver://localhost:1079;databaseName=ghydb";
                String usernmae = "sa";
                String password = "";
                String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                Class.forName(driverName);
                connection = DriverManager.getConnection(url, usernmae, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Connection getConnection() {
            return connection;
        }
    }
    public static Connection getConnection(){
        return MyEnumSingleton.connectionFactory.getConnection();
    }
}
