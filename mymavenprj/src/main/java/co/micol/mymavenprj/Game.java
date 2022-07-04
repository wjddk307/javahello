package co.micol.mymavenprj;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList; //동적 크기의 요소 모음을 저장하는 데 사용됨. 크기가 고정된 배열과 달리,
							//ArrayList는 새 요소가 추가될 때 자동으로 크기를 늘린다. 
							//자바 의 컬렉션 프레임워크의 일부고 List 인터페이스의 구현체. 크기를 조절할 수 있는 배열.

public class Game extends Thread { // 쓰레드 형태로 구현하기 위해서 쓰레드 상속

	private int delay = 20; // 게임의 딜레이,딜레이마다 증가할 cnt선언(1/100초 단위)
	private long pretime; // cnt가 증가하기전 시간/루프 간격을 조절하기 위한 시간 체크값
	private int cnt;// cnt-이벤트 발생 주기를 컨트롤하는 변수
	private int score; // 점수를 나타낼 변수

	private Image player = new ImageIcon("src/images/player.png").getImage();

	private int playerX, playerY; // 플레이어 관련 변수 선언
	private int playerWidth = player.getWidth(null); // 캐릭터의 너비
	private int playerHeight = player.getHeight(null); // 캐릭터의 높이
	private int playerSpeed = 10; // 키입력이 한번 인식될 때마다 플레이어가 이동할 거리
	private int playerHp = 30; // 적의 구현에서 사용

	private boolean up, down, left, right, shooting;// 플레이어의 움직임 제어할 변수 선언
	private boolean isOver; // 게임오버를 나타낼 변수

	private ArrayList<PlayerAttack> playerAttackList = new ArrayList<PlayerAttack>(); // 플레이어의 공격을 담음
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>(); //
	private ArrayList<EnemyAttack> enemyAttackList = new ArrayList<EnemyAttack>();//

	private PlayerAttack playerAttack; // ArrayList안의 내용에 쉽게 접근 할 수 있도록 playerAttack변수도(이하동일) 선언
	private Enemy enemy;
	private EnemyAttack enemyAttack;

	private Audio backgroundMusic;
	private Audio hitSound;

