package btmvc_ver2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class view_dtb {
	// private static String url, user, pass= "";
	static int i = 0;
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String user = "root";
	private static String pass = "";
	private static DefaultTableModel model = new DefaultTableModel();
	private static String[][] data;
	private static JTable tbl;

	public static Connection getConnection(String url, String user, String pass) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection Success");
		} catch (Exception ex) {
			System.out.println("Connection Fail");
			ex.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) throws SQLException {
		JFrame f = new JFrame();
		data = new String[100][4];
		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("GENDER");
		model.addColumn("PIC");
		Connection conn = DriverManager.getConnection(url, user, pass);
		Statement stm = (Statement) conn.createStatement();
		ResultSet rs = stm.executeQuery("Select * from tbl_sv");
		while (rs.next()) {
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getInt(3) + "";
			data[i][3] = rs.getString(4);
			String[] d = { data[i][0], data[i][1], data[i][2], data[i][3] };
			model.addRow(d);
			i++;
		}
		conn.close();
		final JMenuBar menuBar = new JMenuBar(); // Tao cac menu
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        final JMenu aboutMenu = new JMenu("About");
        final JMenu linkMenu = new JMenu("Links");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);
        menuBar.add(linkMenu);
		JPanel pnTbl = new JPanel();
		JPanel pnBtn = new JPanel();
		pnBtn.setLayout(new FlowLayout());
		JButton btnAdd = new JButton("Thêm");
		JButton btnFix = new JButton("Sửa");
		JButton btnDel = new JButton("Xóa");
		pnBtn.add(btnAdd);
		pnBtn.add(btnFix);
		pnBtn.add(btnDel);
		tbl = new JTable(model);
		tbl.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(tbl);
		pnTbl.add(sp, BorderLayout.CENTER);
		f.setLayout(new BorderLayout());
		f.setJMenuBar(menuBar);
		f.add(sp, BorderLayout.CENTER);
		f.add(pnBtn, BorderLayout.SOUTH);
		f.setSize(500, 500);
		f.setVisible(true);
	}
}