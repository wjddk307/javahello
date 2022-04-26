package co.edu.casting;

public class Main {

	public static void main(String[] args) {

		Parent p1 = new Child();

		p1.method1();
		p1.method2();
		p1.method3();
		p1.method4();
		
		//클래스 타입 배열
		Parent p2 = new parent();
		Parent p3 = new parent();
		Parent p4 = new parent();
		
		Parent[] parent = {p2,p3,p4};
				
		}
				

	}


