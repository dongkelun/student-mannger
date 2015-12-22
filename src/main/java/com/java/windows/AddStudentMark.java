package com.java.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.java.model.MyButton;
import com.java.model.MyLabel;
import com.java.model.MyTableMarkModel;
import com.java.model.MyTextField;
import com.java.model.MyWindow;
import com.java.utils.JDBCutils;
import com.java.utils.WindowCache;

/**
 * 添加学生的界面
 */
public class AddStudentMark extends MyWindow {

	private static final long serialVersionUID = 9009252828762370679L;

	public AddStudentMark() {
		initialWindow("添加成绩信息", "添加成绩信息", new int[] { 192, 24, 279, 55 });

		contentPane.add(new MyLabel("学号：", 120));
		contentPane.add(new MyLabel("学期：", 170));
		contentPane.add(new MyLabel("年级：", 220));
		contentPane.add(new MyLabel("专业：", 270));
		contentPane.add(new MyLabel("学科id：", 320));
		contentPane.add(new MyLabel("学科：", 370));
		contentPane.add(new MyLabel("得分：", 420));

		MyTextField sid_field = new MyTextField(120);
		MyTextField term_field = new MyTextField(170);
		MyTextField grade_panel = new MyTextField(220);
		MyTextField major_field = new MyTextField(270);
		MyTextField course_id_field = new MyTextField(320);
		MyTextField course_name_field = new MyTextField(370);
		MyTextField score_field = new MyTextField(420);

		contentPane.add(sid_field);
		contentPane.add(term_field);
		contentPane.add(grade_panel);
		contentPane.add(major_field);
		contentPane.add(course_id_field);
		contentPane.add(course_name_field);
		contentPane.add(score_field);

		MyButton button_ensure = new MyButton("确定", 18, 242, 500, 81, 30);

		button_ensure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int sid = Integer.parseInt(sid_field.getText());
				int term = Integer.parseInt(term_field.getText());
				String grade = grade_panel.getText();
				String major = major_field.getText();
				int course_id = Integer.parseInt(course_id_field.getText());
				String course_name = course_name_field.getText();
				int score = Integer.parseInt(score_field.getText());

				JDBCutils.addAMark(sid, term, grade, major, course_id, course_name, score);

				MyTableMarkModel.studentsData.add(JDBCutils.getAMark(sid));
				WindowCache.showWindow("show_mark");
				setVisible(false);

			}
		});
		contentPane.add(button_ensure);
		MyButton button_cancel = new MyButton("取消", 18, 358, 500, 81, 30);
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
