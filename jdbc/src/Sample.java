import java.sql.*;

public class Sample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test_base";
        String username = "root";
        String password = "root";
        Connection connection = null;

        try {
            // 建立数据库连接
            connection = DriverManager.getConnection(url, username, password);
            // 创建 Statement 对象
            Statement statement = connection.createStatement();
            // 执行查询
            String query = "SELECT * FROM employee";
            ResultSet resultSet = statement.executeQuery(query);

            // 处理查询结果
            while (resultSet.next()) {
                Integer eno = resultSet.getInt(1); // eno
                String ename = resultSet.getString("ename");
                Float salary = resultSet.getFloat("salary");
                String dname = resultSet.getString("dname");
                System.out.println(dname + "-" + eno + "-" + ename + "-" + salary);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    // 关闭连接,释放资源
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
