package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {

		List<Student> list = Arrays.asList(new Student("Hong", 80), new Student("Hwang", 90), new Student("Park", 87));

		List<Student> student80s = list.stream().filter(s -> s.getScore() / 10 == 8)// 80점대만 가져온다, <filter>
				.sorted() // 정렬 //student 클래스에 implements Comparable(=인터페이스)<Student> 이라는 클래스를 구현해줘야 한다
				.collect(Collectors.toList()); // list 타입의 컬랙터

		for (Student student : student80s) {
			System.out.println("이름 : " + student.getName() + ", 점수 : " + student.getScore());
		}
		// generate toString() => system.out이라는 클래스에 println의 메소드를 호출한다
		// [ .forEach(s -> System.out.println(s)) = .forEach(System.out::println) ]

		Map<String, Integer> map = list.stream().filter(s -> s.getScore() / 10 == 8)// 80점대만 가져온다, <filter>
				.sorted().collect( // 매개값으로 toMap(key, value를 지정)메소드를 호출해서 결과값을 출력 // toList는 전체를 포함하기 때문에 메소드가
									// 없어도됨
						Collectors.toMap(new Function<Student, String>() { // Student -> String

							public String apply(Student t) { // Key에 해당되는 값
								return t.getName();
							}
						}, new Function<Student, Integer>() { // Student -> Integer

							public Integer apply(Student t) { // Value에 해당되는 값
								return t.getScore();
							}

						}) // end of toMap

				); // end of collect
					// function 을 구현해주는 두개의 매개값을 가져온다

		Set<String> set = map.keySet();
		for (String key : set) {
			System.out.println("Key : " + key + ", Value : " + map.get(key));

		}

	}
}
