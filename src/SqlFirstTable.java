import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlFirstTable {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // db parameters
            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "passwordhere";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            Statement s = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS student " +
                    "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " last_name VARCHAR(30), " +
                    " first_name VARCHAR(30))";
            s.executeUpdate(sql);
            s.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Red', 'Dario');");
            s.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Blue', 'Pino');");
            s.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Green', 'Gianni');");
            s.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Purple', 'Aldo');");
            // more processing here

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            try{
                if(conn != null)
                conn.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
