package co.edu.condition;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		
				
				//섭씨, 화씨 -> c = 5/9(F-32)
				//scanner -> 화씨 데이터를 받고, 화씨-> 섭씨 변환 프로그램
				//주의)0.0 나올 수 도 있음.
				
				Scanner sc = new Scanner(System.in);
				System.out.print("화씨를 입력하시오 : ");
				int f = sc.nextInt(); //입력받는다.
				
				double c = 5.0/9.0*(f-32);
				
				System.out.printf("%.2f\n", c);
				
				
				
				
				
				
				//가위바위보(반복문x)
				//scanner, random
				//가위(0), 바위(1), 보(2) 게임.
				//컴퓨터와 가위바위보해서 승리/패배 출력
				
				Scanner s = new Scanner(System.in);
				System.out.print("가위(1),바위(2),보(3),끝내기(4)>>");
				String a=s.next();
				int comN = (int)(Math.random()*4);
				int num = 0;
				
				switch (a) {
				case "1":
					num=1;
				    break;
				case "2":
					num=2;
					break;
				case "3":
					num=3;
					break;
				case "4":
					num=4;
					break;
					
				}
				if(num==1 && comN==1||num==2 && comN==2||num==3 && comN==3) {
					System.out.print("사용자는->"+num);
					System.out.print("컴퓨터는->"+comN);
					System.out.println("비겼습니다.");
				}else if(num==1 && comN==2||num==2 && comN==3||num==3 && comN==1) {
					System.out.print("사용자는->"+num);
					System.out.print("컴퓨터는->"+comN);
					System.out.println("졌습니다.");
				}else if(num==1 && comN==3||num==2 && comN==1||num==3 && comN==2) {
					System.out.println("사용자는-> "+num);
					System.out.println("컴퓨터는-> "+comN);
					System.out.println("이겼습니다.");
				}else if(num==4) {
					System.out.println("종료니다.");
				
			}
				
				
				
				
				
				//학점관리 프로그램 - switch문만 사용해서 출력하기
				//scanner -> data
				//100~90이면 A 출력, 89~80이면 B 출력, 79~70이면 C출력
				
			System.out.println("\n\n학점을 입력하십시오. >>>");
			int grade = Integer.parseInt(sc.nextLine());
			int grade2 = (int) grade / 10;
			switch (grade2) {
			case 7:
				System.out.println("당신의 학점은 C입니다.");
				break;
			case 8:
				System.out.println("당신의 학점은 B입니다.");
				break;
			case 9:
				System.out.println("당신의 학점은 A입니다.");
				break;
			default:
				System.out.println("당신의 학점은 F입니다.");
				break;
			} //grade 대신에 point 사용가능.
	}
}

	
	
	
		 
		

		 
		
		
			
		

					
					
				
				
				
				


	


