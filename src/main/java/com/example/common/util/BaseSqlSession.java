package com.example.common.util;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by qianbw on 17/1/16.
 */
public class BaseSqlSession implements AutoCloseable {
    /**
     * 封装的sqlSession对象。
     */
    private SqlSession sqlSession;

    public BaseSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     * session 提交。
     *
     * @throws SQLException sql异常
     */
    public void commit() throws SQLException {
        this.sqlSession.commit();
    }

    /**
     * session提交。
     *
     * @param force 是否强制
     * @throws SQLException sql异常
     */

    public void commit(boolean force) throws SQLException {
        this.sqlSession.commit(force);
    }

    /**
     * 刷新statement列表。
     *
     * @throws SQLException sql异常
     */
    public void flushStatements() throws SQLException {
        this.sqlSession.flushStatements();

    }

    /**
     * cache 清理。
     *
     * @throws SQLException sql异常
     */
    public void clearCache() throws SQLException {
        this.sqlSession.clearCache();

    }

    /**
     * session 回滚。
     *
     * @throws SQLException sql异常
     */
    public void rollback() throws SQLException {
        this.sqlSession.rollback();
    }

    /**
     * session 回滚。
     *
     * @param force 是否强制
     * @throws SQLException sql异常
     */
    public void rollback(boolean force) throws SQLException {
        this.sqlSession.rollback(force);
    }

    /**
     * session 关闭方法。
     */
    @Override
    public void close() throws SQLException {
        if (this.sqlSession != null) {
            this.sqlSession.close();
        }

    }

    /**
     * 获取Mapper对象。
     *
     * @param type 对象类型实例
     * @param <T>  对象类型
     * @return Mapper对象实例
     */
    public <T> T getMapper(Class<T> type) {
        return this.sqlSession.getMapper(type);
    }

    /**
     * Retrieve a single row mapped from the statement key。
     *
     * @param <T>       the returned object type
     * @param statement 声明
     * @return Mapped object
     */
    public <T> T selectOne(String statement) {
        return this.sqlSession.selectOne(statement);
    }

    /**
     * Retrieve a single row mapped from the statement key and parameter。
     *
     * @param <T>       the returned object type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @return Mapped object
     */
    public <T> T selectOne(String statement, Object parameter) {
        return this.sqlSession.selectOne(statement, parameter);
    }

    /**
     * Retrieve a list of mapped objects from the statement key and parameter。
     *
     * @param <E>       the returned list element type
     * @param statement Unique identifier matching the statement to use.
     * @return List of mapped object
     */
    public <E> List<E> selectList(String statement) {
        return this.sqlSession.selectList(statement);
    }

    /**
     * Retrieve a list of mapped objects from the statement key and parameter。
     *
     * @param <E>       the returned list element type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @return List of mapped object
     */
    public <E> List<E> selectList(String statement, Object parameter) {
        return this.sqlSession.selectList(statement, parameter);
    }

