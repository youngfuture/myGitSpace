package ex7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/delay_order?serverTimezone=GMT%2b8";
    public static final String USER = "root";
    public static final String PASSWORD = "789456";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT order_no, order_note FROM order_exp");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString("order_no")+" 订单内容："+rs.getString("order_note"));
        }
    }
}
