package co.edu.oper;

public class OperatorExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//논리부정 연산자
		boolean flag = true; //true, false
		System.out.println(flag);
		System.out.println(!flag); // !->논리부정
		
		
		int i = 101;
        if(i <= 100) { // >=, <=, <,>,!=
        	System.out.println("참입니다.");
	    } else {
	    	System.out.println("거짓입니다.");
	    }
        
        String str = "써브웨이";
        String str2 = "써브웨이";
        		if(str.equals(str2)){
                    System.out.println("맛있다.");
        		}else {
        			System.out.println("별로다.");
        		}
        		
        		int var = 6;
        		if(var % 2== 0&& var % 3 == 0) {// &&, &차이
        			System.out.println("2의 배수이면서, 3의 배수입니다.");
        		}else {
        			System.out.println("2 그리고 3의 배수가 아닙니다.");
        		}
        		
        		
        		var = 9;
        		
        		if(var % 2== 0|| var % 3 == 0) {
        			System.out.println("2의 배수이면서, 3의 배수입니다.");
        		}else {
        			System.out.println("2 그리고 3의 배수가 아닙니다.");
        		}
        		
        		boolean flag2 = true;
        		
        		if(!flag2) {
        			System.out.println("참");
        		}else {
        			System.out.println("거짓");
        		
        		}
        		
        		int score = 99;
        		char grade = (score > 90) ? 'A' : 'B';
        		
        		System.out.println("학점은 " + grade + "입니다.");
        		
	}
}
