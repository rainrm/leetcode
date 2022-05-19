package com.rainrm.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataDemo {
    static Connection conn = null;
    public static void initConn() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb?"
                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Successfully loaded MySQL driver");
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insert(int insertNum) {
        String prefix = "INSERT INTO tb_order (orderId, create_time, orderName,orderBy,payTime,orderStatus) VALUES ";
        try {
            StringBuffer suffix = new StringBuffer();
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement("");
            for (int i = 1; i <= insertNum; i++) {
                suffix.append("(" + i +", SYSDATE(), zhangsan,lisi,SYSDATE(),1),");
            }
            String sql = prefix + suffix.substring(0, suffix.length() - 1);
            pst.addBatch(sql);
            pst.executeBatch();
            conn.commit();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        initConn();
        insert(10000);
    }
}