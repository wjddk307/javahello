package co.micol.mymavenprj; //프로그램 몸통

import java.awt.*; //사용자 인터페이스의 작성 및 그래픽스와 이미지의 페인트용의 /모든 클래스를 포함.
//해당 운영체제의 특징을 따라 화면 구성함. 즉, 운영체제에 따라 느낌이 다름.
import java.awt.event.KeyAdapter; //컴퍼넌트에 대한 keystroke가 발생한 것을 나타냄.
import java.awt.event.KeyEvent; //AWT 컴퍼넌트에 의해 트리거되는 다양한 종류의 이벤트를 처리하는 인터페이스와 클래스를 제공.
import java.util.Timer; //백그라운드에서 특정한 시간 또는 일정 시간을 주기로 반복적으로 특정 작업을 실행할 수 있도록 해 줌.
import java.util.TimerTask; //Timer 클래스가 수행할 작업 나타냄. Runnable 인터페이스를 구현함.

import javax.swing.*; //자바에서 GUI를 만들어주는 대표적인 툴. 자바 영역에서 사용하는 look & feel을 적용 받아 모든 운영체제에서 동일한 느낌 제공 

//java.util : 컬렉션 체제, 레거시 컬렉션 클래스, 이벤트 모델, 날짜와 시간, 국제화 및 다양한 유 틸리티 클래스가 포함되어 있음.

public class ShootingGame extends JFrame { // GUI형태구현 위해서
	private Image bufferImage; // 화면 띄우기 //더블 버퍼링 사용 위한 변수 선언
	private Graphics screenGraphic;

	private Image mainScreen = new ImageIcon("src/images/main_screen.jpg").getImage();
	private Image loadingScreen = new ImageIcon("src/images/loading_screen.jpg").getImage();
	private Image gameScreen = new ImageIcon("src/images/game_screen.jpg").getImage();
	private Image charScreen = new ImageIcon("src/images/char_screen.jpg").getImage();

	private boolean isMainScreen, isLoadingScreen, isGameScreen, isCharScreen; // boolean변수로 화면 컨트롤

	private Game game = new Game(); // public static game = new game

	private Audio backgroundMusic;

	public ShootingGame() { // 생성자
		setTitle("Shooting Game"); // 창 제목
		setUndecorated(true); // 테두리 없는 창 구현
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 크기
		setResizable(false); // 크기조절 여부
		setLocationRelativeTo(null); // 정중앙에 창 생성
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창을 껐을 때 자동으로 꺼지게 해줌
		setVisible(true);
		setLayout(null);

		init();
	}

	private void init() { // 초기화 해줄 메소드
		isMainScreen = true;
		isLoadingScreen = isCharScreen = isGameScreen = false;

		backgroundMusic = new Audio("src/audio/menuBGM.wav", true);
		backgroundMusic.start(); // 메뉴 배경음악을 Audio 클래스로 만들고 재생

		addKeyListener(new KeyListener()); // 만든 KeyListener추가
	}

	private void chooseChar() {
		isMainScreen = isCharScreen = false;
		isCharScreen = true;
	}

	private void gameStart() { // 로딩, 게임 화면 넘어가기 위한 gameStaet 메소드
		isMainScreen = false;
		isLoadingScreen = true;

		Timer loadingTimer = new Timer();
		TimerTask loadingTask = new TimerTask() {
			@Override
			public void run() { // run안에 실행할 내용 작성
				backgroundMusic.stop(); // 게임 화면으로 넘어 갈 때는 재생중인 파일을 중단
				isLoadingScreen = false;
				isGameScreen = true;
				game.start(); // 만들어진 Game클래스의 쓰레드를 시작하기 위해서
			}
		};
		loadingTimer.schedule(loadingTask, 3000); // Timer와 TimerTask 이용해서 로딩화면 3초후에 게임화면으로 넘어가게 만듦
	} // game 쓰레드도

	public void paint(Graphics g) { // 버퍼 이미지를 만들고, 화면에 뿌려줌(깜빡임 최소화)
		bufferImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = bufferImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(bufferImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) { // 필요한요소 그려줌
		if (isMainScreen) { // 각 화면 변수가 true일 때 마다 다른 화면을 그려주기 위함
			g.drawImage(mainScreen, 0, 0, null);
		}
		if (isCharScreen) {
			g.drawImage(charScreen, 0, 0, null);
		}
		if (isLoadingScreen) {
			g.drawImage(loadingScreen, 0, 0, null);
		}
		if (isGameScreen) {
			g.drawImage(gameScreen, 0, 0, null);
			game.gameDraw(g); // 게임화면 일 때 gameDraw 메소드 실행 하도록
		}
		this.repaint();
	}

	class KeyListener extends KeyAdapter { // KeyListener-키 움직임을 받아줌.
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W: // w,a,s,d를 누를 때 각각 game의 up,down,left,right,를 true로 만들어줌
				game.setUp(true);
				break;
				
			case KeyEvent.VK_S:
				game.setDown(true);
				break;
				
			case KeyEvent.VK_A:
				game.setLeft(true);
				break;
				
			case KeyEvent.VK_D:
				game.setRight(true);
				break;
				
			case KeyEvent.VK_R:
				if (game.isOver())
					game.reset(); // 만든 getter 이용-isOver이 true일 경우에만 reset메소드를 통해 재시작
				break;
				
			case KeyEvent.VK_SPACE:
				game.setShooting(true); //
				break;
				
			case KeyEvent.VK_ENTER:
				if (isMainScreen) chooseChar();
				break;
				
			case KeyEvent.VK_1: 
				if (isCharScreen) {
			game.setPlayer(new ImageIcon("src/images/player2.png").getImage()); 
			PlayerAttack.playerColor = 1; 
			gameStart(); 
			}
			break;
			
			case KeyEvent.VK_2: 
				if (isCharScreen) {
			game.setPlayer(new ImageIcon("src/images/player.png").getImage()); 
			PlayerAttack.playerColor = 2; 
			gameStart(); 
			}
			break;
			
			case KeyEvent.VK_3: 
				if (isCharScreen) {
			game.setPlayer(new ImageIcon("src/images/player3.png").getImage());
			PlayerAttack.playerColor = 3; 
			gameStart(); 
			}
			break;
			
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			}
		}

		public void keyReleased(KeyEvent e) {// 키 입력을 떼었을 때에는 반대로 false로 바꿔줌
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				game.setUp(false);
				break;
			case KeyEvent.VK_S:
				game.setDown(false);
				break;
			case KeyEvent.VK_A:
				game.setLeft(false);
				break;
			case KeyEvent.VK_D:
				game.setRight(false);
				break;
			case KeyEvent.VK_SPACE:
				game.setShooting(false);
				break;
			}
		}
	}

}
