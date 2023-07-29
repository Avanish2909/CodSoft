//package com.ap.tech;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import javax.swing.JOptionPane;
//
//public class StudentDao implements ActionListener {
//
//	StudentD1 t3 = new StudentD1();
//	private Connection con;
//	PreparedStatement pst;
//
//	
//	public void connect() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem");
//			
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public void actionPerformed(ActionEvent e) {
////	System.exit(1);
//		
//		
//		try {
//			pst = con.prepareStatement("insert into student_m_s(uname,uroll_no,ucourse,ugrade,umobile,uemail,uaddress) values(?,?,?,?,?,?,?)");
//			pst.setString(1, t3.uname);
//			pst.setString(2, t3.uroll_no);
//			pst.setString(3, t3.ucourse);
//			pst.setString(4, t3.ugrade);
//			pst.setString(5, t3.umobile);
//			pst.setString(6, t3.uemail);
//			pst.setString(7, t3.uaddress);
//			pst.executeUpdate();
//			JOptionPane.showMessageDialog(null, "record Added..");
//			
//			
//			
//		}catch (Exception e1) {
//			// TODO: handle exception
//			e1.printStackTrace();
//		}
//	
//	}
//	
//}
//
