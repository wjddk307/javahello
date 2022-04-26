package co.edu.array;

import java.util.Scanner;

public class ArrayExam {

	public static void main(String[] args) {

		// 배열 -> 같은 데이터 타입을 연속된 공간에 저장.
		// int타입(정수) 배열, 5개의 데이터를 넣을 수 있는 공간.
		int[] ary = new int[5];

		// 데이터 저장하는 방법
		ary[0] = 1;
		ary[1] = 2;
		ary[2] = 3;
		ary[3] = 4;
		ary[4] = 5;

		// 데이터 저장하는 방법
		int[] ary1 = {1,2,3,4,5};
		
		// 배열 만들고, Scanner 통해서 데이터를 넣는 프로그램.
		
		
	    //Scanner 선언
		  Scanner sc = new Scanner(System.in);
		  //
		  int[]ary2 = new int[5];
		  //
		  /*for(int i =0; i<ary2.length; i++) {
			  System.out.println("데이터를 입력하세요.");
			  //
			  //
			  //
			  ary2[i] = sc.nextInt();
			  //
			  System.out.println(ary2[i]);
		  }*/
		  
		  
		for(int i=0; i<ary2.length;i++) {
			System.out.println("점수를 입력하세요");
			ary2[i] = sc.nextInt();
		}
		
		int sum = 0;
		for(int i=0; i<ary2.length;i++) {
			//
			sum += ary2[i];
			
		}
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " +(double)(sum/ary2.length));
	 
		//
		int[] ary3= new int[100];
		for(int i=0; i<ary3.length; i++) {
			//
			ary3[i] = i+1;
		}
		
		//
		sum = 0;
		
		//
		//
		//
		//
		for(int i=0; i<ary3.length; i++) {
			//
			sum  += ary3[i];
		}
		System.out.println(sum);
		
		sum = 0;
		for(int i=0; i<ary3.length; i++) {
			//
		    if(i == 99) {
		    ary3[i] = sum;
		    break;
		    }
			sum +=ary3[i];
		}
		
		System.out.println(ary3[99]);
	  }
	}


