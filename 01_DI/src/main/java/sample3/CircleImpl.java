package sample3;

public class CircleImpl implements Circle{
	
	private Point point; //생성자 통한 주입(injection)
	private double radius;
	
	public CircleImpl(Point point, double radius) {
		super();
		this.point = point;
		this.radius = radius;
	}

	@Override
	public void display() {
		System.out.println("원의 중심 : " + point.getXpos() +" , "+ point.getYpos());
		System.out.println("원의 면적 : "+ getArea());
	}

	@Override
	public double getArea() {
		return Math.pow(radius, 2.0) * Math.PI; 
	}
	
	
	
}