	@Override
	public void run() { // 이 쓰레드를 시작할 시 실행될 내용
		backgroundMusic = new Audio("src/audio/gameBGM.wav", true);
		hitSound = new Audio("src/audio/hitSound.wav", false);

		reset(); // 쓰레드가 시작할 때 reset메소드도 한번 실핼하도록 함
		while (true) {// cnt를 앞서 설정한 delay 밀리초가 지날 때 마다 증가시켜줌
			while (!isOver) { // while문을 안에 하나 더 추가해줌으로써 isOver = false일 경우에만 게임 관련 메소드들이 반복되도록 함
				pretime = System.currentTimeMillis();
				if (System.currentTimeMillis() - pretime < delay) { // 현재시간-(cnt가 증가하기 전 시간)<delay일 경우
					try { // Thread에 sleep를 줌(좀 더 정확한 주기를 위해)
						Thread.sleep(delay - System.currentTimeMillis() + pretime); // 게임루프를 처리하는데 걸린 시간을 체크해서 딜레이 값에서
																					// 차감하여 딜레이를 일정하게 유지한다.
						// 루프 실행시간이 딜레이시간보다 크다면 게임속도가 느려지게된다.
						keyProcess(); // 메소드 만들어줄 때 마다 여기 추가
						playerAttackProcess();//
						enemyAppearProcess(); //
						enemyMoveProcess(); //
						enemyAttackProcess();//
						cnt++;
					} catch (InterruptedException e) { // Thread.sleep의 경우 예외처리 해야함
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(100); // Thread.sleep을 추가해줘서 isOver = true일 경우 쓰레드가 계속 쉬도록 해줌
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void reset() { // 다시하기 기능을 쓸 때 마다 게임상태를 초기화 해줄 메소드
		isOver = false;
		cnt = 0; // cnt-0으로 초기화
		score = 0;
		playerX = 10; // player위치도 초기화
		playerY = (Main.SCREEN_HEIGHT - playerHeight) / 2;
		playerHp = 30;

		backgroundMusic.start(); // 배경음악도 다시 재생

		playerAttackList.clear(); // ArrayList들의 내용도 전부 지워줌
		enemyList.clear();
		enemyAttackList.clear();
	}

	private void keyProcess() { // 키 입력을 처리할 메소드
		if (up && playerY - playerSpeed > 0)
			playerY -= playerSpeed;// 화면에서 안 나가는 선에서 playerX, playerY 값 조정
		if (down && playerY + playerHeight + playerSpeed < Main.SCREEN_HEIGHT)
			playerY += playerSpeed;
		if (left && playerX - playerSpeed > 0)
			playerX -= playerSpeed;
		if (right && playerX + playerWidth + playerSpeed < Main.SCREEN_WIDTH)
			playerX += playerSpeed;
		if (shooting && cnt % 15 == 0) { // cnt가 0.02초마다 올라가는 것을 생각한다면 0.3초마다 미사일이 발사되도록 하는 것
			playerAttack = new PlayerAttack(playerX + 222, playerY + 25);
			playerAttackList.add(playerAttack); // 플레이어와 적당히 떨어진 위치에 공격을 만들어 이를 방금 만든 ArrayList에 넣어줍니다
		}
	}

	private void playerAttackProcess() { // 공격을 처리해주는 메소드
		for (int i = 0; i < playerAttackList.size(); i++) {
			playerAttack = playerAttackList.get(i); // ArrayList의 get메소드를 통해 담긴 객체 하나하나에 접근해 fire메소드를 실행해줍니다.
			playerAttack.fire();

			for (int j = 0; j < enemyList.size(); j++) { // 플레이어 공격에 충돌판정
				enemy = enemyList.get(j); // (플레이어의 공격 이미지가 적 이미지와 겹친부분이 있는지 검사
				if (playerAttack.x > enemy.x && playerAttack.x < enemy.x + enemy.width && playerAttack.y > enemy.y
						&& playerAttack.y < enemy.y + enemy.height) {
					enemy.hp -= playerAttack.attack; // 겹친부분이 있을 시 적의 hp를 줄여 해당 공격을 삭제
					playerAttackList.remove(playerAttack);
				}
				if (enemy.hp <= 0) { // 적의 hp가 0이하라면 제거
					hitSound.start(); // 적을 격추 했을 때, 플레이어가 공격에 맞았을 때(피격음)
					enemyList.remove(enemy);
					score += 1000; // 적을 격추 했을 시 점수를 오르게 해줌
				}
			}
		}
	}

	private void enemyAppearProcess() { // 주기적으로 적을 출현시키는 메소드
		if (cnt % 80 == 0) { // 화면 끝에서 랜덤한 위치에 출현시키기 위해서 y값을 1~620 랜덤으로 나오게 함
			enemy = new Enemy(1120, (int) (Math.random() * 621));
			enemyList.add(enemy); // ArrayList에 추가
		}
	}

	private void enemyMoveProcess() { // 적을 이동시키는 메소드
		for (int i = 0; i < enemyList.size(); i++) {
			enemy = enemyList.get(i); // ArrayList안의 요소에 접근해서 move 메소드를 호출
			enemy.move();
		}
	}

	private void enemyAttackProcess() { // 적의 공격구현
		if (cnt % 50 == 0) {
			enemyAttack = new EnemyAttack(enemy.x - 79, enemy.y + 35); // 일정주기마다 적의 공격을 생성해 ArrayList 안에 추가
			enemyAttackList.add(enemyAttack);
		}

		for (int i = 0; i < enemyAttackList.size(); i++) { // ArrayList에 담긴 공격 하나하나에 fire메소드를 호출
			enemyAttack = enemyAttackList.get(i);
			enemyAttack.fire();

			if (enemyAttack.x > playerX & enemyAttack.x < playerX + playerWidth && enemyAttack.y > playerY
					&& enemyAttack.y < playerY + playerHeight) {
				// 적의 공격에도 적의 공격이 플레어 이미지와 겹쳐있는지 확인
				hitSound.start();
				playerHp -= enemyAttack.attack;
				enemyAttackList.remove(enemyAttack);
				if (playerHp <= 0)
					isOver = true; // 적에게 피격 당했을 때 playerHP가 0이하라면 isOver를 true로 바꿔줌
			} // true로 바꿀시 위에 설정했듯이 게임관련메소드들은 실행되지 않습니다.
		}
	}

	public void gameDraw(Graphics g) { // 게임안의 요소들을 그려줄 메소드
		playerDraw(g);// 게임안에 요소들을 그려주는 메소드는 전부 여기 넣어줌
		enemyDraw(g); //
		infoDraw(g); //
	}

	public void infoDraw(Graphics g) { // 게임 관련 정보를 그려주는 메소드
		g.setColor(Color.WHITE); // 색깔,폰트,폰트크기등
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("SCORE : " + score, 40, 80); // 설정한 폰트를 토대로 drawString 메소드를 통해 x:40, y:80 위치에 점수를 출력
		g.drawString("MISSION : Reach 10000pts", 750, 80);

		if (isOver) { // 게임이 끝난경우 R키를 눌러 재시작 할 수 있다는 안내문을 띄움
			g.setColor(Color.ORANGE);
			g.setFont(new Font("Arial", Font.BOLD, 68));
			g.drawString("Press R to restart", 320, 400);
		}

		if (score == 10000) {
			isOver = true;
			backgroundMusic.stop();
			g.setColor(Color.ORANGE);
			g.setFont(new Font("Arial", Font.BOLD, 80));
			g.drawString("YOU WIN!!!", 450, 300);
			

		}

	}

	public void playerDraw(Graphics g) { // player에 관한 요소를 그릴 메소드
		g.drawImage(player, playerX, playerY, null);// 앞서 만든 플레이어 이미지를 playerX,playerY에 그려주면 됨
		g.setColor(Color.ORANGE); // 플레이의 체력을 확인 할 수 있도록 체력바 생성
		g.fillRect(playerX - 1, playerY - 40, playerHp * 6, 20); // 체력바 배수만큼의 초록색 사각형을 플레이어의 위에 그려주는 방식
		for (int i = 0; i < playerAttackList.size(); i++) {
			playerAttack = playerAttackList.get(i);
			g.drawImage(playerAttack.image, playerAttack.x, playerAttack.y, null); // 플레이어의 공격도 각각의 x,y에 그려주면 됨
		}
	}

	public void enemyDraw(Graphics g) {// 적과 적의 공격을 그려줄 메소드
		for (int i = 0; i < enemyList.size(); i++) {
			enemy = enemyList.get(i);
			g.drawImage(enemy.image, enemy.x, enemy.y, null); // 선언했던 클래스의 필드 x,y를 이용해서 적을 그려줌
			g.setColor(Color.ORANGE); // 적의 체력을 확인 할 수 있도록 체력바 생성
			g.fillRect(enemy.x + 1, enemy.y - 40, enemy.hp * 15, 20); //// 체력바 배수만큼의 초록색 사각형을 적의 위에 그려주는 방식
		}
		for (int i = 0; i < enemyAttackList.size(); i++) { // 적의 공격을 그리는 부분
			enemyAttack = enemyAttackList.get(i);
			g.drawImage(enemyAttack.image, enemyAttack.x, enemyAttack.y, null);
		}
	}

	public boolean isOver() { // getter 생성(is Over 변수의 상태를 알 수 있게 하기 위함)
		return isOver;
	}

	public void setUp(boolean up) { // private변수의 경우, 객체를 통한 직접적인 접근을 못하므로 setter를 만들어줌
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}

	public void setPlayer(Image player) {
		this.player = player;
	}

	public Image getPlayer() {
		return this.player;
	}

}
