package sample3;

public class CircleImpl implements Circle{
	
	private Point point; //������ ���� ����(injection)
	private double radius;
	
	public CircleImpl(Point point, double radius) {
		super();
		this.point = point;
		this.radius = radius;
	}

	@Override
	public void display() {
		System.out.println("���� �߽� : " + point.getXpos() +" , "+ point.getYpos());
		System.out.println("���� ���� : "+ getArea());
	}

	@Override
	public double getArea() {
		return Math.pow(radius, 2.0) * Math.PI; 
	}
	
	
	
}
