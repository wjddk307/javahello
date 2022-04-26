package co.edu.oop;

public class Car {

	
	//필드
	String model;
	String color;
	int tire;
	int price;
	
	//생성자
	public Car() {
	}
	public Car(String a, String b,  int c) {
		model = a;
		color = b;
		price = c;
	}
	//메소드(기능)
	void info() {
		System.out.println("model =" + model);
		System.out.println("color =" + color);
		System.out.println("price =" + price);
	}
}
