package com.ap.tech;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import net.proteanit.sql.DbUtils;

public class StudentD1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel contentPane2;
	private JPanel contentPane3;
	private JPanel contentPane4;
	private JPanel contentPane5;
	private JPanel contentPane6;
	
	private JTable table;
	private JTable table1;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	
	private JButton btnNewButton;
	private String uname,uroll_no,ucourse,ugrade,umobile,uemail,uaddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentD1 frame = new StudentD1();
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
	public StudentD1() {
		
//		
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowActivated(WindowEvent e) {
//				
//			}
//		});
//		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Account Section");
		lblNewLabel_1.setBounds(330, 114, 324, 61);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Student Management System");
		lblNewLabel.setBounds(27, 0, 963, 85);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBackground(new Color(204, 255, 255));
		contentPane.add(lblNewLabel);
		
		JButton btnAddButton = new JButton("Add Student");
		btnAddButton.setActionCommand("add");
		btnAddButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddButton.setBounds(121, 198, 203, 49);
		contentPane.add(btnAddButton);
		btnAddButton.addActionListener((ActionListener) this);
		
		
		JButton btnNewButton_6_1 = new JButton(" Delete Student");
		btnNewButton_6_1.setActionCommand("delete");
		btnNewButton_6_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_6_1.setBounds(121, 278, 203, 49);
		contentPane.add(btnNewButton_6_1);
		btnNewButton_6_1.addActionListener(this);
		
		JButton btnNewButton_6_2 = new JButton("Exit");
		btnNewButton_6_2.setActionCommand("exit");
		btnNewButton_6_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_6_2.setBounds(344, 353, 165, 58);
		contentPane.add(btnNewButton_6_2);
		btnNewButton_6_2.addActionListener(this);
		
		JButton btnNewButton_6_3 = new JButton("Search Student");
		btnNewButton_6_3.setActionCommand("search");
		btnNewButton_6_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_6_3.setBounds(567, 206, 209, 49);
		contentPane.add(btnNewButton_6_3);
		btnNewButton_6_3.addActionListener(this);
		
		JButton btnNewButton_6_4 = new JButton("Display All Students");
		btnNewButton_6_4.setActionCommand("display");
		btnNewButton_6_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_6_4.setBounds(565, 278, 259, 49);
		contentPane.add(btnNewButton_6_4);
		btnNewButton_6_4.addActionListener(this);
		
	}
	
	Connection con1;
	PreparedStatement pst;
	ResultSet rs;
	
	public void connect1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem","root","Avanish@123");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void table_load() {
		try {
			pst = con1.prepareStatement("select * from student_m_s");
			rs = pst.executeQuery();
			table1.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	//*******Add Section.........
			public void actionPerformed(ActionEvent e) {
				
//				StudentDao s1 = new StudentDao();
				Student1 s2 = new Student1();
				s2.connect2();
//				s1.connect();
			
				String actionCommand = ((JButton) e.getSource()).getActionCommand();
				switch (actionCommand) {
				case "add": {
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 1092, 591);
					contentPane2 = new JPanel();
					contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
			
					setContentPane(contentPane2);
					contentPane2.setLayout(null);
					
					JPanel panel = new JPanel();
					panel.setBounds(31, 108, 1019, 325);
					contentPane2.add(panel);
					panel.setLayout(null);
					
					JLabel lblNewLabel_1 = new JLabel("Student name");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
					lblNewLabel_1.setBounds(65, 43, 199, 43);
					panel.add(lblNewLabel_1);
					
					textField = new JTextField();
					textField.setBounds(274, 58, 199, 25);
					panel.add(textField);
					textField.setColumns(10);
					
					JLabel lblNewLabel_1_1 = new JLabel("Roll No.");
					lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
					lblNewLabel_1_1.setBounds(65, 116, 199, 43);
					panel.add(lblNewLabel_1_1);
					
					JLabel lblNewLabel_1_2 = new JLabel("Course.");
					lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
					lblNewLabel_1_2.setBounds(65, 181, 199, 43);
					panel.add(lblNewLabel_1_2);
					
					JLabel lblNewLabel_1_3 = new JLabel("Grade");
					lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 25));
					lblNewLabel_1_3.setBounds(65, 249, 199, 43);
					panel.add(lblNewLabel_1_3);
					
					textField_1 = new JTextField();
					textField_1.setColumns(10);
					textField_1.setBounds(274, 131, 199, 25);
					panel.add(textField_1);
					
					textField_2 = new JTextField();
					textField_2.setColumns(10);
					textField_2.setBounds(274, 196, 199, 25);
					panel.add(textField_2);
					
					textField_3 = new JTextField();
					textField_3.setColumns(10);
					textField_3.setBounds(274, 264, 199, 25);
					panel.add(textField_3);
					
					JLabel lblNewLabel_1_4 = new JLabel("Mobile.No.");
					lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 25));
					lblNewLabel_1_4.setBounds(585, 46, 154, 43);
					panel.add(lblNewLabel_1_4);
					
					textField_4 = new JTextField();
					textField_4.setColumns(10);
					textField_4.setBounds(760, 61, 211, 25);
					panel.add(textField_4);
					
					textField_5 = new JTextField();
					textField_5.setColumns(10);
					textField_5.setBounds(760, 144, 211, 25);
					panel.add(textField_5);
					
					JLabel lblNewLabel_1_4_1 = new JLabel("Email Id");
					lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 25));
					lblNewLabel_1_4_1.setBounds(585, 131, 154, 43);
					panel.add(lblNewLabel_1_4_1);
					
					JLabel lblNewLabel_1_4_2 = new JLabel("Address");
					lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 25));
					lblNewLabel_1_4_2.setBounds(585, 227, 154, 43);
					panel.add(lblNewLabel_1_4_2);
					
					textField_6 = new JTextField();
					textField_6.setColumns(10);
					textField_6.setBounds(760, 242, 211, 25);
					panel.add(textField_6);
					
					JLabel lblNewLabel = new JLabel("Add Section");
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
					lblNewLabel.setBounds(342, 27, 280, 88);
					contentPane2.add(lblNewLabel);
					
					btnNewButton = new JButton("Submit");
					btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
					btnNewButton.setBounds(464, 455, 145, 55);
					contentPane2.add(btnNewButton);
					btnNewButton.setActionCommand("sAdd");
					btnNewButton.addActionListener(s2);
					
					/*
					JButton btnBack = new JButton("Back");
					btnBack.setFont(new Font("Tahoma", Font.BOLD, 30));
					btnBack.setBounds(552, 455, 145, 55);
					contentPane2.add(btnBack);
					btnBack.setActionCommand("aBack");
					btnBack.addActionListener(s2);
					*/
					
					break;
				}
				
				
				case "delete": {
					
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 780, 407);
					contentPane4 = new JPanel();
					contentPane4.setBorder(new EmptyBorder(5, 5, 5, 5));

					setContentPane(contentPane4);
					contentPane4.setLayout(null);
					
					JLabel lblDeleteSection = new JLabel("Delete Section");
					lblDeleteSection.setBounds(242, 10, 293, 49);
					lblDeleteSection.setFont(new Font("Tahoma", Font.BOLD, 40));
					contentPane4.add(lblDeleteSection);
					
					JLabel lblNewLabel_1 = new JLabel("Search Student for Delete");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
					lblNewLabel_1.setBounds(32, 124, 351, 43);
					contentPane4.add(lblNewLabel_1);
					
					textField_15 = new JTextField();
					textField_15.setColumns(10);
					textField_15.setBounds(446, 139, 233, 25);
					contentPane4.add(textField_15);
					
					JButton btnDelete = new JButton("Delete");
					btnDelete.setFont(new Font("Tahoma", Font.BOLD, 30));
					btnDelete.setBounds(300, 242, 145, 55);
					contentPane4.add(btnDelete);
					btnDelete.setActionCommand("udelete");
					btnDelete.addActionListener(s2);
					
					break;
				}
				case "exit": {
					System.exit(0);
					break;
				}
				case "search": {
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 1090, 616);
					contentPane5 = new JPanel();
					contentPane5.setBorder(new EmptyBorder(5, 5, 5, 5));

					setContentPane(contentPane5);
					contentPane5.setLayout(null);
					
					JLabel lblSearchSection = new JLabel("Search Section");
					lblSearchSection.setFont(new Font("Tahoma", Font.BOLD, 40));
					lblSearchSection.setBounds(228, 10, 331, 49);
					contentPane5.add(lblSearchSection);
					
					JLabel lblNewLabel_1 = new JLabel("Search for a Student");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
					lblNewLabel_1.setBounds(56, 122, 351, 59);
					contentPane5.add(lblNewLabel_1);
					
					textField_14 = new JTextField();
					textField_14.setColumns(10);
					textField_14.setBounds(442, 136, 233, 25);
					contentPane5.add(textField_14);
					
					JButton btnSearch = new JButton("Search");
					btnSearch.setFont(new Font("Tahoma", Font.BOLD, 30));
					btnSearch.setBounds(307, 227, 145, 55);
					contentPane5.add(btnSearch);
					btnSearch.setActionCommand("usearch");
					btnSearch.addActionListener(s2);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(26, 350, 1028, 114);
					contentPane5.add(scrollPane);
					
					table1 = new JTable();
					scrollPane.setViewportView(table1);
										
					
					break;
				}
				case "display": {
					
					
					
//					Student1 l =new Student1();
					connect1();
					
//					try {
//						pst = con1.prepareStatement("select * from student_m_s");
//						rs = pst.executeQuery();
//						table1.setModel(DbUtils.resultSetToTableModel(rs));
//					}catch (SQLException e1) {
//						// TODO: handle exception
//						e1.printStackTrace();
//					}
//					table.setModel(DbUtils.resultSetToTableModel(l.rs));
					
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 1210, 681);
					contentPane6 = new JPanel();
					contentPane6.setBorder(new EmptyBorder(5, 5, 5, 5));

					setContentPane(contentPane6);
					contentPane6.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("Display Section");
					lblNewLabel.setBounds(422, 10, 335, 49);
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
					contentPane6.add(lblNewLabel);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(39, 86, 1110, 524);
					contentPane6.add(scrollPane);
					
					table1 = new JTable();
					table_load();
					scrollPane.setViewportView(table1);
					
					
					break;
				}

				default:
					throw new IllegalArgumentException("Unexpected value: " + actionCommand);
				}
				
				
