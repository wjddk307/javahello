package com.yadam.java.ch03_01;

public class SmartPhone extends Phone {

	public SmartPhone(String owner) {
		super(owner); //super : 부모클래스의 생성자 호출-무조건 1순위
    }
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}

}
