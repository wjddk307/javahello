package co.edu.oop;

public class Person {
	
	//필드
	String rrn;
	String name;
	String addr;
	String age;
	
	//생성자
	public Person() {
		
	}
	public Person(String rrn, String name, String addr, String age) {
		this.rrn = rrn;
		this.name = name;
		this.addr = addr;
		this.age = age;
	}
	//메소드
    void introduce() {
    	System.out.printf("Person[name : %s, age : %s, 주소 : %s]\n", name, age, addr);
    	//System.out.println(); + 대신에 윗줄 사용.
    }

}
