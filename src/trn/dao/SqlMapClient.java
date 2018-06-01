package trn.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.Reader;

public class SqlMapClient {
    private static SqlSession session;
/*
    static {
        String resource = "myBatisConfig.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuiler().build(reader);
            session = sqlMapper.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static SqlSession getSqlSession () {
        return session;
    }
}
