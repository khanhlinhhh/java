


/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.JDBCConnection;
import model.PhongDTO;
import view.Phong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class PhongDAO {

    private static Connection conn;

    public PhongDAO() {
        try {
            // connnect to database 'testdb'
            conn = JDBCConnection.getJDBCConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static List<PhongDTO> selectPhong(String search) {
        List<PhongDTO> phongList = new ArrayList<>();
        String sqlInsert = "SELECT TOP (1000) * FROM [qldatphongks].[dbo].[phong] where maphong like ? or tenphong like ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sqlInsert);
            preparedStatement.setString(1, "%" + search + "%");
            preparedStatement.setString(2, "%" + search + "%");

            ResultSet rs = preparedStatement.executeQuery();//success:1,don't success =-1,
            while (rs.next()) {
            	PhongDTO phong = new PhongDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                phongList.add(phong);
            }
        } catch (SQLException ex) {
            return phongList;
        }
        return phongList;
    }

    public int insertPhong(PhongDTO phong) {
         int result = -1;
        String sqlInsert = "INSERT INTO [qldatphongks].[dbo].[phong] VALUES(?, ?, ?, ?, ? )";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sqlInsert);
            preparedStatement.setString(1, phong.getMaphong());
            preparedStatement.setString(2, phong.getTenphong());
            preparedStatement.setString(3, phong.getLoaiphong());
            preparedStatement.setString(4, phong.getGiaphong());
            preparedStatement.setString(5, phong.getTinhtrang());
            result = preparedStatement.executeUpdate();//success:1,don't success =-1,
        } catch (SQLException ex) {
            result = -1;
        }
        return result;
    }
    
    public int updatePhong(PhongDTO phong) {

        int result = -1;
        String sqlInsert = "UPDATE qldatphongks SET maphong = ?, tenphong = ?,  loaiphong = ?, giaphong = ?, tinhtrang = ? WHERE maphong = ? ;";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sqlInsert);
            preparedStatement.setString(1, phong.getMaphong());
            preparedStatement.setString(2, phong.getTenphong());
            preparedStatement.setString(3, phong.getLoaiphong());
            preparedStatement.setString(4, phong.getGiaphong());
            preparedStatement.setString(5, phong.getTinhtrang());
            preparedStatement.setString(6, phong.getMaphong());
            
            result = preparedStatement.executeUpdate();//success:1,don't success =-1,
        } catch (SQLException ex) {
           result = -1;
        }
        return result;
    }
    
     public int deletePhong(String maphong) {
    	 Phong phong = new Phong();
        int result = -1;
        String sqlInsert = "DELETE FROM phong WHERE maphong=?;";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sqlInsert);
            preparedStatement.setString(1, maphong);
            
            result = preparedStatement.executeUpdate();//success:1,don't success =-1,
        } catch (SQLException ex) {
           result = -1;
        }
        return result;
     }
}
//    public static void deletePhong(PhongDTO phong) {
//		String query="delete from phong where maphong='"+phong.getMaphong()+"'";
//		try {
//			Connection conn =JDBCConnection.getJDBCConnection();
//			PreparedStatement preparedStatement=conn.prepareStatement(query);
//			preparedStatement.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//
////	public void deletePhong(String maphong) {
////		// TODO Auto-generated method stub
////		String sqlInsert="DELETE FROM phong WHERE maphong=?;";
////		try {
////			Connection conn =JDBCConnection.getJDBCConnection();
////			PreparedStatement preparedStatement=conn.prepareStatement(sqlInsert);
////			preparedStatement.executeUpdate();
////		} catch (Exception e) {
////			// TODO: handle exception
////		}
//	//}
//}

	
		






























































/*
 * 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package controller;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import model.QLSach;
//
///**
// *
// * @author ASUS
// */
//public class DAO {
//
//    public static List<QLSach> findAll() {
//        List<QLSach> qLSachList = new ArrayList<>();
//
//        Connection connection = null;
//        Statement statement = null;
//
//        try {
//            //lay tat ca danh sach sinh vien
//            connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-KFSO9OT7\\SQLEXPRESS:1433;databaseName=Management;", "sa", "123456");
//
//            //query
//            String sql = "select * from QLSach";
//            statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                QLSach std = new QLSach(
//                        resultSet.getString("id"),
//                        resultSet.getString("ten"),
//                        resultSet.getString("theloai"),
//                        resultSet.getString("tacgia"), 
//                        resultSet.getInt("gia"),
//                        resultSet.getInt("soluong")
//                );
//                qLSachList.add(std);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        //ket thuc.
//
//        return qLSachList;
//    }
//    public static void insert(QLSach std) {
//        Connection connection = null;
//        PreparedStatement statement = null;
//
//        try {
//            //lay tat ca danh sach sinh vien
//            connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-KFSO9OT7\\SQLEXPRESS:1433;databaseName=Management;", "sa", "123456");
//
//            String sql = "insert into QLSach(id, ten, theloai, tacgia, gia, soluong) values(?, ?, ?, ?, ?, ?)";
//            statement = connection.prepareCall(sql);
//
//            statement.setString(1, std.getId());
//            statement.setString(2, std.getTen());
//            statement.setString(3, std.getTheloai());
//            statement.setString(4, std.getTacgia());
//            statement.setInt(5, std.getGia());
//            statement.setInt(6, std.getSoluong());
//
//            statement.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//
//    }
//
//    public static void update(QLSach std) {
//        Connection connection = null;
//        PreparedStatement statement = null;
//
//        try {
//            //lay tat ca danh sach sinh vien
//            connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-KFSO9OT7\\SQLEXPRESS:1433;databaseName=Management;", "sa", "123456");
//
//            String sql = "update QLSach set ten=?, theloai=?, tacgia=?, gia=?, soluong=? where id = ?";
//            statement = connection.prepareCall(sql);
//
//            statement.setString(1, std.getId());
//            statement.setString(2, std.getTen());
//            statement.setString(3, std.getTheloai());
//            statement.setString(4, std.getTacgia());
//            statement.setInt(5, std.getGia());
//            statement.setInt(6, std.getSoluong());
//
//            statement.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//
//    }
//
//    public static void delete(QLSach std) {
//        Connection connection = null;
//        PreparedStatement statement = null;
//
//        try {
//            //lay tat ca danh sach sinh vien
//            connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-KFSO9OT7\\SQLEXPRESS:1433;databaseName=Management;", "sa", "123456");
//
//            String sql = "delete from QLSach where id = ?";
//            statement = connection.prepareCall(sql);
//
//            statement.setString(1, std.getId());
//
//            statement.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//
//    }
//
//    public static List<QLSach> findByTen(String ten) {
//        List<QLSach> qLSachList = new ArrayList<>();
//
//        Connection connection = null;
//        PreparedStatement statement = null;
//
//        try {
//            //lay tat ca danh sach sinh vien
//            connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-KFSO9OT7\\SQLEXPRESS:1433;databaseName=Management;", "sa", "123456");
//
//            String sql = "select * from QLSach where ten  like ?";
//            statement = connection.prepareCall(sql);
//            statement.setString(1, "%" + ten + "%");
//
//
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                QLSach std = new QLSach(resultSet.getString("id"),
//                        resultSet.getString("ten"),
//                        resultSet.getString("theloai"),
//                        resultSet.getString("tacgia"),
//                        resultSet.getInt("gia"),
//                        resultSet.getInt("soluong"));
//                qLSachList.add(std);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//
//        return qLSachList;
//
//    }
//
// 
//}
