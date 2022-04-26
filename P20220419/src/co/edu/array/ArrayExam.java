package co.edu.array;

public class ArrayExam {

	public static void main(String[] args) {
    
		int[] ary = new int[5];  //0~9
		
		int[] ary1 = {1,2,3,4,5};
		System.out.println(ary1.length);
		int sum =0;
		for(int i=0; i<ary.length; i++) {
			sum += ary1[i];
		}
		System.out.println("총합 : " + sum);
		
		
		
		//3칸짜리 int 타입 배열
		int[] scores = {83, 90, 87};
		
		//score 배열 세첫번째 데이터
		System.out.println(scores[0]);
		//score 배열 두번째 데이터
		System.out.println(scores[1]);
		//score 배열 세번째 데이터
		System.out.println(scores[2]);
		
		int sum2 = 0;
		for(int i = 0; i<scores.length; i++) {
			sum2 += scores[i];
		}
		System.out.println("총합 : "+ sum2);
		double avg = (double) sum2 /3;
		System.out.printf("평균 : %.2f", avg);
			
		
		//최대, 최소값 구하기
		int max = 0;
		int[] ary2 = {5,3,2,8,1};
		
		int min = ary2[0]; //0
		
		for(int i=0; i<ary2.length; i++) {
			//최대값
			if(max < ary2[i]) {
				max = ary2[i];
			}
			//최소값
			if(max > ary2[i]) {
				max = ary2[i];
			}
		}
		System.out.println(max);
	 }
				
	}