//				btnNewButton.addActionListener(this);
				
				
				
				
				
				
				
			}
	
		//	***************
	
		
			public void actionPerformed1(ActionEvent e) {
				System.exit(0);
			}
//			
			
			
			class Student1 implements ActionListener{
				
				Connection con2;
				PreparedStatement pst;
				ResultSet rs;
				
				public void connect2() {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem","root","Avanish@123");
						
						
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
//				public void table_load() {
//					try {
//						pst = con2.prepareStatement("select * from student_m_s");
//						rs = pst.executeQuery();
//						table.setModel(DbUtils.resultSetToTableModel(rs));
//					}catch (SQLException e) {
//						// TODO: handle exception
//						e.printStackTrace();
//					}
//				}
				
				
//				public void table_load1() {
//					try {
//						pst = con2.prepareStatement("select * from student_m_s");
//						rs = pst.executeQuery();
//						table.setModel(DbUtils.resultSetToTableModel(rs));
//					}catch (SQLException e) {
//						// TODO: handle exception
//						e.printStackTrace();
//					}
//				}
				
				

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String ActionCommond = ((JButton)e.getSource()).getActionCommand();
					switch (ActionCommond) {
					case "sAdd": {
						

						
						//getting data of add section....
						uname = textField.getText();
						uroll_no = textField_1.getText();
						ucourse = textField_2.getText();
						ugrade = textField_3.getText();
						umobile = textField_4.getText();
						uemail = textField_5.getText();
						uaddress = textField_6.getText();
						
						
						try {
							pst = con2.prepareStatement("insert into student_m_s(uname,uroll_no,ucourse,ugrade,umobile,uemail,uaddress) values(?,?,?,?,?,?,?)");
							pst.setString(1, uname);
							pst.setString(2, uroll_no);
							pst.setString(3, ucourse);
							pst.setString(4, ugrade);
							pst.setString(5, umobile);
							pst.setString(6, uemail);
							pst.setString(7, uaddress);
							pst.executeUpdate();
							pst.close();
							JOptionPane.showMessageDialog(null, "record Added..");
							

//							table_load();
							
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
							textField_6.setText("");		
												
							
						}catch (Exception e1) {
							// TODO: handle exception
							e1.printStackTrace();
						}
						
					
						
						break;
					}
					case "usearch": {
									
						//for search a single data
						String uid = textField_14.getText();
						
						try {
							pst = con2.prepareStatement("select uname,uroll_no,ucourse,ugrade,umobile,uemail,uaddress from student_m_s where uid=?");
							pst.setString(1, uid);
							rs = pst.executeQuery();
							table1.setModel(DbUtils.resultSetToTableModel(rs));
							
							
							textField_14.setText("");
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						break;					
					}
					case "udelete": {
						
						String id = textField_15.getText();
						
						try {
							pst = con2.prepareStatement("delete from student_m_s where uid=?");
							pst.setString(1, id);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Recored deleted...");
							
							textField_15.setText("");
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						break;					
					}
					
					
					default:
						throw new IllegalArgumentException("Unexpected value: " + ActionCommond);
					}
					
					
					
							
				}
				
				
			}
			
			

}
