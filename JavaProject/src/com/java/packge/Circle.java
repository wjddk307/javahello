package com.java.packge;

public class Circle {
	
	//필드
	private int radius;
	
	//생성자
	public Circle(int radius) {
		this.radius = radius;
	}
	
	//메소드
	public void show() {
		System.out.println("반지름 = " + this.radius);
	}

}
