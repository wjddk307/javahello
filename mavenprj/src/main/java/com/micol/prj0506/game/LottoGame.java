package com.micol.prj0506.game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoGame {
private Scanner sc = new Scanner(System.in);
	
	private void menu() {
		boolean b = false;
		do {
			System.out.println("게임수를 입력하세요. [종료]는 0을 입력하세요.!!");
			int choice = sc.nextInt();
			switch (choice) {
				case 0:
					b = true;
					sc.close();
					System.out.println("게임을 종료합니다.");
					break;
				default:
					lottoGame(choice);  //게임수를 전달인자로 게임 시작
					break;
			}
		}while(!b);
	}

	private void lottoGame(int choice) {
		Random random = new Random();    //임이의 수를 발생하는 객체
		int[][] game = new int[choice][6];  //게임값을 담을 배열 변수
		
		for(int i = 0; i < choice; i++) {  //전체 게임수
			for(int j = 0; j < 6; j++) {  //한게임 생성
				game[i][j] = random.nextInt(44) + 1;  //1 ~ 45사이의 무작위 수 하나 생성
				if(j != 0) {
					for(int k = 0; k < j; k++) {  //게임내 중복된 수가 있는지 확인
						if(game[i][k] == game[i][j]) {
							j--;
						}
					}
				}
			}  //한게임 종료
			Arrays.sort(game[i]);  //생성된 한게임 정렬
		}  //전체 게임 종료
		toPrint(game);     //출력하는 메소드
	}

	private void toPrint(int[][] game) {
		int line = 1;  //라인수
//		Arrays.sort(game);
		System.out.println("====================");
		for(int[] num : game) {		
			for(int n : num) {
				System.out.printf("%3d",n);
			}
			if(line % 5 == 0) {  //출력된 라인수가 5인지 비교
				System.out.println();
				System.out.println("====================");
				line = 1;  //라인수 초기화
			}else {
				line ++; //라인 수를 증가
				System.out.println();
			}
		}
		System.out.println("====================");
		System.out.println("게임 금액은 " +  game.length * 1000 + "원 입니다.");
		System.out.println("====================");
	}
	
	public void run() {
		menu();
	}

	

}
