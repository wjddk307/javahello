package loop;

public class LoopExam {

	public static void main(String[] args) {
		
		
		
        int sum = 0;
        System.out.println("1~5의 합 : " + sum);
		for(int i= 1; i<=5; i++) {
			//첫번째 sum = 0
			// 1) i=1, 0 = 0 + 1; -> sum = 1;
			// 2) i=2, 1 = 1 + 2; -> sum = 3;
			// 3) i=3, 3 = 3 + 3; ->sum = 4;
			// 4) i=4, 6 = 6 + 4; -> sum 6;
			// 5) i=5, 10 = 10 + 5; -> 최종적 sum = 15;
			sum = sum + i;
		}
		
		    //구구단, 2단 만들기
		    // @*1, 2*2, 2*3....2*9
		 for(int i = 1; i<=9; i++) {
			 for (int j=1; j<=9; j++) {
			System.out.println(i+" * " + j +" = "+ i*j);
		     }
		 }
		 for(int i = 1; i<=100; i++) {
			 if (i % 2 == 1) {
				 System.out.println(" 홀수 : " + i);
			 }else if (i % 2 == 0) {
				 System.out.println(" 짝수 : " + i);
			 }
		 }
		 

		 
         //*
         //**
         //***
         //****
         //*****
		 //i<=5
		 
		 for(int i =1; i<6; i++) {
			 
			 for(int j=1; j<=i; j++) {
				 System.out.print("*");
			 }
			 System.out.println();
	 }
		 
		 
		 System.out.println();
		 //*****
		 //****
		 //***
		 //**
		 //*
		
			for(int i =1; i<6; i++) {
				
				for(int j=5; j>=i; j--) {
					System.out.print("*");
				}
				
				System.out.println();
			}
		 
		 
			
		 //    *
		 //   **
		 //  ***
		 // ****
		 //*****
			
			//1)
			
			for(int i =0; i<=5; i++) {
				for(int j=5; j>0; j--) {
					if(i<j) {
						System.out.print(" ");
					}
					else {
						System.out.print("*");
					}
				}
				System.out.println();
				
			}
			
			
			//2)
			
			for(int i=4; i>=0;i--) {
				for(int j=0;j<5;j++) {
					if(i>j)
					System.out.print(" ");
					else
					System.out.print("*");
				}
				System.out.println();
	
			   } 
			  
				
		 
		 System.out.println("end of prog");
	
	}

}

		 
	

