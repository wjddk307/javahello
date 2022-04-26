package co.edu.oop;

public class CalMain {

	public static void main(String[] args) {

		Calculator cal = new Calculator();
		
		cal.x = 5;
		cal.y = 2;
		
		cal.plus(10, 2);
		cal.minus(100, 40);
		cal.multi(10, 20);
		cal.div(45, 9);
		
		Car car = new Car(); //볼보
		
		Car car2 = new Car(); //쏘나타
		
		
		car.model = "볼보";
		car.color = "black";
		car.price = 20000000;
				
			
		car2.model = "쏘나타";
		car2.color = "white";
		car2.price = 3000000;

		car.info();
		
		Car car3 = new Car("그랜저", "black", 200);
		car3.info();
				
				
				
		
				
	}

}
