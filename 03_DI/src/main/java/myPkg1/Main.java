package myPkg1;

public class Main {

	public static void main(String[] args) {
		Person per = new Person("????",30,162.8);
		
		Student stu = new Student();
		stu.setPer(per);
		stu.setKor(70);
		stu.setEng(80);
		
		MyInfo my = new MyInfo();
		my.setPer(per);
		my.setStu(stu);
		
		System.out.println(per);
		System.out.println(stu);
		System.out.println(my);
	}
}
