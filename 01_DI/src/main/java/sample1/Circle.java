package sample1;

public class Circle {
	private Point point; // Point java에 있는 것들을 멤버로 가짐.
	private double radius;
	
	
	public Circle(Point point, double radius) {
		super();
		this.point = point;
		this.radius = radius;
	}
	
	public void display() {
		System.out.println("원의 중심 : " + point.getXpos() +" , "+ point.getYpos());
		System.out.println("원의 면적 : "+ getArea());
	}
	
	public double getArea() {
		
		return Math.pow(radius, 2.0) * Math.PI;  // 반지름 구하는 방법
		
	}
	
	
	
}
