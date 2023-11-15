import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageToDB {
    public static void main(String[] args) {
        // Dynamic queries are implement using PreparedStatement interface
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student_records";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url,username,password);

            // dynamic query
            String query = "insert into image(pic) values(?)";

            // get the PreparedStatement object
            PreparedStatement pstmt =  conn.prepareStatement(query);

            FileInputStream fis = new FileInputStream("mypic.jpg");
            pstmt.setBinaryStream(1,fis,fis.available());

            // set the query parameter
            pstmt.executeUpdate();

            System.out.println("Inserted data");
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

