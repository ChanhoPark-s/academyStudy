package myPkg1;

public class Student {
	private Person per;
	private int kor;
	private int eng;
	
	public Student() {
		super();
	}
	public Student(Person per, int kor, int eng) {
		super();
		this.per = per;
		this.kor = kor;
		this.eng = eng;
	}
	public Person getPer() {
		return per;
	}
	public void setPer(Person per) {
		this.per = per;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public String toString() {
		return per+" , "+kor+" , "+eng;
	}

}
