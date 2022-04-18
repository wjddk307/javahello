package co.yedam.var;

public class Example {

	public static void main(String[] args) {
       //반지름이 5인 원의 면적
		
		double PI = 3.14;
		int radius = 5; 
		
		double gongsic = PI * radius * radius;
		
		System.out.println(gongsic);
		
		// 덧셈 : +, 뺄셈 : -, 곱셈 : *, 나눗셈 : /
		
		// 밑면이 4 높이는 4인 정삼각형의 넒이를 구하시오.
		// 밑 면 곱하기 높이 나누기 2 = 삼각형 넓이
		
		int width = 4;
	    int height = 4;
	    
	    int gongsic2 = width * height / 2;
	    //int 대신 double도 가능(정수-실수)
	    
	    System.out.println(gongsic2);
	   
				
		
		
	}

}
