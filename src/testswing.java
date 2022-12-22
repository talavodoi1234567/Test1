
import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.GridLayout;
//import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class testswing {
    public static void main(String[] args) {
        JFrame f = new JFrame("Calculator");
        f.setBackground(Color.BLUE);
        JTextField txt = new JTextField();
        txt.setSize(1000, 100);
        txt.setText("0");
        JPanel jpn1 = new JPanel();
        JPanel jpn2 = new JPanel();
        JButton bt1 = new JButton("1");
        JButton bt2 = new JButton("2");
        JButton bt3 = new JButton("3");
        JButton bt4 = new JButton("4");
        JButton bt5 = new JButton("5");
        JButton bt6 = new JButton("6");
        JButton bt7 = new JButton("7");
        JButton bt8 = new JButton("8");
        JButton bt9 = new JButton("9");
        JButton bt0 = new JButton("0");
        JButton btdot = new JButton(".");
        JButton btC = new JButton("C");
        JButton btcong = new JButton("+");
        JButton bttru = new JButton("-");
        JButton btnhan = new JButton("*");
        JButton btchia = new JButton("/");
        JButton btbang = new JButton("=");
//        bt1.setForeground(Color.red);
//        bt1.setBackground(Color.BLACK);
//        bt1.setFont(new Font("serif", Font.BOLD, 19));
        bt2.setForeground(Color.gray);
        bt2.setBackground(Color.red);
        jpn1.setBackground(Color.red);
        jpn2.setBackground(Color.GREEN);
        f.setSize(500, 500);
        jpn1.setLayout(new GridLayout(4, 3));
        jpn2.setLayout(new GridLayout(5, 1));
        jpn1.add(bt1);
        jpn1.add(bt2);
        jpn1.add(bt3);
        jpn1.add(bt4);
        jpn1.add(bt5);
        jpn1.add(bt6);
        jpn1.add(bt7);
        jpn1.add(bt8);
        jpn1.add(bt9);
        jpn1.add(bt0);
        jpn1.add(btdot);
        jpn1.add(btC);
        jpn2.add(btcong);
        jpn2.add(bttru);
        jpn2.add(btnhan);
        jpn2.add(btchia);
        jpn2.add(btbang);
        f.setVisible(true);
        txt.setHorizontalAlignment(SwingConstants.RIGHT);
        txt.setEditable(false);
        f.add(txt, BorderLayout.NORTH);
        f.add(jpn1, BorderLayout.CENTER);
        f.add(jpn2, BorderLayout.EAST);
        
    }
}
