package com.yedam.java.question;

public class VIPCard implements Payment {
	private final String name = "VIPCard";
	private String grade;
	private double saleRatio;
	private int point;
	private double pointRatio;

	public VIPCard() {
		this.grade = "GOLD";
		this.saleRatio = 0.1; //할인율
		this.point = 0;
		this.pointRatio = 0.03;
	}
	@Override
	public int offline(int price) {
		point += price * pointRatio;
		return (int) (price - (price * (saleRatio+Payment.OFFLINE_PAYMENT_RATIO)));
	}

	@Override
	public int online(int price) {
		point += price * pointRatio;
		return (int) (price - (price * (saleRatio+Payment.ONLINE_PAYMENT_RATIO)));
	}

	@Override
	public int simple(int price) {
		point += price * pointRatio;
		return (int) (price - (price * (saleRatio+Payment.SIMPLE_PAYMENT_RATIO)));
	}

	@Override
	public void showCardInfo() {
		System.out.println("====== 카드 정보 ======");
		System.out.println("카드명      : " + name);
		System.out.println("적용 등급   : " + grade);
		System.out.println("할인율 : " + saleRatio);
		System.out.println("포인트 적립율 : " + pointRatio);
		System.out.println("적립 포인트 : " + point);
		
	}

}
