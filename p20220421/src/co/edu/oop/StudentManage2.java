package co.edu.oop;

public class StudentManage2 {

	public static void main(String[] args) {

		StudentManage s1 = new StudentManage();

		s1.stnum = 2222222;
		s1.name = "박은지";
		s1.korean = 22;
		s1.math = 90;
		s1.english = 50;
		
		
		s1.program();
		s1.avg();
	}

}
