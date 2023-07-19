package com.ap;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddressBookSystem {

	private JFrame frame;
	private JTextField txtbname;
	private JTextField txtbphone;
	private JTextField txtbemail;
	private JTable table;
	private JTextField textbid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressBookSystem window = new AddressBookSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public AddressBookSystem() {
		initialize();
		Connect();
		table_load();
	}
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtuname;
	
	public void Connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/addressbooksystem","root","Avanish@123");
			
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	
	public void table_load() {
		try {
			pst = con.prepareStatement("select * from book");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1322, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Address Book System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(363, 10, 337, 64);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(35, 84, 567, 218);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book_Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(40, 27, 128, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(40, 118, 93, 34);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(40, 162, 93, 34);
		panel.add(lblNewLabel_1_2);
		
		txtbname = new JTextField();
		txtbname.setBounds(203, 33, 289, 31);
		panel.add(txtbname);
		txtbname.setColumns(10);
		
		txtbphone = new JTextField();
		txtbphone.setBounds(203, 123, 289, 34);
		panel.add(txtbphone);
		txtbphone.setColumns(10);
		
		txtbemail = new JTextField();
		txtbemail.setBounds(203, 167, 289, 34);
		panel.add(txtbemail);
		txtbemail.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("User_Name");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(40, 71, 117, 34);
		panel.add(lblNewLabel_1_3);
		
		txtuname = new JTextField();
		txtuname.setColumns(10);
		txtuname.setBounds(203, 74, 289, 34);
		panel.add(txtuname);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bname,uname,bphone,bemail;
				
				bname = txtbname.getText();
				uname = txtuname.getText();
				bphone = txtbphone.getText();
				bemail = txtbemail.getText();
				
				try {
					pst = con.prepareStatement("insert into book(bname,uname,phone,email) values(?,?,?,?)");
					pst.setString(1, bname);
					pst.setString(2, uname);
					pst.setString(3, bphone);
					pst.setString(4, bemail);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Addeddd...");
					
					table_load();
					txtbname.setText("");
					txtuname.setText("");
					txtbphone.setText("");
					txtbemail.setText("");
					txtbname.requestFocus();
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(62, 325, 112, 53);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(225, 325, 106, 53);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Clear");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtbname.setText("");
				txtuname.setText("");
				txtbphone.setText("");
				txtbemail.setText("");
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(374, 325, 106, 53);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setBounds(624, 84, 654, 307);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(51, 402, 467, 76);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Id");
		lblNewLabel_1_1_1.setBounds(49, 13, 53, 38);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1_1_1);
		
		textbid = new JTextField();
		textbid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String id = textbid.getText();
					
					pst = con.prepareStatement("select bname,uname,phone,email from book where id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==true) {
						String bname = rs.getString(1);
						String uname = rs.getString(2);
						String phone = rs.getString(3);
						String email = rs.getString(4);
						
						txtbname.setText(bname);
						txtuname.setText(uname);
						txtbphone.setText(phone);
						txtbemail.setText(email);
						
					}else {
						txtbname.setText("");
						txtuname.setText("");
						txtbphone.setText("");
						txtbemail.setText("");
					}
					
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
				
			}
		});
		textbid.setColumns(10);
		textbid.setBounds(124, 20, 289, 34);
		panel_1.add(textbid);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bname,uname,bphone,bemail,bid;
				
				bname = txtbname.getText();
				uname = txtuname.getText();
				bphone = txtbphone.getText();
				bemail = txtbemail.getText();
				bid = textbid.getText();
				
				
				try {
					pst = con.prepareStatement("update book set bname=?, uname=?, phone=?, email=? where id=?");
					pst.setString(1, bname);
					pst.setString(2, uname);
					pst.setString(3, bphone);
					pst.setString(4, bemail);
					pst.setString(5, bid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record updateded...");
					
					table_load();
					txtbname.setText("");
					txtuname.setText("");
					txtbphone.setText("");
					txtbemail.setText("");
					txtbname.requestFocus();
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBounds(642, 422, 106, 53);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bid;
				
				bid = textbid.getText();
				
				try {
					pst = con.prepareStatement("delete from book where id=?");
					pst.setString(1, bid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Deleted...");
					
					table_load();
					txtbname.setText("");
					txtuname.setText("");
					txtbphone.setText("");
					txtbemail.setText("");
					txtbname.requestFocus();
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(796, 422, 112, 53);
		frame.getContentPane().add(btnDelete);
	}
}
