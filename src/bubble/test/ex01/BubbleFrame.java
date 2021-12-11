package bubble.test.ex01;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

// 윈도우 창이 되었음
// 윈도우 창은 내부에 패널을 하나 가지고 있다. 
public class BubbleFrame extends JFrame { // while
	
	public BubbleFrame() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // 디자인을 내가 원하는대로 할 수 있음. ﻿Layout을 Absoulute layout으로 변경
		setVisible(true); // 그림을 그려라. 
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
