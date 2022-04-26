package com.yedam.java.ch08_01;

import com.yedam.ch08_01.RemoteContorl;

public class Television implements RemoteControl { //RemoteContorl이라는
      public int volume;
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");

	}

	@Override
	public void setVolume(int volume) {
      if(volume > RemoteControl.MAX_VOLUME) {
    	  this.volume = RemoteControl.MAX_VOLUME;
      }else if(volume <= RemoteControl.MIN_VOLUME) {
    	  this.volume = RemoteControl.MIN_VOLUME;
      }else {
    	  this.volume = volume;
      }
      
      System.out.println("현재 Television 볼륨 : " + this.volume);
	}

}
