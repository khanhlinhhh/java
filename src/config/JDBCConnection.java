package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	

	public class JDBCConnection { 
		
		public static Connection getJDBCConnection() throws SQLException{
			final String url ="jdbc:sqlserver://localhost:1433;databaseName=qldatphongks;user=sa;password=123";
			final String user = "sa";
	        final String password = "123";
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            return DriverManager.getConnection(url, user, password);
	        } catch (ClassNotFoundException ex) {
	                ex.printStackTrace();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }

		return null;
		}
		 public static void main(String[] args) throws SQLException {
		        
				Connection connection = getJDBCConnection();
		        
		        if (connection != null) {
		            System.out.println("Data connection successful");
		        } else {
		            System.out.println("Data connection failed");
		        }
		    }

		
	}
//	Connection con = null;
//	  try {
//          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//       String URL = "jdbc:sqlserver://localhost:1433;databaseName=qldatphongks;user=sa;password=123";
//       con = DriverManager.getConnection(URL, "sa", "123");
//       System.out.println("kết nối thành công");
//      } catch (ClassNotFoundException ex) {
//      	System.out.println("kết nối thất bại");
//             System.out.println(ex.getMessage()+"/n"+ex.getClass()+"/n"+ex.getCause());
//}
//		 public static Connection getJDBCConnection() throws SQLException {
//		        final String url = "jdbc:mysql://localhost;databaseName=qldatphongks;";
//		        final String user = "sa";
//		        final String password = "123";
//		        
//		        try {
//		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		            return DriverManager.getConnection(url, user, password);
//		        } catch (ClassNotFoundException ex) {
//		                ex.printStackTrace();
//		        } catch (SQLException ex) {
//		            ex.printStackTrace();
//		        }
//		        return null;
//		    }
//		        public static void main(String[] args) throws SQLException {
//		        Connection connection = getJDBCConnection();
//		        
//		        if (connection != null) {
//		            System.out.println("Data connection successful");
//		        } else {
//		            System.out.println("Data connection failed");
//		        }
//		    }
//	}
//		public static final Connection Connection = null;
//
//		public static void main(String[] args) {
//			java.sql.Connection conn;
//			try {
//				String dbURL = "jdbc:sqlserver://localhost;databaseName=qldatphongks;user=sa;password=123";
//				conn = DriverManager.getConnection(dbURL);
//				if(conn !=null) {
//					JOptionPane.showMessageDialog(null, "kết nối thành công");
//				}
//			} catch(SQLException ex) {
//				JOptionPane.showMessageDialog(null, ""+ex);
//			}
//		}
//
//		public static java.sql.Connection getConnection() {
//			// TODO Auto-generated method stub
//			return null;
//		}

//		private static String DB_URL = "jdbc:sqlserver://localhost;databaseName=qldatphongks;user=sa;password=123";
//    /**
//     * create connection
//     *
//     * @author viettuts.vn
//     * @param dbURL: database's url
//     * @param userName: username is used to login
//     * @param password: password is used to login
//     * @return connection
//     */
//    //thiết lập kết nối với URL đã cho
//    public static Connection getConnection() {
//        Connection conn = null;
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection(DB_URL);
//            System.out.println("connect successfully!");
//        }
//        //xu li ngoai le
//        catch (Exception ex) {
//            System.out.println("connect failure!");
//            //hien thi thong bao loi
//            ex.printStackTrace();
//        }
//        return conn;
//    }

		
	





