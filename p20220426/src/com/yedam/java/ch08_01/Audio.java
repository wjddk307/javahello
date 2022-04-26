package com.yedam.java.ch08_01;

import com.yedam.ch08_01.RemoteContorl;

public class Audio implements RemoteControl{
	public int volume;
	
	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다.");

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
      
      System.out.println("현재 Audio 볼륨 : " + this.volume);
	}
	
	
}
