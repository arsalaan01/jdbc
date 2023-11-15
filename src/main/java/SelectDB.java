import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student_records";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url,username,password);
            String query = "select * from demo";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int id  = rs.getInt("tId");
                String name = rs.getString("tName");
                String city = rs.getString(3);
                System.out.println(id + " " + name + " " + city);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
