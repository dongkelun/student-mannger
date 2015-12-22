package com.java.model;

import javax.swing.JPanel;

/**
 * 重写的JPanel类，用来放置一组按钮
 */
public class MyButtonPanel extends JPanel {

	private static final long serialVersionUID = 1488037661785510864L;

	public MyButtonPanel(int y) {
		this(251, y, 192, 29);
	}

	public MyButtonPanel(int x, int y, int width, int height) {
		setBounds(x, y, width, height);
	}

}
