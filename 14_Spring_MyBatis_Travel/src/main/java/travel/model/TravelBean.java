package travel.model;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	private int num;
	
	@NotBlank(message = "이름을 입력해주세요")
	private String name;
	
	//@Pattern(regexp = "^[0-9]+$",message = "숫자만 입력가능합니다")
	@Range(min = 10 , max = 100, message = "10~100살 사이만 입력 가능합니다.")
	private String age; 
	
	@NotNull(message = "관심지역을 선택해주세요")
	private String area;//checkbox
	
	@NotNull(message = "여행 타입을 택해주세요")
	private String style; // radio
	
	@NotBlank(message = "가격을 선택하세요")
	private String price;// select~option

	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
