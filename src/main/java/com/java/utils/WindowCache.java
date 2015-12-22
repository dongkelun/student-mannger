package com.java.utils;

import java.util.HashMap;

import com.java.model.MyWindow;
import com.java.windows.AboutUs;
import com.java.windows.AddStudentInfo;
import com.java.windows.AddStudentMark;
import com.java.windows.HomePage;
import com.java.windows.Login;
import com.java.windows.SelectStudentInfo;
import com.java.windows.ShowStudentInfo;
import com.java.windows.ShowStudentInfoById;
import com.java.windows.ShowStudentMark;
import com.java.windows.ShowStudentMarkByGrade;

/**
 * 存放了所有窗口对象的类，当需要显示一个窗口时，就将该窗口对象调用，避免重复建立窗口对象
 */
public class WindowCache {

	//使用HashMap存放窗口对象
	static HashMap<String, MyWindow> windowMap = new HashMap<>();

	static {
		windowMap.put("login", new Login());
		windowMap.put("home_page", new HomePage());
		windowMap.put("show_student", new ShowStudentInfo());
		windowMap.put("add_student", new AddStudentInfo());
		windowMap.put("select_student", new SelectStudentInfo());
		windowMap.put("show_student_byid", new ShowStudentInfoById());
		windowMap.put("show_mark", new ShowStudentMark());
		windowMap.put("show_mark-bygrade", new ShowStudentMarkByGrade());
		windowMap.put("add_mark", new AddStudentMark());
		windowMap.put("about_us", new AboutUs());
		windowMap.put(null, null);
	}

	/**
	 * 通过传入窗口的key，显示这个窗口
	 *
	 * @param key 要显示的窗口对应的key
	 */
	public static void showWindow(String key) {
		windowMap.get(key).setVisible(true);
	}

}
