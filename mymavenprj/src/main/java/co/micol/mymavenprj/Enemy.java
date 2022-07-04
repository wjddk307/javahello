package co.micol.mymavenprj;

import javax.swing.*;
import java.awt.*;

public class Enemy {

	Image image = new ImageIcon("src/images/enemy.png").getImage();
	int x, y; // 적 기체의 위치,정보,체력
	int width = image.getWidth(null);
	int height = image.getHeight(null);
	int hp = 10;

	public Enemy(int x, int y) { // 위치정보를 매개변수로 받는 생성자
		this.x = x;
		this.y = y;
	}

	public void move() { // 적 기체를 움직이게할 move 메소드
		this.x -= 7;
	}

}
