package com.java.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.java.model.MyButton;
import com.java.model.MyLabel;
import com.java.model.MyWindow;
import com.java.utils.WindowCache;

/**
 * 关于我的界面
 */
public class AboutUs extends MyWindow {

	private static final long serialVersionUID = 8894686569569788294L;

	public AboutUs() {
		initialWindow("关于我", "关于我", new int[] { 227, 27, 181, 55 });

		contentPane.add(new MyLabel("班级：信息与计算科学12-02班", 237, 103, 400, 46, 21));
		contentPane.add(new MyLabel("姓名：董可伦", 291, 177, 200, 30, 22));

		MyButton Button_back = new MyButton("返回首页", 17, 265, 442, 105, 35);
		Button_back.addActionListener(

		new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowCache.showWindow("home_page");
				setVisible(false);
			}
		});

		contentPane.add(Button_back);

	}

}
