package com.java.packge;

public class NamedCircle extends Circle{
	
	public String name;
	NamedCircle(int radius, String name) {
		super(radius);
		this.name = name;
	}



public static void main(String[] args) {
	Circle w = new NamedCircle(5, "Waffle");
	w.show();
}
}