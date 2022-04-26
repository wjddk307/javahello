package co.edu.oop;

public class ShoppingMall {
	//필드
	String number;
	String id;
	String name;
	String pnumber;
	String add;
	
	
	//생성자
	public ShoppingMall() {
		
	}
	
	public ShoppingMall(String number, String id, String name, String pnumber, String add) {
		super();
		this.number = number;
		this.id = id;
		this.name = name;
		this.pnumber = pnumber;
		this.add = add;
	}
	
	//메소드
	void getInfo() {
		System.out.println("주문번호 : " + number);
		System.out.println("주문자아이디 : " + id);
		System.out.println("주문자이름 :  " + name);
		System.out.println("상품번호 : " + pnumber);
		System.out.println("주문자아이디 : " + add);
	}


	

}
