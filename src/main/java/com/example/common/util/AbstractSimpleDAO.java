package com.example.common.util;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by qianbw on 17/1/16.
 */
public class AbstractSimpleDAO extends AbstractDAO {

    protected BaseSqlSession getSession() {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE, true);
        return new BaseSqlSession(sqlSession);
    }

}