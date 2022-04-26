package com.yedam.java.ch08_01;

public class SmartTelevisionExample {
	
	public static void main(String[]arg) {
		SmartTelevision tv = new SmartTelevision();
		RemoteControl rc = tv;
		Searchable searchable = tv;
	}

}
