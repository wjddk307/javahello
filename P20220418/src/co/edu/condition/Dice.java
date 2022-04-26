package co.edu.condition;

import java.util.Scanner;

public class Dice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		while(true) {
		
		//1~6까지의 데이터를 랜덤 추출 Matk.random-소수점, int-정수만
		int num = (int)(Math.random()*6)+1;
		System.out.println("주사위의 수는 : "+num);
		//int num = sc.nextInt();
		
		if (num == 1) {
			System.out.println("숫자1");
		} else if (num == 2) {
			System.out.println("숫자2");
		} else if (num == 3) {
			System.out.println("숫자3");
		} else if (num == 4) {
			System.out.println("숫자4");
		} else if (num == 5) {
			System.out.println("숫자5");
		} else {
			System.out.println("숫자 6, 탈출");
			break;
		}
		
//		Math.random()
//		-> 0<= x <1...double
//		(0 ~ x ~10) +1  
//		1<= x <11
		
        }
		
		//학점 측정 프로그램
		int grade;
		
		System.out.println("성적을 입력하세요.");

		grade = Integer.parseInt(sc.nextLine());

		if (grade >= 90) {
			System.out.println("A학점");
		} else if (grade >= 80) {
			System.out.println("B학점");

		} else if (grade >= 70) {
			System.out.println("C학점");

		} else if (grade >= 60) {
			System.out.println("D학점");

		} else {
			System.out.println("F학점, 공부하세요.");
		}
	}
}

