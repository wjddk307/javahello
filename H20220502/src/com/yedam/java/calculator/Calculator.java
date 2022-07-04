package com.yedam.java.calculator;

public abstract class Calculator {
	
	protected double[] numList;	//입력받은 숫자 저장하는 배열
	protected int numCount;		//입력받은 숫자 갯수
	
	protected Calculator() {
		init(); //무조건 이걸 통해서 생성자를 정의하면 된다 생성자를 호출하면서 값을 초기화해주는 역할을 해준다.	
				//2개의 변수를 정의해주면되고 (numList배열의 크기를 저장해줌[2], 실제로 입력받은 수를 카운팅해줌 
				// numCount 0,-1넘카운트로 인덱스 역할을 같이해줌
	}
	
	public static void printCalType() {
		System.out.println("=========================");
		System.out.println(" 1.일반 계산기 | 2.공학 계산기 ");
		System.out.println("=========================");
	}
	
	public static Calculator getCalType(int selected) {
		Calculator cal = null;
		switch(selected) {
		case 1:
			cal = new GeneralCalculator();
			break;
		case 2:
			cal = new EngineeringCalculator();
			break;
		default:
			System.out.println("계산기 종류를 잘못 선택하셨습니다.");
		}
		
		return cal;
		
	}
	
	// 메뉴출력
	public void printMenu() {
		System.out.println("=======================================");
		System.out.println(" I | P | D | + | - | * | / | % | 0 | Q ");
		System.out.println("=======================================");
	};
     //추상메소드
	// 값 초기화
	public abstract void init();

	// 값 입력받기
	public abstract void setInputNum(double num);

	// 출력기능
	public abstract void print();

	// 더하기
	public abstract void plus();

	// 빼기
	public abstract void subtract();

	// 곱하기
	public abstract void multiply();

	// 나누기
	public abstract void division();

	// 나머지
	public abstract void remain();

	// 지우기
	public abstract void delete();
	
}
