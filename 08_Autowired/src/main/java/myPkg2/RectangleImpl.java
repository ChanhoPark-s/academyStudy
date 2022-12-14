package myPkg2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myRectangleImpl")
public class RectangleImpl implements Rectangle {

	@Autowired
	@Qualifier("PointY")
	Shape pointy;
	
	int x;
	int y;
	int radius;
	
	public Shape getPointy() {
		return pointy;
	}

	public void setPointy(Shape pointy) {
		this.pointy = pointy;
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
		return pointy.make();
	}

}
