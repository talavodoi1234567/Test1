package btmvc;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dangnhap {
	public static String url, user, pass;
	public static Connection conn = null;

	public static void main(String[] args) {
		// ket noi csdl
		try {
			url = "jdbc:mysql://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("Connect Successful");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// form dang nhap
		JFrame loginFrame = new JFrame("Dang nhap");
		JTextField tUser = new JTextField("Tai khoan: ");
		tUser.setEditable(false);
		JTextField tPass = new JTextField("Mat khau: ");
		tPass.setEditable(false);
		JTextField txUser = new JTextField();
		JTextField txPass = new JTextField();
		JPanel jpnTxt = new JPanel();
		jpnTxt.setLayout(new GridLayout(2, 2));
		jpnTxt.add(tUser);
		jpnTxt.add(txUser);
		jpnTxt.add(tPass);
		jpnTxt.add(txPass);
		JPanel jpnBt = new JPanel();
		JButton ok = new JButton("OK");
		JButton signUp = new JButton("Dang ky");
		JButton reset = new JButton("Cancel");
		jpnBt.setLayout(new GridLayout(1, 3));
		jpnBt.add(ok);
		jpnBt.add(signUp);
		jpnBt.add(reset);
		loginFrame.add(jpnTxt, BorderLayout.NORTH);
		loginFrame.add(jpnBt, BorderLayout.SOUTH);
		loginFrame.setSize(500, 500);
		loginFrame.setVisible(true);

		//form them moi
		JFrame addFrame = new JFrame("Them moi");
		JTextField addUser = new JTextField("ID: ");
		JTextField addTUser = new JTextField();
		JTextField addName = new JTextField("Họ tên: ");
		JTextField addTName = new JTextField();
		JTextField addGender = new JTextField("Giới tính");
		JTextField addTGender = new JTextField();
		JTextField addLink = new JTextField("Link");
		JTextField addTLink = new JTextField();
		addUser.setEditable(false);
		addName.setEditable(false);
		addGender.setEditable(false);
		addLink.setEditable(false);
		JButton btnAddOk = new JButton("OK");
		JButton btnAddReset = new JButton("Reset");
		JPanel jpnTxtAdd = new JPanel();
		jpnTxtAdd.setLayout(new GridLayout(4,2));
		jpnTxtAdd.add(addUser);
		jpnTxtAdd.add(addTUser);
		jpnTxtAdd.add(addName);
		jpnTxtAdd.add(addTName);
		jpnTxtAdd.add(addGender);
		jpnTxtAdd.add(addTGender);
		jpnTxtAdd.add(addLink);
		jpnTxtAdd.add(addTLink);
		JPanel jpnBtnAdd = new JPanel();
		jpnBtnAdd.setLayout(new GridLayout(1,2));
		jpnBtnAdd.add(btnAddOk);
		jpnBtnAdd.add(btnAddReset);
		addFrame.add(jpnTxtAdd, BorderLayout.NORTH);
		addFrame.add(jpnBtnAdd, BorderLayout.SOUTH);
		addFrame.setLocation(500, 500);
		addFrame.setSize(400,600);
		addFrame.setVisible(false);
		
		// form dang ky
//		JFrame signUpFrame = new JFrame("Dang ky");
//		JTextField txtUser = new JTextField("Tai khoan: ");
//		tUser.setEditable(false);
//		JTextField txtPass = new JTextField("Mat khau: ");
//		tPass.setEditable(false);
//		JTextField txtResPass = new JTextField("Nhap lai mat khau: ");
//		JTextField signUpUser = new JTextField();
//		JTextField signUpPass = new JTextField();
//		JPanel jpnTxt1 = new JPanel();
//		jpnTxt.setLayout(new GridLayout(3, 2));
//		jpnTxt.add(tUser);
//		jpnTxt.add(txUser);
//		jpnTxt.add(tPass);
//		jpnTxt.add(txPass);
//		signUpFrame.setVisible(false);

		// form bang
		String sql1 = "SELECT * FROM tbl_sv";
		ResultSet resultSet = null;
		DefaultTableModel model = new DefaultTableModel();
		String[][] data = new String[50][4];
		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("GENDER");
		model.addColumn("PIC");
		try {
			int i = 0;
			Statement statement = (Statement) conn.createStatement();
			resultSet = statement.executeQuery(sql1);
			while (resultSet.next()) {
				{
					data[i][0] = resultSet.getString(1);
					data[i][1] = resultSet.getString(2);
					data[i][2] = resultSet.getInt(3) + "";
					data[i][3] = resultSet.getString(4);
					String[] d = {data[i][0], data[i][1], data[i][2], data[i][3]};
					model.addRow(d);
					i++;
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		JFrame tableFrame = new JFrame("abcdxyz");
		JTable tblTest = new JTable(model);
		JButton btnAdd = new JButton("Them moi");
		JButton btnFix = new JButton("Sua");
		JButton btnDel = new JButton("Xoa");
		tableFrame.add(tblTest, BorderLayout.NORTH);
		JPanel framePanel = new JPanel();
		framePanel.setLayout(new GridLayout(1, 3));
		framePanel.add(btnAdd);
		framePanel.add(btnFix);
		framePanel.add(btnDel);
		tableFrame.add(framePanel, BorderLayout.SOUTH);
		tableFrame.setSize(700, 500);
		tableFrame.setVisible(false);

		// action
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user = txUser.getText();
				pass = txPass.getText();
				ResultSet resultSet = null;

				// Connection conn = null;
				try {
					// db parameters
					Statement statement = (Statement) conn.createStatement();
					String sql = "SELECT * FROM test1 WHERE id =" + user;
					resultSet = statement.executeQuery(sql);
					while (resultSet.next()) {
						// System.out.println(resultSet.getString(1) + "|" + resultSet.getString(2));
						if (pass.equals(resultSet.getString(2))) {
							System.out.println("Dang nhap thanh cong");
							loginFrame.setVisible(false);
							tableFrame.setVisible(true);
						}
					}
					System.out.print("Success");
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}finally {
					if (conn != null)
						try {
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
//		signUp.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				loginFrame.setVisible(false);
//				signUpFrame.setVisible(true);
//			}
//		});
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				txUser.setText("");
				txPass.setText("");
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addFrame.setVisible(true);
			}
		});
		btnFix.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnAddOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ket noi lai
				try {
					url = "jdbc:mysql://localhost:3306/test";
					conn = DriverManager.getConnection(url, "root", "");
					System.out.println("Connect Successful");
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
				int id = Integer.parseInt(addTUser.getText());
				String name = addTName.getText();
				int gender = Integer.parseInt(addTGender.getText());
				String link = addTLink.getText();
				String sql = "INSERT INTO tbl_sv (ID, NAME, GENDER, PIC) VALUES (" + id + ", '" + name + "', " + gender + ", '" + link + "')";
				try {
					Statement stm = (Statement) conn.createStatement();
					int rst = stm.executeUpdate(sql);
					if (rst > 0) System.out.println("ROW INSERTED");
					else System.out.println("ROW NOT INSERTED");
				}catch(SQLException exc) {
					System.out.println(exc.getMessage());
				}finally {
					System.out.println(sql);
				}
			}
		});
		btnAddReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addTUser.setText("");
				addTName.setText("");
				addTGender.setText("");
				addTLink.setText("");
			}
		});
//		try {
//			if (conn != null)
//				conn.close();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	}
}
