import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicQuery {
    public static void main(String[] args) {
        // Dynamic queries are implement using PreparedStatement interface
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student_records";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url,username,password);

            // dynamic query
            String query = "insert into demo(tName,tCity) values(?,?)";

            // get the PreparedStatement object
            PreparedStatement pstmt =  conn.prepareStatement(query);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name: ");
            String name = br.readLine();
            System.out.println("Enter City: ");
            String city = br.readLine();

            // set the query parameter
            pstmt.setString(1,name);
            pstmt.setString(2,city);
            pstmt.executeUpdate();

            System.out.println("Inserted data");
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
