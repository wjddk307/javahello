package co.edu;

public class Employee { //index.html : name속성으로 구분
	
	//필드
	private int empId;
	private String lastName;
	private String email;
	private String jobId;
	private String hireDate; 
	
	
	public int getEmpId() { //private로 선언해서 get set 필요
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

}
