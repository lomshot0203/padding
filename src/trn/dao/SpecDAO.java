package trn.dao;

import org.apache.ibatis.session.SqlSession;

public class SpecDAO {
    public static void main(String[] args) {
        SqlSession session = SqlMapClient.getSqlSession();
        String nick = session.selectOne("test.getNick");
        System.out.println();
        session.close();
    }
}
