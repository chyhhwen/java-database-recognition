import java.sql.*;
public class query
{
    String out="";
    public void query(int number, String put)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("找不到驅動程式類別");
            e.printStackTrace();
        }
        try
        {
            Connection connection = sqlset.getConnection();
            // 查詢city表
                if(number == 1)//USE
                {
                    Statement statement = connection.createStatement();
                    try
                    {
                        statement.executeUpdate(String.format(put));
                    }
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println("input yes");

                    connection.close();
                }
                else if(number == 2)// select all
                {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(put);
                    while (resultSet.next())
                    {
                       out = resultSet.getString("id");
                        System.out.printf("%d ",resultSet.getInt(1));
                        System.out.printf("%s",resultSet.getString(2));
                    }
                    connection.close();
                }
                else
                {
                    System.out.println("ERROR SQLPUT");
                }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public String output()
    {

        return out;
    }

}