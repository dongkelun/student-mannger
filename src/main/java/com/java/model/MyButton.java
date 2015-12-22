package com.java.model;

import java.awt.Font;

import javax.swing.JButton;

/**
 * 重写的JButton类
 */

public class MyButton extends JButton {

	private static final long serialVersionUID = 4259998454572238123L;

	public MyButton(String name, int font_size, int x, int y, int width, int height) {
		super(name);
		setFont(new Font("微软雅黑", Font.PLAIN, font_size));
		setBounds(x, y, width, height);
	}

}
