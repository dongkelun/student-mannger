package com.java.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.java.utils.ConfirmInput;
import com.java.utils.JDBCutils;

import edu.hfut.student.manager.domain.StudentInfo;

/**
 * 重写的AbstractTableModel类，显示一个表格所必须的类
 */
public class SelectMyTableInfoModel extends AbstractTableModel {

	private static final long serialVersionUID = -3671119407803211814L;

	//获得数据库中的所有学生信息
	static int sid = 2012214307;
	public static StudentInfo studentsData = JDBCutils.getAStudent(sid);
	//  用数组放置要显示出来的列名
	String[] columnNames = { "学号", "姓名", "生日", "性别", "年龄", "简历", "奖励", "处罚", "家庭", "体检" };

	/**
	 * @return 返回已经存储的学生信息个数
	 */
	@Override
	public int getRowCount() {
		return 1;
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
		return studentsData;
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

	/**
	 * 把正在编辑的单元格的值设置为新值
	 *
	 * @param value 在单元格中输入的值
	 * @param row   该单元格的行
	 * @param col   该单元格的列
	 */
	@Override
	public void setValueAt(Object value, int row, int col) {
		StudentInfo student = MyTableInfoModel.studentsData.get(row);
		switch (col) {
		case 1:
			if (ConfirmInput.checkInput(2012214307, (String) value, "男", "19940101")) {
				student.setName((String) value);//设置显示出来的值为value
				JDBCutils.modifiedAStudent("name", (String) value, student.getSid());// 把数据中name列，学号为getId的值设置为value
			}

			break;
		case 2:
			if (ConfirmInput.checkInput(2012214307, "董可伦", (String) value, "19940101")) {
				student.setGender((String) value);
				JDBCutils.modifiedAStudent("sex", (String) value, student.getSid());
			}
			break;
		case 3:
			if (ConfirmInput.checkInput(2012214307, "董可伦", "男", (String) value)) {
				student.setBirthday((String) value);
				JDBCutils.modifiedAStudent("birthday", (String) value, student.getSid());
			}
			break;
		default:
			break;
		}
	}

}
