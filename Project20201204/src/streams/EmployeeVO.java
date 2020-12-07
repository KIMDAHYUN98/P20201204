package streams;

public class EmployeeVO {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private int salary;
	private int departmentId;

	// 생성자 : lastName, email, jobId, hireDate

	public EmployeeVO(String lastName, String email, String hireDate, String jobId) {
		super();
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.jobId = jobId;
	}
	
	public EmployeeVO(String firstName, String lastName, int employeeId, String email, String hireDate, String jobId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.email = email;
		this.hireDate = hireDate;
		this.jobId = jobId;
	}
		public EmployeeVO() {
			
		}
		
		
	public EmployeeVO(int employeeId, String firstName, String lastName, String email, String phoneNumber,
				String hireDate, String jobId, int salary, int departmentId) {
			super();
			this.employeeId = employeeId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.hireDate = hireDate;
			this.jobId = jobId;
			this.salary = salary;
			this.departmentId = departmentId;
		}

	public int getDepartmentId() {
			return departmentId;
		}

	public void setDepartmentId(int departmentId) {
			this.departmentId = departmentId;
		}

	public int getEmployeeId() {
		return employeeId;

	}
		
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void showEmpInfo() {
		System.out.println("사원번호 : " + employeeId + ", firstName : " + firstName + ", lastName : " + lastName
				+ ", email : " + email + ", salary : " + salary + "department_id : " + departmentId);

	}

}
