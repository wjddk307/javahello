package co.edu.condition;

import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		
		while(run) {
			int num = (int)(Math.random() * 6) + 1;
			System.out.println("주사위의 수는 : "+num);
        switch (num) {
		case 1:
			System.out.println("주사위는 1");
			break;
		case 2:
			System.out.println("주사위는 2");
			break;
		case 3:
			System.out.println("주사위는 3");
			break;
		case 4:
			System.out.println("주사위는 4");
			break;
		case 5:
			System.out.println("주사위는 5");
			break;
	    default:
			System.out.println("주사위는 6");
			run = false;
			break;
		}
	}
	}
}
