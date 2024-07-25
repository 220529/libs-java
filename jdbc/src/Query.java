import java.sql.*;
import java.util.Scanner;

public class Query implements Command {
    @Override
    public void execute() {
        System.out.println("Enter department");
        Scanner in = new Scanner(System.in);
        String departmentName = in.nextLine();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Db.getConnection();
            // 创建 Statement 对象
            Statement statement = connection.createStatement();
            // 执行查询
            String query = "SELECT * FROM employee where dname =?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, departmentName);
            ResultSet resultSet = preparedStatement.executeQuery();

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
        }
    }
}
