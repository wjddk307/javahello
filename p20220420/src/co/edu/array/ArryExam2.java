package co.edu.array;

import java.util.Scanner;

public class ArryExam2 {

	public static void main(String[] args) {

		int[] ary1 = {5,10,4,7,8,};
		
		//
		int max = 0;
		//
		int min = ary1[0];
		
		for(int i=0; i<ary1.length; i++) {
			//
			if(max < ary1[i]) {
				max = ary1[i];
			}
			//
			if(min > ary1[i]) {
				min = ary1[i];
			}
		}
		System.out.println("최대값" + max);
		System.out.println("최소값" + min);
		
		Scanner sc = new Scanner(System.in);
				//
				int[] ary2 = null;
		System.out.println("배열의 사이즈를 입력하세요.");
		//
		int num = sc.nextInt();
		ary2 = new int[num];

		
		for(int i=0; i<ary2.length; i++) {
			//
			ary2[i] = i+1;
		}
		
		for(int i=0; i<ary2.length; i++) {
			//짝
			if(ary2[i] % 2 ==0) {
				System.out.println(ary2[i]);
			}
		}
		
		for(int i=0; i<ary2.length; i++) {
			//홀
			if(ary2[i] % 2 ==1) {
				System.out.println(ary2[i]);
			}
		}
		
		int[] ary3 = new int[num];
		
		//
		for(int i=0; i<ary3.length; i++) {
			ary3[i] = i;
		} 
		
		//
		for(int i =0; i<ary2.length; i++) {
			for(int j =0; i<ary3.length; j++) {
				if(ary2[i]+ary3[j] < 10) {
		System.out.println("1." + ary2[i] + "2 "+ary3[j]);
				}
			}
		}
	}

}
