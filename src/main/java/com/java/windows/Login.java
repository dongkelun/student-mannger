package com.java.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.java.model.MyButton;
import com.java.model.MyLabel;
import com.java.model.MyTextField;
import com.java.model.MyWindow;
import com.java.utils.Constant;
import com.java.utils.JDBCutils;
import com.java.utils.WindowCache;

/**
 * 登录界面
 */
public class Login extends MyWindow {

	private static final long serialVersionUID = -5827259697504944024L;

	public Login() {
		initialWindow("登录", "管理员登录", new int[] { 203, 31, 216, 55 });
		addComponent();
	}

	public void addComponent() {
		contentPane.add(new MyLabel("账号：", 142, 119, 66, 30));
		contentPane.add(new MyLabel("密码：", 142, 193, 66, 30));

		MyTextField textField = new MyTextField(Constant.ID, 227, 122, 192, 29);
		contentPane.add(textField);

		JPasswordField passwordField = new JPasswordField(Constant.PASSWORD);
		passwordField.setBounds(227, 195, 192, 29);
		contentPane.add(passwordField);

		MyButton button_login = new MyButton("登录", 20, 270, 310, 98, 38);
		//        监听登录按钮
		button_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				{
					loginConfirm(textField.getText(), new String(passwordField.getPassword()));
				}
			}
		});
		contentPane.add(button_login);
		//      监听密码框按回车
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					button_login.doClick();
				}
			}
		});

	}

	/**
	 * 验证管理员登录
	 *
	 * @param id       管理员账户
	 * @param password 管理员密码
	 */
	public void loginConfirm(String id, String password) {
		if (id.equals(Constant.ID) && password.equals(Constant.PASSWORD)) {
			WindowCache.showWindow("home_page");
			setVisible(false);
			JDBCutils.getConnection();//打开数据库连接
		} else {
			JOptionPane.showMessageDialog(null, "用户名或密码错误！", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}

}
