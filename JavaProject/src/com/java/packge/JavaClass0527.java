package com.java.packge;

import java.util.Scanner;

public class JavaClass0527 {
	
	public static int arr_size;

	public static void main(String[] args) {
		
		// 상품 수와 상품 가격 입력받기
		// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램짜기
		// 1) 메뉴
		// | 1. 상품 수 | 2. 상품 및 가격 입력 | 3. 제품별 가격 | 4. 분석 | 5. 종료 |
		// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현
		// 3) 제품별 가격을 출력 ex) "상품명 : 가격 "
		// 4) 분석기능 : 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합
		// 5) 종료시에는 프로그램 종료한다고 메세지 출력
		
		Scanner sc = new Scanner(System.in);
		
		JavaClass05272 java = new JavaClass05272();
	    int choice = 0;
	 // | 1. 상품 수 | 2. 상품 및 가격 입력 | 3. 제품별 가격 | 4. 분석 | 5. 종료 |
		boolean run = true;
		while(run) {
			System.out.println("| 1. 상품 수 | 2. 상품 및 가격 입력 | 3. 제품별 가격 | 4. 분석 | 5. 종료 |");
			choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 1 :
				System.out.println("상품의 수량을 입력하세요.>>");
				java.array(arr_size=Integer.parseInt(sc.nextLine()));
				break;
				
			case 2 :
				java.enter();
				break;
				
			case 3 :
				java.view();
				break;
				
			case 4 : 
				java.maxsum();
				break;
				
			case 5 :
				java.exit();
				break;
			}
		
		}
	}

}
