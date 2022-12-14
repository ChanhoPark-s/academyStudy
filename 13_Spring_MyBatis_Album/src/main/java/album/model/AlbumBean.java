package album.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class AlbumBean {
	private int num;
	
	@NotBlank(message = "제목을 입력해주세요")
	private String title;
	
	@Size(min = 3, max=7, message = "3~7글자만 입력 가능합니다.")
	private String singer;
	
	@Min(value = 1000 , message = "가격은 최소 1000원 이상입니다.")
	private String price;
	private String day;
	
	
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
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
	
}
