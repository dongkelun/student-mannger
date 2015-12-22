package com.java.model;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.java.utils.Constant;

/**
 * 重写的JFrame
 */
public class MyWindow extends JFrame {

	private static final long serialVersionUID = 4064212081328805256L;

	//    protected修饰的变量子类也能继承
	protected JPanel contentPane;

	/**
	 * 初始化窗口，在子类中调用
	 *
	 * @param title       窗口的顶栏标题
	 * @param topic_label 窗口上方大字标语
	 * @param location    窗口的坐标
	 */
	public void initialWindow(String title, String topic_label, int[] location) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置点击叉号的操作为退出程序
		setAutoRequestFocus(true);//设置窗口最前
		setIconImage(Toolkit.getDefaultToolkit().getImage(Constant.ICON));// 设置左上角图标
		setSize(750, 750);
		setLocationRelativeTo(null);// 让窗口居中显示
		setTitle(title);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);// 设置窗口的布局方式为绝对布局，只根据坐标来定位
		// 设置主题标语
		JLabel label = new JLabel(topic_label);
		label.setFont(new Font("华文行楷", Font.PLAIN, 41));
		label.setBounds(location[0], location[1], location[2], location[3]);
		contentPane.add(label);
		setResizable(Boolean.TRUE);// 使窗口不可改变大小
	}

}
