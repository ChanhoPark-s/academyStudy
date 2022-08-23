package myPkg2;

public class MyInfo {
	private Person per;
	private Student stu;
	
	public Person getPer() {
		return per;
	}
	public void setPer(Person per) {
		this.per = per;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	
	public void personPrint() {
		System.out.println(per.getName());
		System.out.println(per.getAge());
		System.out.println(per.getHeight());
	}
	public void studentPrint() {
		System.out.println(stu.getPer());
		System.out.println(stu.getKor());
		System.out.println(stu.getEng());
	}
	public String toString() {
		return per +"          "+stu;
	}

}
