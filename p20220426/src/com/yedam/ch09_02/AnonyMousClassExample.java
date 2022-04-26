package com.yedam.ch09_02;

public class AnonyMousClassExample {

	public static void main(String[] args) {
		AnonyMousClass ac = new AnonyMousClass();
		//익명 객체 필드로 사용
		ac.rc.turnOn();
		System.out.println();
		
		//익명 객체 로컬 변수로 사용
		ac.method1();
		System.out.println();
		
		//익명 객체 매개 변수로 사용
		ac.method2(new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("SmatTV를 켭니다.");
				
			}
			
			@Override
			public void turnOff() {
				System.out.println("SmartTV를 끕니다.");
				
			}
		});

	}

}
