package streams;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String[] args) {
		// 1~100 까지 숫자 rangeClosed
		// 짝수만 결과 출력

		IntStream is = IntStream.range(1, 100);
		is.filter(t -> t % 2 == 0).forEach(s -> System.out.println(s)); // 매개값을 받아서 메소드 기능을 구현

		int sum = IntStream.rangeClosed(1, 100)//
				.filter(t -> t % 2 == 0)//
				.sum();

		System.out.println(sum);

		int[] intAry = { 2, 6, 4, 8, 1, 9 }; // 배열로 스트림한다고,,?
		IntStream Is = Arrays.stream(intAry);

//		System.out.println(Is);
//		
//		OptionalInt max = Is.max(); // OptionalInt : class -> 주소값을 출력함
//		
////		System.out.println(max);
//		
//		int iMax = max.getAsInt(); // getAsInt -> int 타입으로 출력 
//		System.out.println(iMax);

		System.out.println(Is);

		int max = Is.min().getAsInt(); // getAsint 가 최종적으로 타입을 지정해 출력 : 최종처리

		System.out.println(max);

		Is = Arrays.stream(intAry);
		OptionalDouble avg = Is.average();

		System.out.println(avg);

		double iAvg = avg.getAsDouble();
		System.out.println(iAvg);

		// 조건(filter)
		Arrays.stream(intAry).filter((int a) ->  a % 2 == 0)
			  .forEach((int a) -> System.out.println(a));

		// 원본
//		Arrays.stream(intAry).filter(new IntPredicate() {
//
//			@Override
//			public boolean test(int a) {
//				return a % 2 == 0;
//			}
//
//		}).forEach(new IntConsumer() { // intconsumer 타입이 온다
//
//			@Override
//			public void accept(int a) {
//				System.out.println(a);
//
//			}
//
//		});

	}

}
