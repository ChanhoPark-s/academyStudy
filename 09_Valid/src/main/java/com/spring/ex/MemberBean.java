package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	//@NotEmpty(message = "아이디 입력 누락")
	@NotBlank(message = "@NotBlank")
	//@NotNull(message = "@NotNull") X
	private String id;
	
	//@NotEmpty(message = "비번 입력 누락")
	//@Length(min = 3, max = 5, message="3자리 이상 5자리 이하")
	@Size(min = 3, max= 5 , message = "size 3자리이상 5자리이하")
	@Pattern(regexp = "^[0-9]+$",message = "숫자만 입력 가능")//3자리에서 5자리 숫자만
	private String pw;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}
