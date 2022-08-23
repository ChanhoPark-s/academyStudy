package example4_����ȣ;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("example4.xml"); // xml�� �����ؼ� ��ü�� �����Ѵ�.
		
		Student student = context.getBean("Student",Student.class);
		Worker worker = (Worker)context.getBean("Worker");
		
		student.execute();
		
		System.out.println("=====================");
		
		worker.excute();
		
	}
}
