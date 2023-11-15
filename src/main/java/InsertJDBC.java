import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertJDBC {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student_records";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url,username,password);

            // create a query
            String query = "create table demo(tId int(20) primary key auto_increment," +
                    "" + "tName varchar(200) not null, tCity varchar(400))";

            // crete a statement
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table created successfully..");

        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
