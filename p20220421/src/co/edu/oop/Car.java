package co.edu.oop;

public class Car {
	//필드(속성)
	String company; //null
	String model;
	String color;
	int maxSpeed; //0
	//생성자(객체 초기화)
	public Car() {

}
	public Car(String model, String color) {
	 this.model = model;
	 this.color = color;
	}
	public Car(String a) {
		this.model = a;
	}
	//메소드(기능)
	void info() {
		System.out.println("회사 : " + company);
		
		System.out.println("차종 : " + model);
		System.out.println("색상 : " +color);
		System.out.println("최대 속도: " + maxSpeed);
	}
}
