package com.java.packge;

public class MyAdder implements AdderInterface {

	@Override
	public int add(int x, int y) {
		return x+y;
	}

	@Override
	public int add(int n) {
		return n*5 + n/2;
	}



public static void main(String[] args) {
	AdderInterface adder = new MyAdder();
	System.out.println(adder.add(5,10));
	System.out.println(adder.add(10));
 }
}
