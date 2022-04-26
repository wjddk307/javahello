package com.yadam.java.ch02_01;

public class KumhoTire extends Tire{
	
	//필드
	//생성자
	public KumhoTire(String location, int maxRotation) {
	     super(location, maxRotation);

}   
	//메소드
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location + " Tire 수명 : " + (maxRotation - accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + " HankookTire 펑크 ***");
			return false;
    }
	}
}
