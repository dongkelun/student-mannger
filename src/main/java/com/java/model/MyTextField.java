package com.java.model;

import javax.swing.JTextField;

/**
 * 重写的JTextField
 */
public class MyTextField extends JTextField {

	private static final long serialVersionUID = -1159524352194632961L;

	public MyTextField(int y) {
		this(null, 251, y, 192, 29);
	}

	public MyTextField(String text, int x, int y, int width, int height) {
		setText(text);
		setBounds(x, y, width, height);
	}

}
