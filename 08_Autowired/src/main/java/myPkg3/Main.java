package myPkg3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*
		철수
		30
		모닝
		
		PersonDrive() 모닝 : Morning-drive
						그랜져 : Grandeur-drive
						
		*/
		
		
		ApplicationContext context =  new ClassPathXmlApplicationContext("appContext2.xml");
		
		Person con = (Consumer)context.getBean("myConsumer");
		con.setName("철수");
		con.setAge(30);
		
		System.out.println(con.getName());
		System.out.println(con.getAge());
		System.out.println(con.personDrive());

	}
	
}
