package myPkg2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myCircleImpl")
public class CircleImpl implements Circle {

	@Autowired
	@Qualifier("px") // PointX 에 있는 Component  
	Shape pointX;// new PointX() 알아서 넣어줌 Autowired
	// Shape 자식이 둘 이상이면 어떤 자식이 적합한지 Qualifier로 써줘야함.
	
	int x;
	int y;
	int radius;
	
	public CircleImpl() {
		System.out.println("CircleImpl 생성자");
	}
	
	public Shape getPointX() {
		return pointX;
	}
	public void setPointX(Shape pointX) {
		this.pointX = pointX;
	}
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public String make() {
		return pointX.make();
	}
	
}
