import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的。SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。
 * @author dsx
 */
public class Tests {
    /**
     * 从 XML 中构建 SqlSessionFactory
     * @throws IOException
     */
    @Test
    public void testSqlSessionFactoryFromXML() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 不使用 XML 构建 SqlSessionFactory
     * @throws IOException
     */
    @Test
    public void testSqlSessionFactoryFromCode() throws IOException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl("jdbc:mysql://123.57.70.238:3306/test");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("BXH123bxh");

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, mysqlDataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);



        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<User> users = session.selectList("mapper.UserMapper.listAll");
            System.out.println(users);
        }
    }
}
