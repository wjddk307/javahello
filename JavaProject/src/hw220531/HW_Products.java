package hw220531;

import java.util.Scanner;

public class HW_Products {
	
	private static int arr_size;

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

				HW_Method prd = new HW_Method(); // 메소드 인스턴스 생성

				int choice = 0;
				boolean run = true;

				while(run) {
					System.out.println(" =============================================================");
					System.out.println(" | 1. 상품 수 | 2. 상품 및 가격 입력 | 3. 상품별 가격 | 4. 분석 | 5. 종료 |");
					System.out.println(" =============================================================");
				try {
					System.out.println(">>>");
					choice = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					System.out.println("메뉴 1~5의 값을 입력하십시오.");
					continue; // continue 처리 안하면 switch문 case 1 으로 떨어짐

				} // 예외처리 끝
				switch (choice) {
				case 1:
					System.out.println("상품 수량을 입력하시오.");
					prd.qty(arr_size=Integer.parseInt(sc.nextLine()));
					System.out.println(arr_size+"개로 설정합니다.");
					break;
				case 2:
					prd.nameAndpreice();
					break;
				case 3:
					prd.view();
					break;
				case 4:
					prd.maxAndsum();
					break;
				case 5:
					prd.exit();
					break;
				}// switch 끝
				} //while 끝 


	}

}
