package bubble.test.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

// class Player -> new 가능한 애들!! 게임에 존재할 수 있음. (추상메서드를 가질 수 없다.)
// 추상메서드를 implements 하면 Moveable이 가지고 있는 추상메서드를 구현해야 한다. 
@Getter
@Setter
public class Player extends JLabel implements Moveable {

	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 플레이어 속도 상태
	private final int SPEED = 3;
	private final int JUMPSPEED = 2; // up, down

	private ImageIcon playerR, playerL;

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		// 좌표
		x = 55;
		y = 535;

		left = false;
		right = false;
		up = false;
		down = false;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	// 이벤드 핸들러
	@Override
	public void left() {
		System.out.println("left");
		left = true;
		new Thread(() -> {
			while (left) {
				setIcon(playerL);
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10); // 0.01초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void right() {
		System.out.println("right");
		right = true;
		new Thread(() -> {
			while (right) {
				setIcon(playerR);
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10); // 0.01초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	// left + up, right + up
	@Override
	public void up() {
		System.out.println("up");
		up = true;
		new Thread(() -> {
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED; // y의 최상단값이 (0,0)이기 때문에 마이너스로 처리해야 한다.
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			up = false;
			down();

		}).start();
	}

	@Override
	public void down() {
		System.out.println("down");
		down = true;
		new Thread(() -> {
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED; // y의 최상단값이 (0,0)이기 때문에 마이너스로 처리해야 한다.
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			down = false;
		}).start();
	}
}
