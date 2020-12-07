package streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;

//class Student { // 따로 패키지에 Student 클래스를 만들어도 된다
//	
//}

public class ReduceExample {

	public static void main(String[] args) {

		List<Student> list = Arrays.asList(
				new Student("Hong", 80), 
				new Student("Hwang", 90), 
				new Student("Park", 87)

		);

		int sum = list.stream().mapToInt(new ToIntFunction<Student>() {

			@Override
			public int applyAsInt(Student value) {

				return value.getScore();
			}

		}).sum();

		System.out.println("합계 :" + sum);

		// reduce : 합산
		
		int result = list.stream().mapToInt(t -> t.getScore())
		.reduce(new IntBinaryOperator() { //optionalint 타입

			@Override
			public int applyAsInt(int left, int right) { // apply... 타입의 인터페이스를 구현, 리턴값 매개값의 타입은 같다
				System.out.println("left: " + left + ", right : " + right);
				return left + right; 
			}
			
		}).getAsInt(); // getAsInt로 출력
		
		System.out.println("결과값 : " + result);
		
		// 초기값 주는지 안 주는지에 따라 차이가 있음
		// Operator : 매개값 타입이랑 반환타입은 같은데...어쩌구...
		
		int result1 = list.stream()
				.mapToInt(t -> t.getScore())
				.reduce(0, (left, right) -> left + right);
		System.out.println("결과값 : " + result1);
		
		int max = list.stream()
				.mapToInt(t -> t.getScore())
				.reduce(0, (left, right) -> left > right ? left : right);
		System.out.println("결과값 : " + max);
		
		int min = list.stream()
				.mapToInt(t -> t.getScore())
				.reduce((left, right) -> left > right ? right : left)
				.getAsInt(); 
		// 초기값의 유무에 따라 getAsInt 써준다 
		// 초기값을 100 으로 지정하면 int 타입이기 때문에 getAsInt를 쓰지 않아도 된다
		System.out.println("결과값 : " + min);
		
		int avg = list.stream()
				.mapToInt(t -> t.getScore())
				.reduce((left, right) -> (right + left) / 2)
				.getAsInt();
		System.out.println("결과값 : " + avg);
		
		//mapToInt가 없으면 student 타입으로 출력, reduce에 integer로 타입변환 해야하는데 복잡함
		
		//
		
//		list.stream()//
//		.reduce(identity, accumulator, combiner)
		
	}
}
