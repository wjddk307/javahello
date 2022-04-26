package com.yedam.java.ch08_01;

public class MyClass {
	//필드
	RemoteControl rc = new SmartTelevision();
	
	
	//생성자
	MyClass() {
		
	}
	MyClass(RemoteControl rc){
		this.rc = rc;
		this.rc.turnOn();
		this.rc.turnOff();
	}
	
	
	//메소드
	void methodA() {
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
	}

	public void methodB(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
}
