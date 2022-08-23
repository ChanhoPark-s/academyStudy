package sample1;

public class Circle {
	private Point point; // Point java�� �ִ� �͵��� ����� ����.
	private double radius;
	
	
	public Circle(Point point, double radius) {
		super();
		this.point = point;
		this.radius = radius;
	}
	
	public void display() {
		System.out.println("���� �߽� : " + point.getXpos() +" , "+ point.getYpos());
		System.out.println("���� ���� : "+ getArea());
	}
	
	public double getArea() {
		
		return Math.pow(radius, 2.0) * Math.PI;  // ������ ���ϴ� ���
		
	}
	
	
	
}
