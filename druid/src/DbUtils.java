import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DbUtils {

    public static void main(String[] args) throws UnsupportedEncodingException {
        query();
    }

    public static void query() throws UnsupportedEncodingException {
        System.out.println("query.start");
        Properties properties = new Properties();
        String propertyFile = DbUtils.class.getResource("/druid-config.properties").getPath();
        try {
            propertyFile = URLDecoder.decode(propertyFile, "UTF-8");
            properties.load(new FileInputStream(propertyFile));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

            QueryRunner qr = new QueryRunner(dataSource);
            List<Employee> list =  qr.query("select * from employee limit ?,10", new BeanListHandler<>(Employee.class),
                    new Object[]{10});

            for (Employee emp : list) {
                System.out.println("eno: " + emp.getEno() + ", ename: " + emp.getEname());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
