package streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;

public class StreamExample5 {
	public static void main(String[] args) {

		Connection conn = DAO.getConnection();
		List<EmployeeVO> list = new ArrayList<>(); // List 라는 컬랙션을 만들어준다
		try {
			String sql = "select * from emp1";
			PreparedStatement psmt = conn.prepareStatement(sql); // 위의 sql 구문을 실행
			ResultSet rs = psmt.executeQuery(); // 최종적으로 rs에 결과 값이 담겨진다
			while (rs.next()) {
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

//		 2. 50번의 부서 급여 합계와 평균 // 급여에 해당된느 타입으로 매핑

		System.out.println("[ 부서가 50인 사원 ]");

		OptionalDouble avg = list.stream()//
				.filter(t -> t.getDepartmentId() == 50)
				.mapToInt((e) -> e.getSalary())
				.average();
		
		System.out.println("평균 : " + avg.orElse(0.0));	// orElse : in the average()	
		
		
		//or Else(0,0) : 값이 없으면 0.0으로 대체한다

//		avg.ifPresent(new DoubleConsumer() {
//
//			@Override
//			public void accept(double value) {
//				System.out.println("급여 평균 : " + avg.getAsDouble());
//
//			}
//
//		}); 
		// avg에 값이 있으면 그대로 실행, 없으면 에러발생하지 않고 값이 없는 채로 출력
		// avg에 값이 있을경우 double 타입의 값을 가져옴

		// 값이 없는 경우에는 에러 발생
	}

}
