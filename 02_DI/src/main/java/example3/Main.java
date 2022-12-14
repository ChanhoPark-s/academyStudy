package example3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		
		/*
		CalcBeanImpl cb = new CalcBeanImpl(2);
		
		cb.setSu1(5);
		cb.CalcBeanImpl();
		*/
		
		BeanFactory factory = new XmlBeanFactory( new ClassPathResource("appContext.xml"));
		
		
		CalcBean bean = (CalcBean)factory.getBean("bean");
		bean.calculate();
		
		
	}

}
