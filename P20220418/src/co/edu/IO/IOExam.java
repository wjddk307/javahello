package co.edu.IO;

import java.io.IOException;
import java.util.Scanner;

public class IOExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//괄호 안 내용 출력
		System.out.println(false);
		//괄호 안 내용 출력 후 엔터
		System.out.println();
		//괄호 안의 내용 커스텀해서 출력
		//System.out.printf(null, args);
		
		//printf 정수
		int value = 100;
		System.out.printf("%d\n", value);  // "\n"->enter키
		System.out.printf("%5d\n", value); // 5자리(칸) 숫자 넣고 앞에 공백은 비우기
		System.out.printf("%-5d\n", value); // 5자리(칸) 숫자 넣고 뒤에 공백 비우기
		System.out.printf("%d05\n", value); // 5자리(칸) 숫자 넣고 앞에 공백 0으로 채우기
		
		//printf 실수
		double value2 = 12.123;
		System.out.printf("%.2f\n", value2); //소숫점 아래 2개까지만 표현
		System.out.printf("%9.4f\n", value2); //9자리(칸) 숫자넣고 앞에 공백 비우기,소줒점 아래는 4개&남으면 0으로 표시
		System.out.printf("%-9.0f\n", value2); //9자리(칸) 숫자넣고 뒤에 공백 비우기
		
//        try {
//        	System.out.println("값을 입력하세요.");
//        	int keyCode = System.in.read();
//			System.out.println("입력값 : " + keyCode);
//			
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
        Scanner sc = new Scanner(System.in);
//        //데이터 입력을 받기 위해 scanner 선언
        
        while(true) {  // while->반복문, "q"=반복문 종료
        	 System.out.println("스캐너 값을 입력하세요.");
             String str = sc.nextLine();
             System.out.println("입력값 : " + str);
             if(str.equals("q")) {
            	 break;
             }            
        }
        
        
       

	}

}
