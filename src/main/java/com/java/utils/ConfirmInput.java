package com.java.utils;

import java.sql.SQLException;

import com.java.model.MyDialog;

/**
 * 用于对输入进行验证
 */
public class ConfirmInput {

	/**
	 * 使用正则表达式对输入进行验证
	 *
	 * @param num      验证学号
	 * @param name     验证姓名
	 * @param gender      验证性别
	 * @param location 验证籍贯
	 * @param birthDay    验证生日
	 * @return 如果通过验证返回true
	 */
	public static boolean checkInput(int sid, String name, String gender, String birthDay) {
		boolean flag = false;
		if (sid < 1000000000) {
			MyDialog.show("学号为10位数字！");
		} else
			try {
				if (JDBCutils.confirmRepeat(sid)) {
					MyDialog.show("该学号已经存在！");
				} else if (!name.matches("[\\u4E00-\\u9FA5]{2,4}")) {
					MyDialog.show("请填写正确的姓名！");
				} else if (!gender.matches("[男|女]")) {
					MyDialog.show("请输入正确性别");
				} else if (!birthDay.matches("19[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])")) {
					MyDialog.show("请填写正确的出生年月！如19940101");
				} else
					flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return flag;
	}

}
