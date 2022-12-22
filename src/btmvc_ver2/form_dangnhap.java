package btmvc_ver2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class form_dangnhap {
	JFrame loginFrame;
	JButton btnLogin, btnCancel;
	JTextField txUser, txPass;
	public form_dangnhap() {
		loginFrame = new JFrame("Đăng nhập: ");
		JPanel jpnTxt = new JPanel();
		jpnTxt.setLayout(new GridLayout(2,2));
		txUser = new JTextField();
		txPass = new JTextField();
		jpnTxt.add(new JLabel("Tài khoản: "));
		jpnTxt.add(txUser);
		jpnTxt.add(new JLabel("Mật khẩu: "));
		jpnTxt.add(txPass);
		JPanel jpnBtn = new JPanel();
		jpnBtn.setLayout(new GridLayout(1,2));
		btnLogin = new JButton("Đăng nhập");
		btnCancel = new JButton("Reset");
		jpnBtn.add(btnLogin);
		jpnBtn.add(btnCancel);
		loginFrame.setLayout(new BorderLayout());
		loginFrame.add(jpnTxt,BorderLayout.NORTH);
		loginFrame.add(jpnBtn, BorderLayout.SOUTH);
	}
}
