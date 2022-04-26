package co.edu.member;

public class StaticMember {
	
	int a;
	
	static double PI = 3.14159;
	
	static int plus(int x, int y) {
		StaticMember sm = new StaticMember();
		return x+y+sm.a;
	}
	
	static int minus(int x, int y) {
		return x-y;
	}

}
