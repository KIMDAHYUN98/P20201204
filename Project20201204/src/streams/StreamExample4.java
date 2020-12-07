package streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample4 {
	public static void main(String[] args) {
		
		Connection conn = DAO.getConnection();
		List<EmployeeVO> list = new ArrayList<>(); //List 라는 컬랙션을 만들어준다
		try {
			String sql = "select * from emp1";
			PreparedStatement psmt = conn.prepareStatement(sql); // 위의 sql 구문을 실행
			ResultSet rs = psmt.executeQuery(); // 최종적으로 rs에 결과 값이 담겨진다 
		while(rs.next()) {
			EmployeeVO emp = new EmployeeVO();
			emp.setEmployeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setSalary(rs.getInt("salary"));
			emp.setDepartmentId(rs.getInt("department_id"));
			list.add(emp); // 루핑돌면서 list에다가 데이터를 하나씩 담아줌
				
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Stream<EmployeeVO> stream = list.stream();
		stream.forEach(s -> s.showEmpInfo());
		
		System.out.println("==========================================================================");
		
		//1. salary 10000 이상인 사원 (람다 표현식 가능)
		System.out.println("[ salary가 10000 이상인 사원 ]");
		System.out.println();
		list.stream().filter(new Predicate<EmployeeVO>() {  // predicate타입의 인터페이스를 구현해주는 익명의 객체를 선언한다

			@Override
			public boolean test(EmployeeVO t) {
				return t.getSalary() > 10000; // 이 조건을 만족하는 메소드만 필터링 한다
			}
		}).forEach(s -> s.showEmpInfo()); // 각각의 요소들을 구현?
		
		
		
		// 2. 50번의 부서 급여 평균 // 급여에 해당되느 타입으로 매핑
		
		System.out.println("[ 부서가 50인 사원의 평균 ]");
		
		double avg = list.stream().filter(new Predicate<EmployeeVO> () {

			@Override
			public boolean test(EmployeeVO t) {
				return t.getDepartmentId() == 50;
			}
		}).mapToInt(new ToIntFunction<EmployeeVO>(){

			@Override
			public int applyAsInt(EmployeeVO value) {
				
				return value.getSalary();
			}
			
		}).average().getAsDouble();
		System.out.println("평균 : " + avg);

} // main
} // class
