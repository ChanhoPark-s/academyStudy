package sample3;

public class PointImpl implements sample3.Point {//interface�� �ϸ� �� ���������� ���α׷��� �� �� �ִ�.

	private double xpos; // 3.0 setter ����
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
