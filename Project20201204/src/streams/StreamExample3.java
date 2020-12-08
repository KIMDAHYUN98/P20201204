package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import lambda.Student;

public class StreamExample3 {
	public static void main(String[] args) {

		String[] str = "Java8 lambda".split(" "); // split method : 문자열 배열, 공란을 기준으로 센다

		List<String> strList = Arrays.asList("Java8 lambda", "stream mapping");

		strList.stream().flatMap(new Function<String, Stream<String>>() { // 매개값 : String, 반환값 : Stream<String>

			// flatMap 은 stream 타입으로 반환

			@Override
			public Stream<String> apply(String t) { // 문자열 배열을 문자열 스트림을 변환
				return Arrays.stream(t.split(" ")); // 배열
			}

		})
//		.filter(s -> s.startsWith("s"))  // s로 시작하는 문자 반환..
				.forEach(s -> System.out.println(s));

		strList.stream().map(new Function<String, String>() {

			@Override
			public String apply(String t) { // 리턴되는 타입만 정해주면 알아서 stream을 생성

				return t.toUpperCase(); // 대문자로 변환
			}

		}).forEach(s -> System.out.println(s));

		List<Student> students = Arrays.asList(
				new Student("송다희", "F", 80), 
				new Student("윤태현", "M", 75),
				new Student("이혜빈", "F", 85), 
				new Student("정병기", "M", 90));

		double avg = students.stream()
		.mapToInt(new ToIntFunction<Student>() {// map : 문자, mapToInt : 숫자로 변환

			@Override
			public int applyAsInt(Student t) {

				System.out.println(t.getName()+ " : " + t.getScore());
				return t.getScore();
			}

		}).average()
		.getAsDouble();
		System.out.println("평균 : " + avg);
		
		
		
	}
	

}
