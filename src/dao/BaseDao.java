package dao;

import java.sql.*;

public class BaseDao {
        private static String driver = "com.mysql.jdbc.Driver";// 数据库驱动字符串
        private static String url = "jdbc:mysql://127.0.0.1:3306/meetingroom?useUnicode=true&characterEncoding=utf-8";// 连接URL字符串
        private static String username = "root"; // 数据库用户名
        private static String password = "root"; // 用户密码

        protected Connection conn;
        protected PreparedStatement pstmt;
        protected ResultSet rs;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象。
     */
    public Connection getConnection() {
        // 获取连接并捕获异常
        try {
            if (conn == null || conn.isClosed())
                conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;// 返回连接对象
    }

    /**
     * 通过连接池获取连接对象
     * @return
     */
//    public Connection getConnection(){
//        try {
//            Context context=new InitialContext();
//            DataSource ds=(DataSource) context.lookup("java:comp/env/jdbc/news");
//            conn=ds.getConnection();
//        } catch (NamingException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }

    /**
     * 关闭数据库连接。
     *
     * @param conn
     *            数据库连接
     * @param stmt
     *            Statement对象
     * @param rs
     *            结果集
     */
    public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        // 若结果集对象不为空，则关闭
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若Statement对象不为空，则关闭
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若数据库连接对象不为空，则关闭
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 增、删、改操作
     *
     * @param sql
     *            sql语句
     * @param params
     *            参数数组
     * @return 执行结果
     */
    protected int executeUpdate(String sql, Object... params) {
        int result = 0;
        conn = this.getConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            if(params!=null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, pstmt, null);
        }
        return result;
    }

    /**
     * 查询操作
     *
     * @param sql
     *            sql语句
     * @param params
     *            参数数组
     * @return 查询结果集
     */
    protected ResultSet executeQuery(String sql, Object... params) {
        conn = this.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            if(params!=null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
