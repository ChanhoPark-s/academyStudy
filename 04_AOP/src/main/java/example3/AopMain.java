package example3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext  context = new GenericXmlApplicationContext("aopExam.xml");
		
		System.out.println("---�Խù� ��� �ϱ�---");
		Board myboard = (Board)context.getBean("myboard");
		myboard.board();//�ٽɱ��
		
		System.out.println("-----------------");
		
		System.out.println("---��ǰ �ֹ��ϱ�---");
		
		Order myorder= (Order)context.getBean("myorder");
			
		myorder.order();//�ٽɱ��
		
	}
}

/*
�α��μ���
�ȳ��ϼ���
DB �۾�������
�Խù� ����ϱ� : �ٽɱ��
�α׾ƿ� ����

�ٽɻ��� ���� ���� �͵��� ������׵��� ��� ó��
*/