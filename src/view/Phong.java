package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.PhongDAO;
import model.PhongDTO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Phong extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txttinhtrang;
	private JTextField txtgiaphong;
	private JTextField txtloaiphong;
	private JTextField txttenphong;
	JTextField txtmaphong;
	private JTable table_1;
	
	
	private void loadData(String search) {
		
		 List<PhongDTO> phongList = PhongDAO.selectPhong(search);
       //Object[][] data = new Object[bookList.size()][5];
       String[] cloumn = new String[]{
           "Mã Phòng", "Tên Phòng", "Loại Phòng", "Giá Phòng", "Tình Trạng"
       };
       DefaultTableModel tableModel = new DefaultTableModel(cloumn, 0);
       for (int i = 0; i < phongList.size(); i++) {
           Object[] data = {phongList.get(i).getMaphong(),
           		phongList.get(i).getTenphong(),
           		phongList.get(i).getLoaiphong(),
           		phongList.get(i).getGiaphong(),
           		phongList.get(i).getTinhtrang()};
           tableModel.addRow(data);
       }

       table_1.setModel(tableModel);
       table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	
	        	txtmaphong.setText(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
	        	txttenphong.setText(table_1.getValueAt(table_1.getSelectedRow(), 1).toString());
	        	txtloaiphong.setText(table_1.getValueAt(table_1.getSelectedRow(), 2).toString());
	        	txtgiaphong.setText(table_1.getValueAt(table_1.getSelectedRow(), 3).toString());
	        	txttinhtrang.setText(table_1.getValueAt(table_1.getSelectedRow(), 4).toString());

	        }
	    });
		//List<Phong> selectPhong(String search)
		}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phong frame = new Phong();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Phong() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 959, 704);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Phòng\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(24, 100, 108, 37);
		panel.add(lblNewLabel);
		
		JLabel lblTnPhng = new JLabel("Tên Phòng\r\n");
		lblTnPhng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTnPhng.setBounds(24, 142, 108, 37);
		panel.add(lblTnPhng);
		
		JLabel lblLoiPhng = new JLabel("Loại Phòng\r\n");
		lblLoiPhng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoiPhng.setBounds(24, 179, 108, 37);
		panel.add(lblLoiPhng);
		
		JLabel lblGiPhng = new JLabel("Giá Phòng");
		lblGiPhng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiPhng.setBounds(24, 226, 108, 37);
		panel.add(lblGiPhng);
		
		JLabel lblTnhTrng = new JLabel("Tình Trạng");
		lblTnhTrng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTnhTrng.setBounds(24, 265, 108, 37);
		panel.add(lblTnhTrng);
		
		table = new JTable();
		table.setBackground(new Color(176, 224, 230));
	
		JLabel lblNewLabel_1 = new JLabel("Quản Lý Đặt Phòng");
		lblNewLabel_1.setIcon(new ImageIcon(Phong.class.getResource("/ICON/if_6_2247708.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(275, 27, 304, 46);
		panel.add(lblNewLabel_1);
		
		txttinhtrang = new JTextField();
		txttinhtrang.setColumns(10);
		txttinhtrang.setBounds(123, 273, 382, 29);
		panel.add(txttinhtrang);
		
		JButton tnnew = new JButton("Thêm");
		tnnew.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				 String maphong = txtmaphong.getText();
			        String tenphong = txttenphong.getText();
			        String loaiphong = txtloaiphong.getText();
			        String giaphong = txtgiaphong.getText();
			        String tinhtrang = txttinhtrang.getText();
			        PhongDTO phong = new PhongDTO(maphong, tenphong, loaiphong, giaphong, tinhtrang );
			        	PhongDAO dao = new PhongDAO();
			        if (dao.insertPhong(phong) >0) {
			            JOptionPane.showMessageDialog(null, "Thêm phòng thành công");
			            txtmaphong.setText("");
			            txttenphong.setText("");
			            txtloaiphong.setText("");
			            txtgiaphong.setText("");
			            txttinhtrang.setText("");
			            String search = txtmaphong.getText();
			            loadData(search);

			        } else {
			            JOptionPane.showMessageDialog(null, "thêm phòng không thành công");
			        }
			}
		});
	
		tnnew.setIcon(new ImageIcon(Phong.class.getResource("/ICON/oui-icons-21-32.png")));
		tnnew.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tnnew.setBounds(650, 124, 149, 37);
		panel.add(tnnew);
		
		JButton btnfind = new JButton("Tìm Kiếm");
		btnfind.setIcon(new ImageIcon(Phong.class.getResource("/ICON/search-icon-24.png")));
		btnfind.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String search = txtmaphong.getText();
			        loadData(search);
		}

		


		});

		btnfind.setBounds(650, 82, 149, 37);
		panel.add(btnfind);
		
		JButton btnupdate = new JButton("Cập Nhật");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 StringBuilder sb = new StringBuilder();
			        if (sb.length() > 0) {
			        	JOptionPane.showInputDialog(this, sb);	
			        	return;
			        }
			        try {
			           PhongDTO phong = new PhongDTO();
			           phong.setMaphong(txtmaphong.getText());
			           phong.setTenphong(txttenphong.getText());
			           phong.setLoaiphong(txtloaiphong.getText());
			           phong.setGiaphong(txtgiaphong.getText());
			           phong.setTinhtrang(txttinhtrang.getText());

			            PhongDAO dao = new PhongDAO();
			            dao.updatePhong(phong);
			            JOptionPane.showMessageDialog(null, "Update phòng thành công ");
			           String search = txtmaphong.getText();
			            loadData(search);
//			            return;
			        } catch (Exception ex) {
//			            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage());
//			            ex.printStackTrace();
			        }
			        txtmaphong.setText("");
			        txttenphong.setText("");
			        txtloaiphong.setText("");
			        txtgiaphong.setText("");
			        txttinhtrang.setText("");
				
			    }
			
		});
		btnupdate.setIcon(new ImageIcon(Phong.class.getResource("/ICON/Actions-document-edit-icon-32.png")));
		btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnupdate.setBounds(650, 171, 149, 37);
		panel.add(btnupdate);
		
		JButton btndelete = new JButton("Xóa");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maphong = txtmaphong.getText();
		
				 StringBuilder sb = new StringBuilder();
			        if (sb.length() > 0) {
			            JOptionPane.showInputDialog(this, sb);
			            return;
			        }
			        try {
			        	PhongDAO pD = new PhongDAO();
			        	pD.deletePhong(maphong);
//			        	 PhongDAO dao = new PhongDAO();
//			        	 dao.deletePhong(getName());
			            JOptionPane.showMessageDialog(null, "Xóa thành công ");
			            String search = txtmaphong.getText();
			            loadData(search);
			        } catch (Exception ex) {
//			            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage());
//			            ex.printStackTrace();
			        }
			        txtmaphong.setText("");
			        txttenphong.setText("");
			        txtloaiphong.setText("");
			        txtgiaphong.setText("");
			        txttinhtrang.setText("");
			    }
			
		});
		btndelete.setIcon(new ImageIcon(Phong.class.getResource("/ICON/XOA.png")));
		btndelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btndelete.setBounds(650, 218, 149, 37);
		panel.add(btndelete);
		
		txtgiaphong = new JTextField();
		txtgiaphong.setColumns(10);
		txtgiaphong.setBounds(123, 231, 382, 29);
		panel.add(txtgiaphong);
		
		txtloaiphong = new JTextField();
		txtloaiphong.setColumns(10);
		txtloaiphong.setBounds(123, 184, 382, 29);
		panel.add(txtloaiphong);
		
		txttenphong = new JTextField();
		txttenphong.setColumns(10);
		txttenphong.setBounds(123, 143, 382, 29);
		panel.add(txttenphong);
		
		txtmaphong = new JTextField();
		txtmaphong.setColumns(10);
		txtmaphong.setBounds(123, 106, 382, 29);
		panel.add(txtmaphong);
		
		JButton btnfirst = new JButton("");
		btnfirst.setIcon(new ImageIcon(Phong.class.getResource("/ICON/Button-First-icon-48.png")));
		btnfirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnfirst.setBounds(158, 338, 96, 49);
		panel.add(btnfirst);
		
		JButton btnback = new JButton("");
		btnback.setIcon(new ImageIcon(Phong.class.getResource("/ICON/Fast-backward-icon-48.png")));
		btnback.setBounds(275, 338, 96, 49);
		panel.add(btnback);
		
		JButton btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(Phong.class.getResource("/ICON/Fast-forward-icon-48.png")));
		btnNext.setBounds(381, 338, 96, 49);
		panel.add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.setIcon(new ImageIcon(Phong.class.getResource("/ICON/Button-Last-icon-48.png")));
		btnLast.setBounds(487, 338, 96, 49);
		panel.add(btnLast);
		
		JButton btnthoat = new JButton("Thoát");
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnthoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnthoat.setBounds(672, 641, 96, 42);
		panel.add(btnthoat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

		        String maphong = table_1.getValueAt(table_1.getSelectedRow(), 0).toString();
		        String tenphong = table_1.getValueAt(table_1.getSelectedRow(), 1).toString();
		        String loaiphong = table_1.getValueAt(table_1.getSelectedRow(), 2).toString();
		        String giaphong = table_1.getValueAt(table_1.getSelectedRow(), 3).toString();
		        String tinhtrang = table_1.getValueAt(table_1.getSelectedRow(), 4).toString();
		        txtmaphong.setText(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
		        txttenphong.setText(table_1.getValueAt(table_1.getSelectedRow(), 1).toString());
		        txtloaiphong.setText(table_1.getValueAt(table_1.getSelectedRow(), 2).toString());
		        txtgiaphong.setText(table_1.getValueAt(table_1.getSelectedRow(), 3).toString());
		        txttinhtrang.setText(table_1.getValueAt(table_1.getSelectedRow(), 4).toString());
			}
			
		});
		

		
		scrollPane.setBounds(66, 415, 644, 216);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Ph\u00F2ng", "T\u00EAn Ph\u00F2ng", "Lo\u1EA1i Ph\u00F2ng", "Gi\u00E1 Ph\u00F2ng", "T\u00ECnh Tr\u1EA1ng"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(0).setMinWidth(20);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(1).setMinWidth(20);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(2).setMinWidth(20);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(3).setMinWidth(20);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(4).setMinWidth(20);
		
		scrollPane.setViewportView(table_1);
		
		JButton btnLammoi = new JButton("Làm mới");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = txtmaphong.getText();
		        loadData(search);
			}
		});
		btnLammoi.setBounds(650, 291, 85, 21);
		panel.add(btnLammoi);
		PhongDAO dao = new PhongDAO();
		loadData("");
		
		
	}
}
