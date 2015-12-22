package com.java.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import com.java.model.MyButton;
import com.java.model.MyButtonPanel;
import com.java.model.MyLabel;
import com.java.model.MyTableInfoModel;
import com.java.model.MyTextField;
import com.java.model.MyWindow;
import com.java.utils.ConfirmInput;
import com.java.utils.JDBCutils;
import com.java.utils.WindowCache;

/**
 * 添加学生的界面
 */
public class AddStudentInfo extends MyWindow {

	private static final long serialVersionUID = 9009252828762370679L;

	private String gender = "无";

	public AddStudentInfo() {
		initialWindow("添加学生信息", "添加学生信息", new int[] { 192, 24, 279, 55 });

		contentPane.add(new MyLabel("学号：", 120));
		contentPane.add(new MyLabel("姓名：", 170));
		contentPane.add(new MyLabel("生日：", 220));
		contentPane.add(new MyLabel("性别：", 270));
		contentPane.add(new MyLabel("年龄：", 320));
		contentPane.add(new MyLabel("简历：", 370));
		contentPane.add(new MyLabel("奖励：", 420));
		contentPane.add(new MyLabel("处罚：", 470));
		contentPane.add(new MyLabel("家庭：", 520));
		contentPane.add(new MyLabel("体检：", 570));

		MyTextField sid_field = new MyTextField(120);
		MyTextField name_field = new MyTextField(170);
		MyTextField birthday_panel = new MyTextField(220);
		MyButtonPanel gender_field = new MyButtonPanel(270);
		MyTextField age_field = new MyTextField(320);
		MyTextField resume_field = new MyTextField(370);
		MyTextField awards_field = new MyTextField(420);
		MyTextField penality_field = new MyTextField(470);
		MyTextField home_field = new MyTextField(520);
		MyTextField medical_field = new MyTextField(570);

		initButtonPanel(gender_field);

		contentPane.add(sid_field);
		contentPane.add(name_field);
		contentPane.add(birthday_panel);
		contentPane.add(gender_field);
		contentPane.add(age_field);
		contentPane.add(resume_field);
		contentPane.add(awards_field);
		contentPane.add(penality_field);
		contentPane.add(home_field);
		contentPane.add(medical_field);

		MyButton button_ensure = new MyButton("确定", 18, 242, 630, 81, 30);

		button_ensure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int sid = Integer.parseInt(sid_field.getText());
				String name = name_field.getText();
				String birthday = birthday_panel.getText();
				int age = Integer.parseInt(age_field.getText());

				String resume = resume_field.getText();
				String awards = awards_field.getText();
				String penality = penality_field.getText();
				String home = home_field.getText();
				String medical = medical_field.getText();

				if (ConfirmInput.checkInput(sid, name, gender, birthday)) {

					JDBCutils.addAStudent(sid, name, birthday, gender, age, resume, awards, penality, home, medical);

					MyTableInfoModel.studentsData.add(JDBCutils.getAStudent(sid));
					WindowCache.showWindow("show_student");
					setVisible(false);

				}

			}
		});
		contentPane.add(button_ensure);
		MyButton button_cancel = new MyButton("取消", 18, 358, 630, 81, 30);
		button_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowCache.showWindow("home_page");
				setVisible(false);
			}
		});
		contentPane.add(button_cancel);
	}

	/**
	 * 初始化性别选项面板
	 *
	 * @param button_panel 传入一个盛放单选框的面板
	 */
	private void initButtonPanel(MyButtonPanel button_panel) {
		ButtonGroup radio_group = new ButtonGroup();
		JRadioButton male_button = new JRadioButton("男");
		JRadioButton female_button = new JRadioButton("女");
		button_panel.add(male_button);
		button_panel.add(female_button);
		radio_group.add(male_button);
		radio_group.add(female_button);

		male_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gender = "男";
			}
		});
		female_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gender = "女";
			}
		});
	}

}
