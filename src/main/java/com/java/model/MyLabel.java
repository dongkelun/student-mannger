package com.java.model;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * 重写的JLabel类
 */
public class MyLabel extends JLabel {

	private static final long serialVersionUID = -351331272622458308L;

	public MyLabel(String name, int y) {
		this(name, 175, y, 66, 30);
	}

	public MyLabel(String name, int x, int y, int width, int height) {
		this(name, x, y, width, height, 19);
	}

	public MyLabel(String name, int x, int y, int width, int height, int font_size) {
		super(name);
		setFont(new Font("微软雅黑", Font.PLAIN, font_size));
		setBounds(x, y, width, height);
	}

}
