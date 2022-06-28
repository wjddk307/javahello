package co.edu;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDAO extends DAO {

	// 일정정보
	public List<CalendarVO> getSchedule() {
		// 전체 일정정보를 가지고 오도록 메소드 완성하세요.
		getConnect();
		String sql = "select * from full_calendar";
		List<CalendarVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql); // psmt : "select * from employees" 실행하고 결과 받아옴.
			rs = psmt.executeQuery(); // rs
			while (rs.next()) { // rs를 한건씩 끌어옴 -> 가지고 오면 true.
				CalendarVO  cal = new CalendarVO();
				cal.setTitle(rs.getString("title"));
				cal.setStartDate(rs.getString("start_date"));
				cal.setEndDate(rs.getString("end_date"));
				
				list.add(cal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(); // getConnect();
		}
		return list;
	}

	// 부서정보, 인원정보
	public Map<String, Integer> getDeptCnt() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		getConnect();
		String sql = "select department_name, count(1) " //
				+ "from employees e, departments d " //
				+ "where e.department_id = d.department_id " //
				+ "group by department_name";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return map;
	}

	// class => 복합적인 데이터를 하나의 변수에 작성 하고 싶을 때
	// 사원번호, 이름, 이메일, 직무 같은 정보를 하나로
	// => class 작성 : 필드로 선언
	// public void insertEmp(int eId, String name, String email, String job)
	public void insertEmp(Employee emp) {
		getConnect();
		String sql = "insert into employees(employee_id, last_name, email, job_id, hire_date)"
				+ "values(employees_seq.nextval,?,?,?,?)"; // ? : 값을 지금 지정하지 않고 psmt에서 지정하겠다.
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getLastName());
			psmt.setString(2, emp.getEmail());
			psmt.setString(3, emp.getJobId());
			psmt.setString(4, emp.getHireDate());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public List<String> getNames() {
		getConnect();
		String sql = "select first_name from employees"; // employees에서 first_name만 가져옴
		List<String> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("first_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	} // end of getNames()

	public List<Employee> empList() {
		getConnect(); // DB연결.
		String sql = "select * from employees"; // employees에서 first_name만 가져옴
		List<Employee> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql); // psmt : "select * from employees" 실행하고 결과 받아옴.
			rs = psmt.executeQuery(); // Query 실행.
			while (rs.next()) { // rs.next() : rs를 한건씩 끌어옴 -> 가지고오면 true.
				Employee emp = new Employee();
				emp.setEmail(rs.getNString("email")); // DB의 칼럼을 받아와 Employee에 담아줌.
				emp.setEmpId(rs.getInt("employee_id"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setLastName(rs.getString("last_name"));

				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}// end of empList()

}
