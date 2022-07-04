package hw220531;

 import java.util.Scanner;

    public class HW_Method {
	Scanner sc = new Scanner(System.in);
	// | 1. 상품 수 | 2. 상품 및 가격 입력 | 3. 제품별 가격 | 4. 분석 | 5. 종료 |
	// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현
	// 3) 제품별 가격을 출력 ex) "상품명 : 가격 "
	// 4) 분석기능 : 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합
	// 5) 종료시에는 프로그램 종료한다고 메세지 출력

  public static String[] products_arr;
  public static int[] price_arr;


  public void qty(int arr_size) {
  //메뉴에서 1번을 입력하면 배열의 사이즈를 정할 수 있다.
  products_arr = new String[arr_size];
  price_arr = new int[arr_size];
}
  public void nameAndpreice() {
  //입력받은 배열 사이즈만큼 상품명과 가격입력
  String name; //상품명
  int price;
  System.out.println("등록된 products_arrr값은 "+ products_arr.length +"입니다.");
  for(int i = 0; i < products_arr.length; i++) { // 상품명 입력받는 반복문
	  System.out.println("상품명을 입력하십시오. >>>");
	  name = sc.nextLine();
	products_arr[i] = name;
	System.out.println("해당 상품 가격을 입력하십시오. >>>");
	price = Integer.parseInt(sc.nextLine());
	price_arr[i] = price;
	System.out.println("==> 상품 "+ products_arr[i]+", "+price_arr[i]+"원 등록이 완료되었습니다.");
}
}//nameAndpreice Method end
  public void view() {
  System.out.println("======== 등록 된 상품 목록 ========");
  for(int i = 0; i < products_arr.length; i++) {
  System.out.println(">> " + products_arr[i]+" : "+price_arr[i]+"원");
}
}

  public void maxAndsum() {
  int max = 0;
  int sum = 0;
  for(int i = 0; i < price_arr.length; i++){
	if(price_arr[i] > max) {
		max = price_arr[i];
	}
	if(price_arr[i] != max) {
		sum += price_arr[i];
	}
}
  System.out.println("========== 분석 ==========");
  System.out.println("등록된 상품 중 최고가 : "+ max);
  System.out.println("최고가 상품을 제외한 상품들의 총 합 " + sum);
}
  public void exit() {
  System.out.println("프로그램을 종료합니다.");
  System.exit(0); 
}

}
