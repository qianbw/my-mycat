package com.example.common.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by qianbw on 17/1/16.
 */
public abstract class AbstractDAO {
    @Autowired
    @Qualifier("sqlSessionFactory")
    protected SqlSessionFactory sqlSessionFactory;

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }



    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }



    protected abstract BaseSqlSession getSession();

}

