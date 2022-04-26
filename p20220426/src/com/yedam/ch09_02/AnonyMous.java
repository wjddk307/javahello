package com.yedam.ch09_02;

public class AnonyMous {
	//필드 초기값으로 대입
	Person field = new Person() {
		void work() {
			System.out.println("출근합니다.");
		}
		
		@Override
		public void wake() {
			System.out.println("6시에 일어납니다.");
			work();
		}
    };
    
    //로컬 변수값으로 대입
    void method1() {
    	Person localvar - new Person() {
    		void walk() {
    			System.out.println("산책합니다.");
    		}
    		@Override
    		public void wake(); {
    		walk();
    	
    		}
    		
    };
    
    localVar.wake();
    }
    
    void method2(Person person) {
    	person.wake();
    }
    
}
