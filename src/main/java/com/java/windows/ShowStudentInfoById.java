package com.java.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.java.model.MyButton;
import com.java.model.MyButtonPanel;
import com.java.model.MyLabel;
import com.java.model.MyTableInfoModel;
import com.java.model.MyTextField;
import com.java.model.MyWindow;
import com.java.model.SelectMyTableInfoModel;
import com.java.utils.ConfirmInput;
import com.java.utils.JDBCutils;
import com.java.utils.WindowCache;

/**
 * 显示学生数据表的界面
 */
public class ShowStudentInfoById extends MyWindow {

	private static final long serialVersionUID = 5360752926470999857L;

	public ShowStudentInfoById() {
		initialWindow("学生信息", "学生信息", new int[] { 238, 10, 173, 45 });
		JTable table = new JTable(new SelectMyTableInfoModel());//将重写的TableModel加载到Jtable里以显示数据
		initPane(table);
		initButton(table);
	}
	public void initPane(JTable table) {
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);//当数据超过表的高度时，将超出表格高度的数据隐藏到表的下层，只有拖动侧栏才会出现
		scrollPane.setBounds(10, 86, 714, 240);
		contentPane.add(scrollPane);
	}
	public void initButton(JTable table) {
		MyButton button_add = new MyButton("确定", 15, 130, 364, 95, 23);
		button_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				{
					WindowCache.showWindow("add_student");
					setVisible(false);
				}
			}
		});
		contentPane.add(button_add);
	}
//	MyButton button_ensure = new MyButton("确定", 18, 242, 630, 81, 30);
//
//	button_ensure.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//
////			int sid = Integer.parseInt(sid_field.getText());
////			String name = name_field.getText();
////			String birthday = birthday_panel.getText();
////			int age = Integer.parseInt(age_field.getText());
////
////			String resume = resume_field.getText();
////			String awards = awards_field.getText();
////			String penality = penality_field.getText();
////			String home = home_field.getText();
////			String medical = medical_field.getText();
//
////			if (ConfirmInput.checkInput(sid, name, gender, birthday)) {
////
////				JDBCutils.addAStudent(sid, name, birthday, gender, age, resume, awards, penality, home, medical);
////
////				MyTableInfoModel.studentsData.add(JDBCutils.getAStudent(sid));
////				WindowCache.showWindow("show_student");
////				setVisible(false);
////
////			}
//
//		}
//	});
//	contentPane.add(button_ensure);
//	MyButton button_cancel = new MyButton("取消", 18, 358, 630, 81, 30);
//	button_cancel.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			WindowCache.showWindow("home_page");
//			setVisible(false);
//		}
//	});
//	contentPane.add(button_cancel);
}
