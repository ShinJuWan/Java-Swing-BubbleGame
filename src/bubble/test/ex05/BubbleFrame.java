package bubble.test.ex05;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{
	
	private JLabel backgroundMap;
	private Player player;
	
	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}
	
	private void initListener() {
		// adapter 패턴
		addKeyListener(new KeyAdapter() {
			
			// 키보드 클릭 이벤트 핸들러
			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println(e.getKeyCode());
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT: // e.getKeyCode() = 왼쪽 / 37
					if(!player.isLeft()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT: // e.getKeyCode() = 오른쪽 / 39
					if(!player.isRight()) { // !는 부정의 의미. 
						player.right();
					}
					break;
				case KeyEvent.VK_UP: // e.getKeyCode() = 위쪽 / 38
					if(!player.isUp() && !player.isDown()) {
						player.up();
					}
					break;
//				키보드의 다운 버튼으로 캐릭터가 밑으로 내려가지 않음. 구현 x 	
//				case KeyEvent.VK_DOWN: // e.getKeyCode() = 아래쪽 / 40
//					player.down();
//					break;
				}
			}
			
			// 키보드 해제 이벤트 핸들러
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				}
			}
		});
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
