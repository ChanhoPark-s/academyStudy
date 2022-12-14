package sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
	
	public static void main(String[] args) {
		
		/*
		  Point point = new PointImpl(); 
		  point.setXpos(3.0); 
		  point.setYpos(4.0);
		  
		  Circle circle = new CircleImpl(point, 10.0); 
		  circle.display();
		 */
		
		Resource resource = new ClassPathResource("apContext.xml"); // bean을 만들어놓은 파일이름써라.
		
		BeanFactory factory = new XmlBeanFactory(resource); // bean을 생성해라.
		
	//  Point point = PointImpl 객체
		Point point = (Point)factory.getBean("point");//아이디에 쓴걸 쓰셈. PointImpl 객체 가져옴.
		System.out.println(point.getXpos() + " , "+point.getYpos());
	
	//  Circle circle = CircleImpl 객체	
		Circle circle =(Circle)factory.getBean("circle");
		circle.display();
		
	}
}


// DI : dependency injection