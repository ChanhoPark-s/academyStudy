package myPkg2;

public class StudentImpl implements Student{

	private Person per;
	private int kor;
	private int eng;
	
	@Override
	public Person getPer() {
		return per;
	}

	@Override
	public void setPer(Person per) {
		this.per = per;
	}

	@Override
	public int getKor() {
		return kor;
	}

	@Override
	public void setKor(int kor) {
		this.kor = kor;
	}

	@Override
	public int getEng() {
		return eng;
	}

	@Override
	public void setEng(int eng) {
		this.eng = eng;
		
	}
	public String toString() {
		return per+" , "+kor+" , "+eng;
	}
	
	
}
