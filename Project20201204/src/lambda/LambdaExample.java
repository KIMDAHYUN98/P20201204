package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaExample {

	static List<Student> list = Arrays.asList(
			new Student("Hong", "MALE", 70), 
			new Student("HWang", "FEMALE", 80),
			new Student("Park", "MALE", 90), 
			new Student("Choi", "FEMALE", 85));

	// 1. 여학생 정보 : 이름 - 점수
	public static void main(String[] args) {

		System.out.println("[1.여학생 정보]");
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				System.out.println(student.getName() + " - " + student.getScore());

			}
		}

		System.out.println("[2. 전체 학생 : 80점 초과]");
		for (Student student : list) {
			if (student.getScore() > 80) {
				System.out.println(student.getName() + " - " + student.getScore());
			}
		}

		System.out.println("[3. 남학생의 총점]");
		int sum = 0;
		int result = 0;
		for (Student student : list) {
			if (student.getSex().equals("MALE")) {
				result = student.getScore();
				sum += result;
			}

		}
		System.out.println(sum);

		System.out.println("[4. 여학생의 평균]");
		double avg = 0;
		int count = 0, sum1 = 0, result1 = 0;
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				count++;
				result1 = student.getScore();
				sum1 += result1;
				avg = (double) sum1 / count;
			}
		}

		System.out.println(avg);

		// 반복문 (반복자) : 스트림(반복자)
		// 스트림 생성 -> 소진
		Stream<Student> stream = list.stream();
		stream.filter((t) ->  t.getSex().equals("FEMALE"))
			  .forEach((t) -> 
				System.out.println(t.getName() + " - " + t.getScore())); 
		
		System.out.println("====================================================");
		
		stream = list.stream();
		stream.filter((t) -> t.getScore() > 80) // 1차적 필터링
			 .forEach((t) -> System.out.println(t.getName() + t.getScore())	); // 각각 메소드를 구현해라
		
		System.out.println("====================================================");
		
		int sum2 = list.stream().filter(t-> t.getSex().equals("MALE"))//
		.mapToInt((value) -> value.getScore()) // 결과 값을 int 타입을 변환
		.sum(); 
		
		System.out.println("남학생 총합 점수 : " + sum2);
		
		System.out.println("====================================================");
		
		double avg1 = list.stream().filter(t -> t.getSex().equals("FEMALE"))
		.mapToInt(s -> s.getScore())
		.average()
		.getAsDouble();
		System.out.println("평균 : " + avg);

	}

}
