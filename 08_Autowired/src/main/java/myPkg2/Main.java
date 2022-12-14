package myPkg2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		
		
		/*
		 * Shape px = new PointX(); Shape py = new PointY();
		 * 
		 * CircleImpl circle = new CircleImpl(); circle.setPointX(px);
		 * System.out.println(circle.make());
		 * 
		 * 
		 * 
		 * RectangleImpl rec = new RectangleImpl(); rec.setPointy(py);
		 */
		
		
		
		  ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		  
		  Circle circle = (Circle)context.getBean("myCircleImpl"); // Component 명을 가져옴.
		  System.out.println(circle.make());
		  
		  Rectangle rectangle = (Rectangle)context.getBean("myRectangleImpl");
		  System.out.println(rectangle.make());

		
	}
}
