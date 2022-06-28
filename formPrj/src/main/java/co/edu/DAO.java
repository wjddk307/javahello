package co.edu; //기본기능은 DAO 커넥션

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO { // db에 접근하여 경로 만들어줌(통로역할)
	public Connection conn; // conn을 통해 db에 접속
	public PreparedStatement psmt;
	public ResultSet rs;

	public void getConnect() { // getConnect 실행되면 DriverManager가 conn무조건 생성
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  // DriverManager
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); //jdbc의 주소
		} catch (ClassNotFoundException | SQLException e) { // conn : select ,update등 수행
			e.printStackTrace();
		}
	}

	public void disconnect() {
		if (conn != null) // 인스턴스가 할당이 되면
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
