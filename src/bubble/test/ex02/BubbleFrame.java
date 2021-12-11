package bubble.test.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{
	
	private JLabel backgroundMap;
	private Player player;
	
	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true);
	}
	
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap);
		//backgroundMap.setSize(1000, 600); // 크키
		//backgroundMap.setLocation(300, 300); // 위치
		//add(backgroundMap); // JFrame에 JLabel이 그려진다. 
		
		player = new Player();
		add(player); // 덧붙이는 상황이기 때문에 add를 사용. 
	}
	
	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); // = absolute 레이아웃 (자유롭게 그림을 그릴 수 있다.)
		
		setLocationRelativeTo(null); // JFrame을 가운데 배치하기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // JFrame창이 꺼지면 JVM 같이 종료된다.
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
