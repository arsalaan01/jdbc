import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
    /* Steps for Database Connectivity with JDBC API
    * Load and Register Driver
    * Create connection
    * Create statement
    * Execute SQL statement
    * Process the result
    * Close the connection
    * */

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student_records";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url,username,password);

            if(conn.isClosed())
                System.out.println("Connection is closed");
            else
                System.out.println("Connection is successful");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


}
