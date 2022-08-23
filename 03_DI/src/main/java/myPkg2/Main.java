package myPkg2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		/*
		Person per = new Person("Á¶ÀÌ",30,162.8);
		
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
		*/
		
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("PerStu.xml"));
		
		Person per = (Person)factory.getBean("per");
		System.out.println(per);
		
		Student stu = (Student)factory.getBean("stu");
		System.out.println(stu);
		
		MyInfo my = (MyInfo)factory.getBean("my");
		System.out.println(my);
		
	}
}

