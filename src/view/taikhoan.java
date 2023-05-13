package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TaiKhoanDAO;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class taikhoan extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField txttaikhoan;
	private JPasswordField txtpassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taikhoan frame = new taikhoan();
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
	public taikhoan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 737, 456);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER LOGIN\r\n");
		lblNewLabel.setIcon(new ImageIcon(taikhoan.class.getResource("/ICON/eeeeeeeeeeeeeee.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(168, 21, 383, 169);
		panel.add(lblNewLabel);
		
		txttaikhoan = new JTextField();
		txttaikhoan.setBounds(194, 225, 289, 38);
		panel.add(txttaikhoan);
		txttaikhoan.setColumns(10);
		
		JButton txtlogin = new JButton("LOG IN");
		txtlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username = txttaikhoan.getText();
				String Pass = String.valueOf(txtpassword.getPassword());
				TaiKhoanDAO dao = new TaiKhoanDAO();
				if(dao.getLogin(Username, Pass)) {
					//JOptionPane.showMessageDialog(null, "Login successfully");
					view.Phong phong = new view.Phong();
					phong.setVisible(true);
					this.setVisible(false);
					 dispose();
				} else {
		            JOptionPane.showMessageDialog(null, "Wrong username or password");
		        }
						
				
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}

		});
		
		txtlogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtlogin.setBounds(137, 363, 442, 43);
		panel.add(txtlogin);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(194, 297, 289, 43);
		panel.add(txtpassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsername.setBounds(25, 214, 123, 55);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(25, 297, 123, 55);
		panel.add(lblPassword);
	}
}
