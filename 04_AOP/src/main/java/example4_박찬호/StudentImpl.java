package example4_박찬호;

public class StudentImpl implements Student{

	private String name;
	private int age;
	private int grade;
	private int ban;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	@Override
	public void execute() {
		System.out.println("이름 :"+name);
		System.out.println("나이 :"+age);
		System.out.println("학년 :"+grade);
		System.out.println("반 :"+ban);
	}

}
