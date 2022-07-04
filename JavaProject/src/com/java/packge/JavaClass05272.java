package com.java.packge;

import java.util.Scanner;

public class JavaClass05272 {
	
            // 상품 수와 상품 가격 입력받기
			// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램짜기
	
	Scanner sc = new Scanner(System.in);
	
	public static String[] product_arr;
	public static int [] price_arr;
	
	public void array(int arr_size) {
		
		product_arr = new String[arr_size];
		price_arr = new int[arr_size];
		System.out.println("입력하신 상품의 수량은 " + arr_size + "개 입니다.");
	}
	// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현
	public void enter() {
		String name;
		int price;
		for (int i=0; i < product_arr.length; i++) {
			System.out.println("상품명을 입력하십시오.");
			name = sc.nextLine();
			product_arr[i] = name;
			System.out.println("해당상품의 가격을 입력하십시오.");
			price =Integer.parseInt(sc.nextLine());
			price_arr[i] = price;
			
		}
	}
	// 3) 제품별 가격을 출력 ex) "상품명 : 가격 "
	public void view() {
		for (int i=0; i < product_arr.length; i++) {
			System.out.println(product_arr[i] + " : " + price_arr[i]);
		}
	}
	// 4) 분석기능 : 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합
	public void maxsum() {
		int sum = 0;
		int max = 0;
		
		for(int i=0; i < product_arr.length; i++) {
		   if(price_arr[i] > max) {
			   max = price_arr[i];
		   }
		   if(price_arr[i] != max) {
			   sum += price_arr[i];
		   }
		}
		System.out.println(" 최고가 상품의 가격 : " + max);
		System.out.println(" 최고가 제품을 제외한 나머지 제품들의 합계 :" + sum);
	}
	// 5) 종료시에는 프로그램 종료한다고 메세지 출력
	public void exit() {
		System.out.println("프로그램이 종료되었습니다.");
		System.exit(0);
	}
}
