package movie.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class MovieBean {
	
	private int num;
	
	@NotBlank(message = "필수 입력사항입니다")
	private String title;
	@NotBlank(message = "대륙 필수 입력사항입니다")
	private String continent;
	@NotBlank(message = "나라 필수 입력사항입니다")
	private String nation;
	@NotNull(message = "최소 1개 이상 선택하세요")
	private String genre;
	@NotNull(message = "필수 입력사항입니다.")
	private String grade;
	
	@NotBlank(message = "출연배우를 입력해주세요")
	private String actor;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	
}
