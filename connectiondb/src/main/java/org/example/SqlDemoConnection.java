import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlDemoConnection
{
    public static void main(String[] args)
    {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sophi\\Downloads\\build_comp.db");
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT Name FROM Employee");
            while (resultSet.next())
            {
                System.out.println("Employee Name:"
                        + resultSet.getString("Name"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}  