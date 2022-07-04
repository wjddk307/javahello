package com.yedam.java.question;

public class GreenCard implements Payment {
	private final String name = "GreenCard";
	private String grade; //등급에 따라 포인트 적립 5%
	private int point;
	private double pointRatio; //포인트 비율

	public GreenCard() {
		this.grade = "SILVER";
		this.point = 0;
		this.pointRatio = 0.05;
	}
	@Override
	public int offline(int price) { 
		point += price * pointRatio;
		return (int) (price - (price * Payment.OFFLINE_PAYMENT_RATIO));
	}

	@Override
	public int online(int price) {
		point += price * pointRatio;
		return (int) (price - (price * Payment.ONLINE_PAYMENT_RATIO));
	}

	@Override
	public int simple(int price) {
		point += price * pointRatio;
		return (int) (price - (price * Payment.SIMPLE_PAYMENT_RATIO)); //가격 - (가격*0.05)
	}

	@Override
	public void showCardInfo() {
		System.out.println("====== 카드 정보 ======");
		System.out.println("카드명      : " + name);
		System.out.println("적용 등급   : " + grade);
		System.out.println("포인트 적립율 : " + pointRatio); //0.05가 출력되는건지?
		System.out.println("적립 포인트  : " + point);
		//할인율은 왜 출력되지 않는지?
		
	}

}
