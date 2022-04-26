package com.java.ch02_02;

public class DriverExample {

	public static void main(String[] args) {

		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus);  //bus -> vehicle
		driver.drive(taxi);  //taxi -> vehicle
		
	}

}
