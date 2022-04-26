package com.yadam.java.ch03_02;

public abstract class Animal {
	public String kind;
	
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	public abstract void sound(); //각각의 동물의 소리가 다르기 때문에 abstract 삽입.

}
