package co.edu.oop;

public class Student {

	//필드
	String name;
	int age;
	int kor;
	int eng;
	int math;
	
	//생성자
	public Student(){
	
}

	//메소드(함수), 기능
	void getInfo() {
		System.out.println("학생의 이름 : " + name + "\n 나이 : " + age);
	}
}