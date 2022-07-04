package com.java.packge;

public class Child {

	public static void main(String[] args) {
		
		/*문제4) 아래와 같이 데이터가 주어졌을 경우 남녀 수와 만 20세 이하인 인원을 구하세요.
		String[] persons = {"010302-2","991203-1","969513-2","881125-1","050105-2"};
		
		- 실행결과
		남 2, 여 3
		만 20세 이하 2*/
		
	  String[] persons = {"010302-2","991203-1","969513-2","881125-1","050105-2"};
	  
      System.out.println("<남녀구분>");
      for(int i=0; i<persons.length; i++) {
    	  char ch = persons[i].charAt(7);
    	  if(ch == '1'||ch=='3') {
    		  System.out.println(persons[i] + " : 남자입니다.");
    	  }if(ch == '2'|| ch=='4') {
    		  System.out.println(persons[i] + " : 여자입니다.");
    	  }
      }
      System.out.println("<만 20세 이하>");
      for(int i=0; i<persons.length; i++) {
    	  char tw = persons[i].charAt(0);
    	  char en = persons[i].charAt(1);
    	  if(tw == '0' & en >'1') {
    		  System.out.println(persons[i] + " : 만 20세 이하입니다.");
    	  }else {
    		  System.out.println(persons[i] + " : 만 21세 이상입니다.");
    	  }
      }
	}

}
