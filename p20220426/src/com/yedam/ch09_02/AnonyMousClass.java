package com.yedam.ch09_02;

public class AnonyMousClass {
	//필드 초기값으로 대입
	RemoteControl rc = new RemoteControl() {
		
		@Override
		public void turnOn() {
			System.out.println("TV를 켭니다.");
			
		}
		
		@Override
		public void turnOff() {
			System.out.println("TV를 끕니다.");
			
		}
	};
	//로컬 변수값으로 대입
	
	void method1() {
		RemoteControl loCalVar = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("Audio를 켭니다.");
				
			}
			
			@Override
			public void turnOff() {
			 System.out.println("Audio를 끕니다.");
				
			}
		};
		
		loCalVar.turnOn();
		loCalVar.turnOff();
		
	}
	
	void method2(RemoteControl rc) {
		rc.turnOn();
		
	}
		
		
	

}
