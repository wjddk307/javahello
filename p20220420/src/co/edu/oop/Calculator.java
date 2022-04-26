package co.edu.oop;

public class Calculator {

	//필드
	// 숫자를 받을 수 있는 변수
	int x;
	int y;
	
	//생성자
	
	//메소드(기능)
	//1. 덧셈
	void plus(int x, int y) {
		System.out.println("덧셈 : " + (x + y ));
	}
	//2. 뺄셈
	void minus(int x, int y) {
		System.out.println("뺄셈 : " + (x -y));
	}
	//3. 곱셈
	void multi(int x, int y) {
		System.out.println("곱셈 : " + (x *y));
	}	
	//4. 나눗셈
		void div(int x, int y) {
			System.out.println("나눗셈 : " + (x /y));
    }
}
		
		
		
