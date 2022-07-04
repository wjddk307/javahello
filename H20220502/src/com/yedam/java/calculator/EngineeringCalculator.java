package com.yedam.java.calculator;

public class EngineeringCalculator extends Calculator { //우리는 개별과제로 클래스를 만들때 매서드를 만드는게 약하고 함수의 기능을 창조하는게 힘듬
														//고민하면서 대충은 이렇게 짜면 되는구나 학습되니까 낸 과제임.
														//매서드 1개가 하나의 기능을 가지면 끝임
	private String[] operatorList; // 입력받은 연산자 저장하는 배열
	private int operatorCount; // 입력받은 연산자 갯수

	@Override				
	public void init() {			//하나의 식을 구성해서 그 식을 완성하는 공학계산기 //숫자도 저장하고 연산자도 별도로 저장해야함
									//2가지 연산자를 저장하고 입렵ㄱ받은 연산자 저장하는 변수 2개를 선언해서 구성이 4개임
		numList = new double[5];	//숫자 5개를 가짐
		numCount = -1;				//연산자는 무조건 배열에서 -1개
		operatorList = new String[numList.length - 1];
		operatorCount = -1;
	}

	@Override
	public void setInputNum(double num) {
		try {
			numList[++numCount] = num;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("숫자는 최대 5개까지 입력가능합니다."); //일반계산기와 동일
			numCount--;
		}
	}

	@Override
	public void print() {//숫자가 연산자보다 무조건 많아야하는 조건을 달성해야 작동됌	 //경우에 따라 기능이 2개가 되야하면 원래 가지고있던걸 조합해서  씀.	
		if(check()) {		
			System.out.println("계산결과 : " + getCalResult());
		}
	}
	
	private boolean check() { //숫자가 연산자보다 무조건 많아야하는 조건을 달성해야 작동됌		
		boolean result = false;
		if((operatorCount + 1) == numCount) { //연산자보다 숫자가 최소한 1개가 많아야 정상적인 연산식으로보고 사용가능.
			result = true;
		}else {
			System.out.println("현재까지 입력된 연산식을 확인해주세요.");
		}
		return result;
	}
	
	private double getCalResult() {
		double result = numList[0];      //숫자가 첫번쨰값을 초기값으로 가짐 //첫번째값과 연산자의 관계를 확인함
		for(int i=0; i<=operatorCount; i++) {	//숫자가 가진 배열에서 0번째 인덱스값을 따로처리함 마지막 숫자나 첫번째 것을 1개 빼버림
			switch(operatorList[i]) {			// 연산자가 가지고 있는 카운트수로 나머지는 ++로 누적시켰음
			case "+":						// 결과를 반호나해서 프린트에서  getCalResult() 로 출력되게함.
				result += numList[i+1];
				break;
			case "-":
				result -= numList[i+1];
				break;
			case "*":
				result *= numList[i+1];
				break;
			case "/":
				result /= numList[i+1];
				break;
			case "%":
				result %= numList[i+1];
				break;
			}
		}
		return result;
	}

	@Override
	public void plus() {
		try {
			operatorList[++operatorCount] = "+";     //해당되는 연산자를 직접 넣어주는데 "+" 문자가 됌
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("연산자는 최대 4개까지 입력가능합니다.");
			operatorCount--;
		}
	}

	@Override
	public void subtract() {
		try {
			operatorList[++operatorCount] = "-";
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("연산자는 최대 4개까지 입력가능합니다.");
			operatorCount--;
		}
	}

	@Override
	public void multiply() {
		try {
			operatorList[++operatorCount] = "*";
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("연산자는 최대 4개까지 입력가능합니다.");
			operatorCount--;
		}
	}

	@Override
	public void division() {
		try {
			operatorList[++operatorCount] = "/";
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("연산자는 최대 4개까지 입력가능합니다.");
			operatorCount--;
		}
	}

	@Override
	public void remain() {
		try {
			operatorList[++operatorCount] = "%";
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("연산자는 최대 4개까지 입력가능합니다.");
			operatorCount--;
		}
	}

	@Override
	public void delete() { //연산자를 먼저 삭제시킬건제 숫자를 먼저 삭제시킬것인지가 문제임 
		try {
			if (numCount > operatorCount) {  //숫자를 먼저 삭제해야하는 조건이 뭘까? ->결국엔 입력받은 숫자의 갯수가 연산자의 개수보다 많으면 숫자를 먼저 삭제
				numList[numCount--] = 0;	//넘카운트가 숫자보다크면 숫자초기화						->숫자보다 많거나 숫자랑 같다면 연산자를 삭제해야함.						
			} else {
				operatorList[operatorCount--] = null;	//아니면 연산자 배열을 초기화
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("더이상 삭제할 값이 없습니다.");  //입력값보다 많이 삭제하면 더이상 삭제할 것이 없다.
			init();			//두 배열을 초기화 해야하기때문에 각각의 명령어를 쓰기보다는 이닛을 쓰는것이 편하다는걸 알아둬라.								
		}

	}
	
	@Override
	public void printMenu() {		//공학계산기랑 일반 계싼기는 메뉴를 출력하는건 똑같은데 현재까지 입력된 연산식을 출력하는건 다름
		super.printMenu();			//printMenu(); 부모클래스가 가지고있는 기능을 갖고옴
		getExpression();			//메소드를 이용하여 공학용 계싼기가 가지고있어야하는 기능을 1개 더 추가함.
	}
	
	private void getExpression() {
		String result = "";
		for(int i=0; i < numList.length; i++) {
			if(i<=numCount) {
				result += String.valueOf(numList[i]);
			}
			
			if(i<=operatorCount) {
				result += operatorList[i];
			}
		}
		
		System.out.println("현재 연산식 : " + result);
	}
}
