package com.yedam.ch08_01;

import com.yedam.java.ch08_01.Audio;
import com.yedam.java.ch08_01.Television;

public class RemoteControlExample {

	public static void main(String[] args) {

		RemoteContorl rc;
		rc = new Television();
		rc.turnOn();
		rc.setVolume(20);
		
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
	}

}
