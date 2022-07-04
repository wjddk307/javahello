package co.micol.mymavenprj;

import javax.swing.*;
import java.awt.*;

public class PlayerAttack {
	 Image image = new ImageIcon("src/images/player_attack.png").getImage();
	    int x, y;//공격의 이미지,위치,공격력에 대한 정보
	    int width = image.getWidth(null);//이미지의 너비와 높이(공격의 충돌판정을 위해
	    int height = image.getHeight(null);
	    int attack = 5;
	    static int playerColor;

	    public PlayerAttack(int x, int y) { //x,y를 매개변수로 하는 생성자
	        this.x = x;
	        this.y = y;
	        if (playerColor == 2) {
	        	image = new ImageIcon("src/images/player_attack.png").getImage(); }
	        	else if (playerColor == 3) {
	        	image = new ImageIcon("src/images/player_attack.png").getImage(); }
	    }
	        

	    public void fire() { //발사 메소드(플레이어의 공격은 오른쪽으로 나가므로 x값을 증가 시키면 됨
	        this.x += 15;
	    }

}
