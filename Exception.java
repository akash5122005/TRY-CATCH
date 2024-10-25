import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/test_db";
        String user = "root";
        String password = "password";
        String query = "SELECT * FROM customers";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(dbUrl, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            int columnCount = resultSet.getMetaData().getColumnCount();
            while(resultSet.next()){
                for (int i = 1; i <= columnCount;i++){
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        }catch (ClassNotFoundException e){
            System.out.println("Error: JDBC Driver not found.");
        } catch(SQLException e){
            System.out.println("Error: SQL Exception occured - "+ e.getMessage());
        } finally{
            try{
                if(resultSet != null) resultSet.close();
                if(statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e){
                System.out.println("Error: Failed to close resources - " + e.getMessage());
            }
        }
    }
}
