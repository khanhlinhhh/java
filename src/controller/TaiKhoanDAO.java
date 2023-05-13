package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.JDBCConnection;

public class TaiKhoanDAO {
	private Connection conn;

    public TaiKhoanDAO() {
        try {
            // connnect to database 'testdb'
        	  conn = JDBCConnection.getJDBCConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public boolean getLogin(String Username, String Pass) {

        String sqlInsert = "SELECT * FROM  taikhoan where Username = ? AND Pass = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sqlInsert);
            preparedStatement.setString(1, Username);
            preparedStatement.setString(2, Pass);

            ResultSet rs = preparedStatement.executeQuery();//success:1,don't success =-1,
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
}
