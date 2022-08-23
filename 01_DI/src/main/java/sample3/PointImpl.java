package sample3;

public class PointImpl implements sample3.Point {//interface를 하면 덜 의존적으로 프로그래밍 할 수 있다.

	private double xpos; // 3.0 setter 주입
	private double ypos;
	
	@Override
	public double getXpos() {
		return xpos;
	}
	@Override
	public void setXpos(double xpos) {
		this.xpos = xpos;
		
	}
	@Override
	public double getYpos() {
		return ypos;
	}
	@Override
	public void setYpos(double ypos) {
		this.ypos = ypos;
		
	}

}
