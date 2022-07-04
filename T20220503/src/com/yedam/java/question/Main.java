package com.yedam.java.question;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 예제 시나리오
		 * - 입력값 : 전월실적, 금액
		 * - 실적에 따른 회원등급을 부여받고 해당 클래스를 생성한다.
		 * - 그 회원등급에 따른 카드를 각각 생성한다.
		 * - 사용자가 각 카드별 정보를 확인하고
		 * - 해당 물건을 사기 위해 해당 카드를 선택하였을 경우 할인율과 포인트 적립율을 확인한다.
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("전월실적 >>");
		int record = scanner.nextInt();
		
		Member member = Member.getMemberShip(record);
		member.showMemberInfo();
		
		Payment myCard = null; 
		if(member instanceof Gold) {
			myCard = new VIPCard();
		}else if(member instanceof Silver) {
			myCard = new GreenCard();
		}
		System.out.println("=== 등급에 따른 카드 사용시 결제 예상금액 ===");
		System.out.println("사용할 금액 >>");
		int price = scanner.nextInt();
		System.out.println("결제방법 : 1.오프라인, 2.온라인, 3.간편결제");
		int ch= scanner.nextInt();
		
		int result = 0;
		switch(ch) {
		case 1:
			result = myCard.offline(price);
			break;
		case 2:
			result = myCard.online(price);
			break;
		case 3:
			result = myCard.simple(price);
			break;
		}
		
		System.out.println("결제 예상 금액 : " + result);
		myCard.showCardInfo();
	}
            //출력값 중 할인율 추가할인율 같이 더한 값 나와야하는거 아닌지?
}
