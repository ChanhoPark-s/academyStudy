package example4_박찬호;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("example4.xml"); // xml을 참고해서 객체를 생성한다.
		
		Student student = context.getBean("Student",Student.class);
		Worker worker = (Worker)context.getBean("Worker");
		
		student.execute();
		
		System.out.println("=====================");
		
		worker.excute();
		
	}
}
