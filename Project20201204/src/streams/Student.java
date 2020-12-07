package streams;

public class Student implements Comparable<Student> {
	private String name;
	private int score;

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override

	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {
		if (this.score - o.score < 0) // this는 student 타입의 매개값에 비교당한다
			// = this.score < o.score
			return -1;
		else
			return 1;
		
		// = return this.score > o.score ? 1 : -1
		// 오름차순 : 음수, 같다 : 0, 내림차순 : 음수
	}

}
