import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionTests {

    @Test
    public void testHikariCP() throws Exception {

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/springexdb?serverTimezone=Asia/Seoul&charEncoding=UTF-8");
        config.setUsername("root");
        config.setPassword("mysql1234");
        HikariDataSource ds = new HikariDataSource(config);
        Connection conn = ds.getConnection();

        System.out.println(conn);
        conn.close();

    }
}
