package example4_����ȣ;

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
		System.out.println("�̸� : "+name);
		System.out.println("���� : "+age);
		System.out.println("���� : "+job);
	}

}
