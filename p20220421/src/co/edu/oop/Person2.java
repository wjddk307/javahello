package co.edu.oop;

public class Person2 {

	public static void main(String[] args) {


		Person p1 =  new Person("998877-1478523", "홍길동", "대구 어딘가", "20");
		Person p2 =  new Person("958877-1478523", "향단이", "부산 어딘가", "24");
		Person p3 =  new Person("918877-1478523", "석봉이", "서울 어딘가", "28");
		
		p1.introduce();
		p2.introduce();
		p3.introduce();
		
		
		
	}

}
