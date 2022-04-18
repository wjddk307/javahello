package co.yedam.var;

public class variableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int var1 =0b1011;
		int var2 = 0206;
		int var3 = 365;
		int var4 = 0xB3;
		
		System.out.println("var1" + var1);
		System.out.println("var2" + var2);
		System.out.println("var3" + var3);
		System.out.println("var4" + var4);
		
		long longVar1 = 10;
		long longVar2 = 20L;
		//long lingVar3 = 10000000000;
		long longVar4 = 10000000000L;
		
		System.out.println("longVar1 : " + longVar1 );
		System.out.println("longVar2 : " + longVar2 );
		System.out.println("longVar4 : " + longVar4 );
		
		
		char c1 = 'A';    //문자
		char c2 = 65;     //문자열, 참조타입
		char c3 = 44032;
		//단일문자, ex)아스키 코드
		
		System.out.println(c1);  //A
		System.out.println(c2);  //A
		System.out.println(c3);  //가
		
		String name = "홍길동";
		String job = "프로그래머";
		System.out.println(name);
		System.out.println(job);
		//1개 이상의 문자
		
		// \t => tab키
		System.out.println("번호\t이름\t직업");
		// \n => Enter키
		System.out.println("행 단위 출력\n");
		
		//실수 타입 : float, double
		
		//float floatVar1 = 3.14;
		float floatVar2 = 3.14f;
		
		double doubleVar1 = 0.321;
		
		float floatVar3 = 0.1234567890123456789f;
		double doubleVar2 = 0.1234567890123456789;
				
		System.out.println(floatVar3);
		System.out.println(doubleVar2);
		
		boolean stop = true;
		// 5>3 = true
		boolean state = false;
		
		if(stop) {
			System.out.println("중지합니다");
		} else {
			System.out.println("시작합니다");
		}
		
		
		
	


	}

}
