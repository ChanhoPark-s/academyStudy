package com.spring.ex.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class footBallDto {
	private int num;
	
	@NotEmpty(message = "아이디를 입력하세요")
	private String id;
	
	@Size(min = 5, max = 12 ,message = "5~12글자만 입력가능합니다.")
	@NotEmpty(message = "비밀번호를 입력하세요")
	private String pw;
	
	@NotEmpty(message = "체크하세요")
	private String win;
	@NotEmpty(message = "체크박스를 선택하세요")
	private String round16;

	
	public footBallDto() {
		super();
	}
	public footBallDto(int num, String id, String pw, String win, String round16) {
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.win = win;
		this.round16 = round16;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
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
	public String getWin() {
		return win;
	}
	public void setWin(String win) {
		this.win = win;
	}
	public String getRound16() {
		return round16;
	}
	public void setRound16(String round16) {
		this.round16 = round16;
	}
	
	
}
