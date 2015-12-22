package com.java.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.java.model.MyButton;
import com.java.model.MyButtonPanel;
import com.java.model.MyLabel;
import com.java.model.MyTextField;
import com.java.model.MyWindow;
import com.java.model.SelectMyTableInfoModel;
import com.java.utils.JDBCutils;
import com.java.utils.WindowCache;

import edu.hfut.student.manager.domain.StudentInfo;

public class SelectStudentInfo extends MyWindow{
	
	private static final long serialVersionUID = 9009252828762370679L;
	
	public SelectStudentInfo(){
		initialWindow("查询学生信息", "查询学生信息", new int[] { 192, 24, 279, 55 });
		
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
				StudentInfo student = JDBCutils.getAStudent(sid);
				
				String name = student.getName();
				String birthday = student.getBirthday();
				int age = student.getAge();
				String resume = student.getResume();
				String awards = student.getAwards();
				String penality = student.getPenality();
				String home = student.getHome();
				String medical = student.getMedical();
				
				WindowCache.showWindow("show_student_byid");
				setVisible(false);
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
}
