package com.yedam.ch09_01;

public class ButtonExample {

	public static void main(String[] args) {
     Button button = new Button();
     
     button.setOnClickListener(new CallListener());
     button.touch();
     
     button.setOnClickListener(new MessageListener());
     button.touch();
     
     
	}

}
