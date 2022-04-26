package co.edu.member;

public class Pizza {
	
	//필드
	private String toppings;
	private int radius;
	static final double PI = 3.141592;
	static int count =0;
	
	//생성자
	
	
	//메소드
	public Pizza(String toppings) {
		this.toppings = toppings;
		count++;
	}
	

}
