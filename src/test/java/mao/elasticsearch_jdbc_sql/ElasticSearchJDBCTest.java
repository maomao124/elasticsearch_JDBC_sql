package mao.elasticsearch_jdbc_sql;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;

/**
 * Project name(项目名称)：elasticsearch_JDBC_sql
 * Package(包名): mao.elasticsearch_jdbc_sql
 * Class(类名): ElasticSearchJDBCTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/5/30
 * Time(创建时间)： 22:34
 * Version(版本): 1.0
 * Description(描述)： ElasticSearchJDBCTest
 */

@SpringBootTest
public class ElasticSearchJDBCTest
{
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException
    {
        //创建链接
        connection = DriverManager.getConnection("jdbc:es://http://localhost:9200");
    }

    @AfterEach
    void tearDown() throws SQLException
    {
        //关闭链接
        connection.close();
    }

    @Test
    void select() throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from tvs");
        while (resultSet.next())
        {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println("-----");
        }
    }
}
