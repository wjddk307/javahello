package co.edu.oop;

public class CalMain {

	public static void main(String[] args) {

		Calculator cal = new Calculator();
		
		//메소드에서 메소드 호출.
		cal.execute();
		double avg = cal.avg(10, 2);
				System.out.println(avg);
				
				Calculator2 myCalcu = new Calculator2();
				
				double result1 = myCalcu.areaRectamgle(10);
				double result2 = myCalcu.areaRectamgle(10,20);
				
				System.out.println("정사각형의 넓이 : " + result1);
				System.out.println("직사각형의 넓이 : " + result2);

			
	}

}
