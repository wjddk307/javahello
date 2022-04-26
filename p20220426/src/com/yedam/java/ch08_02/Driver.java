package com.yedam.java.ch08_02;

public class Driver {
	public void drive(Vehicle vehicle) {
		if (vehicle instanceof Bus) { //강제타입변환시 반드시 instanceof사용
		Bus bus = (Bus) vehicle;
		bus.CheckFare();
		
	}
		vehicle.run();
   }
}
