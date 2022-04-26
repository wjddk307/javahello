package co.edu.oop;

import java.util.Scanner;

public class ShoppingMall2 {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		//String일땐 sc.nextLine();
		//int일땐 Integer.parseInt(sc.nextLine()); - enter가 문자공간에 버려지는것 방지.
		
		System.out.println("주문 번호 입력>");
		String number = sc.nextLine();
		System.out.println("주문자 아이디 입력>");
		String id = sc.nextLine();
		System.out.println("주문자 이름 입력>");
		String name = sc.nextLine();
		System.out.println("상품 번호 입력>");
		String pnumber = sc.nextLine();
		System.out.println("주소 입력>");
		String add = sc.nextLine();
		
        ShoppingMall sm = new ShoppingMall(number, id, name, pnumber, add);
        sm.getInfo();


				
	}

}
