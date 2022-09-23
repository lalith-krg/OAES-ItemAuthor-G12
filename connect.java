// import java.lang.ref.Cleaner;
import java.sql.*;

public class connect {
    //I kept the database name as OAES so it is used in the url below. Change it to your own database name.

    private final static String url = "jdbc:mysql://localhost:3306/OAES"; // Dont change this, This is generally default.
    private final static String username = ""; // Change the username to your respective database
    private final static String password = ""; // Change the password to your respective database

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Download the jar file from internet and include it in the referenced libraries
            Connection con = DriverManager.getConnection(url, username, password);
        

            return con;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
