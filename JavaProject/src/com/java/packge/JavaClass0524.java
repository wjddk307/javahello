package com.java.packge;

import java.util.Arrays;
import java.util.Scanner;

public class JavaClass0524 {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		//주어진 배열을 이용하여 다음 내용을 구현하세요.
		int[] arr1 = { 10, 20, 30, 50, 3, 60, -3 };
		
		//문제1. 주어진 배열 중에서 값이 60인 곳의 인덱스를 출력해보자.
		System.out.println("문제1)");
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] == 60) {
				System.out.println("arr["+ i +"]");
			}
		}
		System.out.println("-------------------------------------");
		
	
		//문제2. 주어진 배열의 인덱스가 3인 곳은 출력하지 말고, 나머지만 출력해보자.
		System.out.println("문제2)");
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] != 3) {
				System.out.println("arr["+ i +"] > " + arr1[i]);
			}
		}
		System.out.println("-------------------------------------");
		
		//문제3. 주어진 배열 안의 변경하고 싶은 값의 인덱스 번호를 입력받아, 그 값을 1000으로 변경해보자.
  		//   입력) 인덱스: 3 ->   {10, 20, 30, 1000, 3, 60, -3}
		System.out.println("문제3)");
		System.out.println("배열중 배열값을 1000으로 변경 하고싶은 인덱스 번호를 입력해주세요.(0~6)");
	    System.out.println("인덱스:");
        int	index = Integer.parseInt(sc.next());
		arr1[index] = 1000;
		System.out.println("입력된 배열의 값" + Arrays.toString(arr1));
		System.out.println("-------------------------------------");
		
		//문제4. 주어진 배열의 요소에서 최대값과 최소값을 구해보자.
		System.out.println("문제4)");
		int max = arr1[0];
		for(int i = 1; i < arr1.length; i++) {
				if(arr1[i] > max) {
					max=arr1[i];
			}
		}
		System.out.println("최대값 : " + max);
		
		int min = arr1[0];
		for(int i = 1; i < arr1.length; i++) {
				if(arr1[i] < max) {
					max=arr1[i];
			}
		}
		System.out.println("최소값 : " + max);
		System.out.println("-------------------------------------");
		
		//문제5. 별도의 배열을 선언하여 양의 정수 10개를 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력해보자.
		System.out.println("문제5)");
		System.out.println("정수10개를 입력하세요.");
		int[] scores = new int[10];
		for (int i=0; i<scores.length; i++) {
        int	numm = Integer.parseInt(sc.next());
			scores[i] += numm;
		}
		System.out.println("int[] score : " + Arrays.toString(scores));
		
		for(int i = 0; i < arr1.length; i++) {
				if(arr1[i] %3 == 0 ) {
					System.out.println("배열의 값 중 3의 배수 :" + arr1[i]);
			}
		}
		// 3의 배수 (scores[]??? %3 == 0)
		System.out.println("-------------------------------------");
		
		
		
		
		
		
		
		
	
			
	
        
	}
}
