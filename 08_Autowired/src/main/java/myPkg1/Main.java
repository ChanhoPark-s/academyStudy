package myPkg1;

public class Main {

	public static void main(String[] args) {
		
		Shape px = new PointX();
		Shape py = new PointY();
		
		CircleImpl circle = new CircleImpl();
		circle.setPointX(px);
		System.out.println(circle.make());
		
	
		
		Rectangle rec = new RectangleImpl();
		
		
			
	}
}
