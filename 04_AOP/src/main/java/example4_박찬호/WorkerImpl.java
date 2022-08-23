package example4_박찬호;

public class WorkerImpl implements Worker {

	private String name;
	private int age;
	private String job;
	
	public WorkerImpl() {
		super();
	}

	public WorkerImpl(String name, int age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}

	@Override
	public void excute() {
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("직업 : "+job);
	}

}
