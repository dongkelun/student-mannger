package com.java.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.java.model.MyButton;
import com.java.model.MyWindow;
import com.java.utils.Constant;
import com.java.utils.WindowCache;

/**
 * 主页
 */
public class HomePage extends MyWindow {

	private static final long serialVersionUID = -8554811366556990819L;

	/**
	 * Create the frame.
	 */
	public HomePage() {
		initialWindow("学籍管理系统", " 欢迎使用学籍管理系统", new int[] { 108, 53, 466, 55 });

		//set the image label
		JLabel image_label = new JLabel();
		image_label.setBounds(394, 171, 196, 196);
		contentPane.add(image_label);
		image_label.setHorizontalAlignment(SwingConstants.RIGHT);
		image_label.setVerticalAlignment(SwingConstants.BOTTOM);
		image_label.setIcon(new ImageIcon(Constant.BAYMAX));

		MyButton button_student_info = new MyButton("学生信息管理", 21, 108, 190, 229, 35);
		button_student_info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				{
					new ShowStudentInfo().setVisible(true);
					setVisible(false);
				}
			}
		});
		contentPane.add(button_student_info);

		MyButton button_student_mark = new MyButton("学生成绩管理", 21, 108, 260, 229, 35);
		button_student_mark.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				{
					new ShowStudentMark().setVisible(true);
					setVisible(false);
				}
			}
		});
		contentPane.add(button_student_mark);

		MyButton button_about = new MyButton("关于作者", 21, 108, 330, 229, 35);
		button_about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				{
					WindowCache.showWindow("about_us");
					setVisible(false);
				}
			}
		});
		contentPane.add(button_about);

		MyButton button_logout = new MyButton("返回登录", 21, 108, 400, 229, 35);
		button_logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowCache.showWindow("login");
				setVisible(false);
			}
		});
		contentPane.add(button_logout);

	}

}
