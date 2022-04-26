package com.yedam.ch09_01;

public class A {   //바깥 클래스
	A(){
		System.out.println("A 인스턴스가 생성됨.");
	}
	
	//인스턴스 멤버 클래스 -무조건 인스턴스가 존재 해야함
	class B {
		B() {
			System.out.println("B 인스턴스가 생성됨.");
		}
		//필드
		int field1;
		//static int field2;
		
		//메소드
		void method1() {
			
		}
		//static void method2() {}
	
	     }
    
  
	
	//정적 멤버 클래스
	static class C {
		C() {
			System.out.println("C 인스턴스가 생성됨.");
		   }
		
		//필드
		int field1;
		static int field2;
		
		//메소드
		void method1() {
			}
		
		static void method2() {
			
		}
		
	
	
	void methood() {
	//로컬 클래스
	 class D {
		 D() {
		 System.out.println("D 인스턴스가 생성된.");
	 }
		 
		 //필드
		 int field1;
		 //static int firld2;
		 
		 //메소드
		 void method1() {
			 }
		 
		 //static void method2() {
			 }
		 
		 D d= new D();
	   }
	}
}
	 
		
	     

      
  

