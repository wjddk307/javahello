package co.edu.getset;

public class Main {

	public static void main(String[] args) {

		Car mycar = new Car();
		
		mycar.setSpeed(-50);
		
		int speed = myCar.getSpeed();
		
		System.out.println(speed);
		
		//50 mile 속도를 넣음,
		myCar.setSpeed(50);
		//50 mile -> km 변환된 값을 보고싶다.
		speed = myCar.getspeed();
		
		System.out.println(speed);
		
	}

}