    /**
     * Retrieve a list of mapped objects from the statement key and parameter, within the specified
     * row bounds。
     *
     * @param <E>       the returned list element type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @param rowBounds Bounds to limit object retrieval
     * @return List of mapped object
     */
    public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
        return this.sqlSession.selectList(statement, parameter, rowBounds);
    }

    /**
     * The selectMap is a special case in that it is designed to convert a list of results into a
     * Map based on one of the properties in the resulting objects。 Eg. Return a of
     * Map[Integer,Author] for selectMap("selectAuthors","id")
     *
     * @param <K>       the returned Map keys type
     * @param <V>       the returned Map values type
     * @param statement Unique identifier matching the statement to use.
     * @param mapKey    The property to use as key for each value in the list.
     * @return Map containing key pair data.
     */
    public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
        return this.sqlSession.selectMap(statement, mapKey);
    }

    /**
     * The selectMap is a special case in that it is designed to convert a list of results into a
     * Map based on one of the properties in the resulting objects。
     *
     * @param <K>       the returned Map keys type
     * @param <V>       the returned Map values type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @param mapKey    The property to use as key for each value in the list.
     * @return Map containing key pair data.
     */
    public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
        return this.sqlSession.selectMap(statement, parameter, mapKey);
    }

    /**
     * The selectMap is a special case in that it is designed to convert a list of results into a
     * Map based on one of the properties in the resulting objects。
     *
     * @param <K>       the returned Map keys type
     * @param <V>       the returned Map values type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @param mapKey    The property to use as key for each value in the list.
     * @param rowBounds Bounds to limit object retrieval
     * @return Map containing key pair data.
     */
    public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey,
                                      RowBounds rowBounds) {
        return this.sqlSession.selectMap(statement, parameter, mapKey, rowBounds);
    }

    /**
     * Retrieve a single row mapped from the statement key and parameter using a
     * {@code ResultHandler} 。
     *
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @param handler   ResultHandler that will handle each retrieved row
     */
    public void select(String statement, Object parameter, ResultHandler<?> handler) {
        this.sqlSession.select(statement, parameter, handler);
    }

    /**
     * Retrieve a single row mapped from the statement using a {@code ResultHandler}。
     *
     * @param statement Unique identifier matching the statement to use.
     * @param handler   ResultHandler that will handle each retrieved row
     */
    public void select(String statement, ResultHandler<?> handler) {
        this.sqlSession.select(statement, handler);
    }

    /**
     * Retrieve a single row mapped from the statement key and parameter using a
     * {@code ResultHandler} and {@code RowBounds}。
     *
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @param rowBounds RowBound instance to limit the query results
     * @param handler   ResultHandler that will handle each retrieved row
     */
    public void select(String statement, Object parameter, RowBounds rowBounds,
                       ResultHandler<?> handler) {
        this.sqlSession.select(statement, parameter, rowBounds, handler);
    }

    /**
     * Execute an insert statement。
     *
     * @param statement Unique identifier matching the statement to execute.
     * @return int The number of rows affected by the insert.
     */
    public int insert(String statement) {
        return this.sqlSession.insert(statement);
    }

    /**
     * Execute an insert statement with the given parameter object。Any generated autoincrement
     * values or selectKey entries will modify the given parameter object properties。 Only the
     * number of rows affected will be returned。
     *
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter A parameter object to pass to the statement.
     * @return int The number of rows affected by the insert.
     */
    public int insert(String statement, Object parameter) {
        return this.sqlSession.insert(statement, parameter);
    }

    /**
     * Execute an update statement。The number of rows affected will be returned。
     *
     * @param statement Unique identifier matching the statement to execute.
     * @return int The number of rows affected by the update.
     */
    public int update(String statement) {
        return this.sqlSession.update(statement);
    }

    /**
     * Execute an update statement。The number of rows affected will be returned。
     *
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter A parameter object to pass to the statement.
     * @return int The number of rows affected by the update.
     */
    public int update(String statement, Object parameter) {
        return this.sqlSession.update(statement, parameter);
    }

    /**
     * Execute a delete statement。 The number of rows affected will be returned。
     *
     * @param statement Unique identifier matching the statement to execute.
     * @return int The number of rows affected by the delete.
     */
    public int delete(String statement) {
        return this.sqlSession.delete(statement);
    }

    /**
     * Execute a delete statement。 The number of rows affected will be returned。
     *
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter A parameter object to pass to the statement.
     * @return int The number of rows affected by the delete.
     */
    public int delete(String statement, Object parameter) {
        return this.sqlSession.delete(statement, parameter);
    }

    /**
     * Retrieves current configuration。
     *
     * @return Configuration
     */
    public Configuration getConfiguration() {
        return this.sqlSession.getConfiguration();
    }

    /**
     * Retrieves inner database connection。
     *
     * @return Connection
     */
    public Connection getConnection() {
        return this.sqlSession.getConnection();
    }

}

