package com.java.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.java.utils.JDBCutils;

import edu.hfut.student.manager.domain.StudentMark;

/**
 * 重写的AbstractTableModel类，显示一个表格所必须的类
 */
public class MyTableMarkModelByGrade extends AbstractTableModel {

	private static final long serialVersionUID = -3671119407803211814L;

	//获得数据库中的所有学生信息
	public static List<StudentMark> studentsData = JDBCutils.getAMark("大一");
	//  用数组放置要显示出来的列名
	String[] columnNames = { "学号", "学期", "年级", "专业", "学科号", "学科", "得分" };

	/**
	 * @return 返回已经存储的学生成绩个数
	 */
	@Override
	public int getRowCount() {
//		return 1;
		return studentsData.size();
	}

	/**
	 * @return 返回列的列的数量
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * @param rows 正在编辑的行号
	 * @param cols 正在编辑的列号
	 * @return 获得正在编辑的某个单元格的内容
	 */
	@Override
	public Object getValueAt(int rows, int cols) {
//		return studentsData;
		return studentsData.get(rows).getData()[cols];
	}

	/**
	 * @param col 要获得列名所在的列号
	 * @return 获得列名
	 */
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	/**
	 * 设置某一列（学号）不可编辑
	 *
	 * @param row 要设置不可编辑的单元格行号
	 * @param col 要设置不可编辑的单元格列号
	 * @return 如果为第一列返回false
	 */
	@Override
	public boolean isCellEditable(int row, int col) {
		//col == 0 ? false : true
		return col != 0;
	}

}
