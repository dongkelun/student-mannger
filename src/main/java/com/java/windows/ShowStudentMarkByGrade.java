package com.java.windows;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.java.model.MyTableMarkModelByGrade;
import com.java.model.MyWindow;

/**
 * 显示学生数据表的界面
 */
public class ShowStudentMarkByGrade extends MyWindow {

	private static final long serialVersionUID = 5360752926470999857L;

	public ShowStudentMarkByGrade() {
		initialWindow("学生成绩", "学生成绩", new int[] { 238, 10, 173, 45 });
		JTable table = new JTable(new MyTableMarkModelByGrade());//将重写的TableModel加载到Jtable里以显示数据
		initPane(table);
//		initButton(table);
	}

	public void initPane(JTable table) {
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);//当数据超过表的高度时，将超出表格高度的数据隐藏到表的下层，只有拖动侧栏才会出现
		scrollPane.setBounds(10, 86, 714, 240);
		contentPane.add(scrollPane);

	}


}
