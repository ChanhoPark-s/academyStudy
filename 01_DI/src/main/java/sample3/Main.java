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
		
		Resource resource = new ClassPathResource("apContext.xml"); // bean�� �������� �����̸����.
		
		BeanFactory factory = new XmlBeanFactory(resource); // bean�� �����ض�.
		
	//  Point point = PointImpl ��ü
		Point point = (Point)factory.getBean("point");//���̵� ���� ����. PointImpl ��ü ������.
		System.out.println(point.getXpos() + " , "+point.getYpos());
	
	//  Circle circle = CircleImpl ��ü	
		Circle circle =(Circle)factory.getBean("circle");
		circle.display();
		
	}
}


// DI : dependency injection