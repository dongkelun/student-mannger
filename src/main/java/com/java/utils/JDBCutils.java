package com.java.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.hfut.student.manager.domain.StudentInfo;
import edu.hfut.student.manager.domain.StudentMark;

/**
 * <p>JDBC连接</p>
 */
public class JDBCutils {

	//定义数据库的连接
	public static Connection connection;
	//定义数据库工具的对象
	private static JDBCutils dbutil;

	//静态初始化对象和连接
	static {
		dbutil = new JDBCutils();
		connection = JDBCutils.getConnection();
	}

	//定义执行语句
	private PreparedStatement prestmt;
	//定义存放返回结果的集合
	private ResultSet resultset;

	public JDBCutils() {
		try {
			//载入驱动
			Class.forName(Constant.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 利用反射机制查询一个学生的信息
	 *
	 * @param id 传入要查询的学号
	 * @return 返回一个学生对象
	 */
	public static StudentInfo getAStudent(int sid) {
		StudentInfo student = null;
		String sql = "SELECT * FROM student_info WHERE sid = ? ";
		List<Object> values = new ArrayList<>();
		values.add(sid);//把values数组中的值填充到？处
		try {
			//返回查询到的一个学生对象
			student = dbutil.findSimpleRefResult(sql, values, StudentInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	
	public static List<StudentMark> getAMark(String grade) {
		List<StudentMark> mark = null;
		String sql = "SELECT sid,term,grade,major,course_id,course_name,score FROM student_mark WHERE grade = ? ";
		List<Object> values = new ArrayList<>();
		values.add(grade);//把values数组中的值填充到？处
		try {
			//返回查询到的一个学生对象
			mark = dbutil.findMoreRefResult(sql, values, StudentMark.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mark;
	}
	public static StudentMark getAMark(int sid) {
		StudentMark mark = null;
		String sql = "SELECT sid,term,grade,major,course_id,course_name,score FROM student_mark WHERE sid = ? ";
		List<Object> values = new ArrayList<>();
		values.add(sid);//把values数组中的值填充到？处
		try {
			//返回查询到的一个学生对象
			mark = dbutil.findSimpleRefResult(sql, values, StudentMark.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mark;
	}
	/**
	 * 修改一个学生的信息
	 *
	 * @param field 要修改的值所在的列名
	 * @param value 要修改成的值
	 * @param id    要修改的行的学号
	 */
	public static void modifiedAStudent(String field, String value, int sid) {
		String sql = "UPDATE student_info SET " + field + "=? WHERE sid=?";
		List<Object> values = new ArrayList<>();
		values.add(value);
		values.add(sid);
		try {
			//            执行sql语句
			dbutil.updateByPrepareStatement(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除数据表中的一条学生数据
	 *
	 * @param id 要删除的学生的学号
	 */
	public static void deleteAStudent(int sid) {
		String sql = "DELETE FROM student_info WHERE sid=?";
		List<Object> values = new ArrayList<>();
		values.add(sid);
		try {
			dbutil.deteleByPrepareStatement(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteAMark(int sid) {
		String sql = "DELETE FROM student_mark WHERE sid=?";
		List<Object> values = new ArrayList<>();
		values.add(sid);
		try {
			dbutil.deteleByPrepareStatement(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 增加一名学生的信息到数据表
	 */
	public static void addAStudent(int sid, String name, String birthday, String gender, int age, String resume,
			String awards, String penality, String home, String medical) {

		String sql = "INSERT INTO student_info (sid,name,birthday,gender,age,resume,awards,penality,home,medical) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		List<Object> values = new ArrayList<>();
		values.add(sid);
		values.add(name);
		values.add(birthday);
		values.add(gender);
		values.add(age);
		values.add(resume);
		values.add(awards);
		values.add(penality);
		values.add(home);
		values.add(medical);

		try {
			dbutil.updateByPrepareStatement(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addAMark(int sid, int term, String grade, String major, int course_id, String course_name,
			int score) {

		String sql = "INSERT INTO student_mark (sid,term,grade,major,course_id,course_name,score) VALUES (?,?,?,?,?,?,?)";
		List<Object> values = new ArrayList<>();
		values.add(sid);
		values.add(term);
		values.add(grade);
		values.add(major);
		values.add(course_id);
		values.add(course_name);
		values.add(score);

		try {
			dbutil.updateByPrepareStatement(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 以存放了Student对象的List的形式返回数据表中的所有数据
	 * @return 返回含有所有学生对象的List
	 */
	public static List<StudentInfo> getAllStudent() {

		List<StudentInfo> list = null;
		String sql = "SELECT * FROM student_info";
		try {
			//            返回存放了的所有的学生对象的List
			list = dbutil.findMoreRefResult(sql, null, StudentInfo.class);
		} catch (Exception e) {
			System.out.println("获取数据出现异常");
		}
		return list;
	}

	public static List<StudentMark> getAllMark() {

		List<StudentMark> list = null;
		String sql = "SELECT sid,term,grade,major,course_id,course_name,score FROM student_mark";
		try {
			//            返回存放了的所有的学生对象的List
			list = dbutil.findMoreRefResult(sql, null, StudentMark.class);
		} catch (Exception e) {
			System.out.println("获取数据出现异常");
		}
		return list;
	}

	/**
	 * 检测学生学号是否已经存在
	 *
	 * @param id 学号
	 * @return 如果学号已经存在，返回true
	 * @throws SQLException
	 */
	public static boolean confirmRepeat(int sid) throws SQLException {
		boolean flag = false;
		String sql = "SELECT * FROM student_info WHERE sid =" + sid;
		PreparedStatement prestmt = connection.prepareStatement(sql);
		ResultSet resultset = prestmt.executeQuery();
		if (resultset.next()) {
			flag = true;
		}
		return flag;
	}

	/**
	 * @return 获得数据库的连接
	 */
	public static Connection getConnection() {
		try {
			//            注册驱动
			connection = DriverManager.getConnection(Constant.DBURL, Constant.DB_USERNAME, Constant.DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 利用反射机制返回学生的
	 *
	 * @param sql   要执行的包含占位符的sql语句
	 * @param value 要取代占位符的值
	 * @param cls   要包含在List里面的类型
	 * @return 返回包含了T类型的List
	 * @throws Exception
	 */
	public <T> List<T> findMoreRefResult(String sql, List<Object> value, Class<T> cls) throws Exception {
		List<T> list = new ArrayList<>();
		int index = 1;
		prestmt = connection.prepareStatement(sql);
		if (value != null && !value.isEmpty()) {
			for (Object aValue : value) {
				prestmt.setObject(index++, aValue);
			}
		}
		resultset = prestmt.executeQuery();

		ResultSetMetaData metaData = resultset.getMetaData();
		int cols_len = metaData.getColumnCount();

		while (resultset.next()) {

			T resultObject = cls.newInstance();

			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultset.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}

				Field field = cls.getDeclaredField(cols_name);

				field.setAccessible(true);
				try {
					field.set(resultObject, cols_value);
				} catch (IllegalArgumentException e) {
					System.out.println("输入的值不匹配数据库的要求");
				}

			}
			list.add(resultObject);

		}
		return list;
	}

	public boolean updateByPrepareStatement(String sql, List<Object> value) throws SQLException {
		prestmt = connection.prepareStatement(sql);
		int index = 1;
		if (value != null && !value.isEmpty()) {
			for (Object aValue : value) {
				prestmt.setObject(index++, aValue);
			}

		}
		return prestmt.executeUpdate() > 0;
	}

	public void deteleByPrepareStatement(String sql, List<Object> value) throws SQLException {
		prestmt = connection.prepareStatement(sql);
		int index = 1;
		if (value != null && !value.isEmpty()) {
			for (Object aValue : value) {
				prestmt.setObject(index++, aValue);
			}

		}
		prestmt.execute();
	}

	public <T> T findSimpleRefResult(String sql, List<Object> value, Class<T> cls) throws Exception {
		T resultObject = null;
		int index = 1;
		prestmt = connection.prepareStatement(sql);
		if (value != null && !value.isEmpty()) {
			for (Object aValue : value) {
				prestmt.setObject(index++, aValue);
			}
		}
		resultset = prestmt.executeQuery();
		ResultSetMetaData metaData = resultset.getMetaData();
		int cols_len = metaData.getColumnCount();
		while (resultset.next()) {
			// 通过反射机制创建实例
			resultObject = cls.newInstance();
			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultset.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				Field field = cls.getDeclaredField(cols_name);
				field.setAccessible(true);// 打开javabean的访问private权限
				try {
					field.set(resultObject, cols_value);
				} catch (IllegalArgumentException e) {
					System.out.println("不合法的参数");
				}
			}
		}
		return resultObject;
	}

}
