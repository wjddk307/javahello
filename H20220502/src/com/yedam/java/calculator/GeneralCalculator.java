package com.yedam.java.calculator;

public class GeneralCalculator extends Calculator {

	@Override
	public void init() {
		numList = new double[2]; 
		numCount = -1;
	}

	@Override
	public void setInputNum(double num) { 	
		try {
			numList[++numCount] = num;    //++가 앞이냐 뒤냐에 따라 값이 달라짐을 알아야함
			} catch (ArrayIndexOutOfBoundsException e) {      //넘카운트가 2가되면 할당연산자가 사용될때 오류가난다.
															//트라이캐치문으로 배열 크기가 넘어가면 예외처리함
			System.out.println("숫자는 최대 2개까지 입력가능합니다.");
			numCount--;	//넘카운트는 이미 +가 된상태에서 오류가 나기때문에 정상적으로 다음 메뉴를 실행하기 위해 --로 원상복귀 시키는거임
		}
	}

	@Override
	public void print() {	
		System.out.print("현재까지 입력된 숫자 : ");
		for(int i=0; i <= numCount; i++) { //넘카운트를 이용해서 최대값을 줘야함.
			System.out.print(numList[i] + " ");
		}
		System.out.println();
	}

	@Override
	public void plus() {
		if(check()) {  //체크 메소드사용 이게 트류일때만 사용 조건이 2개라 for문 사용안함 
			//조건을 체크하고 연산하면되는데 입력된 숫자가 2개가 맞는지 확인하고해야함 //  
			System.out.printf("+ : %.1f\n", numList[0] + numList[1]);
		}
	}

	@Override
	public void subtract() {
		if(check()) {
			System.out.printf("- : %.1f\n", numList[0] - numList[1]);
		}
	}

	@Override
	public void multiply() {
		if(check()) {
			System.out.printf("* : %.1f\n", numList[0] * numList[1]);
		}
	}

	@Override
	public void division() {
		if(check()) {
			System.out.printf("/ : %.1f\n", numList[0] / numList[1]);
		}
	}

	@Override
	public void remain() {
		if(check()) {
			System.out.printf("%% : %.1f\n", numList[0] % numList[1]);
		}
	}

	@Override
	public void delete() {	
		try {						//넘카운트가 인덱스랑(우리가하는건 0~1까지 초기화) 같은 역할을해서 가질 수 있는 가장 큰 숫자는 1임 
			numList[numCount--] = 0; //넘카운트 마이너스를 뒤에 하는 이유는 1을 쓰고나서 --해서 0만들어야해서
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("더이상 삭제할 숫자가 없습니다."); //넘카운트를++하던가 더이상 삭제할 숫자가 없다는것은? 처음상태로 돌리면 되는거라 
														//초기화 시키면 되기떄문에 init을 쓰면됌
			init();										//check ,delete , init을 이해하는데 초점을두자
		}
	}
	
	private boolean check() {
		boolean result = false;
		if((numCount+1) == numList.length) {
			result = true;
		}else {
			System.out.println("숫자를 더 입력해주세요.");
		}
		return result;
	}

}
