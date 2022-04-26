package co.edu.oop;

public class StudentManage {
    
	//필드
	int stnum;
	String name;
	int korean;
	int math;
	int english;
	
	//생성자
	public StudentManage( ) {
		
	}
	
	
	//메소드
	    void program( ) {
	    	System.out.printf("[학번 : %d, 이름 : %s, 국어 : %d, 수학 : %d, 영어 : %d]\n",stnum, name, korean, math, english);
	    }
	    
	    void avg() {
	    	int result = (korean+math+english)/3;
	    	System.out.println("평균점수 : " + result);
	    			
	    }
	    
}
