import java.sql.*;

public class Db {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test_base";
        String username = "root";
        String password = "root";
        // 建立数据库连接
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    /**
     * 关闭连接,释放资源
     * @param rs 结果集对象
     * @param stmt Statement对象
     * @param conn Connection对象
     */
    public static void closeConnection(ResultSet rs , Statement stmt , Connection conn){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(conn != null && !conn.isClosed() ) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
