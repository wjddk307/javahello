package co.edu.extend;

public class Main2 {

	public static void main(String[] args) {
		SuperSonicAirPlane sa = new SuperSonicAirPlane();
		sa.takeOff();
		sa.fly();
		sa.flyMode = SuperSonicAirPlane.SUPERSONIC;
		sa.fly();
		sa.fltMode = SuperSonicAirPlane.NORMAL;
		sa.fly();
		sa.lan();
	}
	
}

