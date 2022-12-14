package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class BookBean {
	
	@NotEmpty(message = "제목 입력 누락")
	private String title;
	
	@NotEmpty(message = "저자 입력누락")
	@Size(min = 5 , message = "5글자 이상 입력")
	private String author;
	
	@Size(min = 1, max = 5, message = "5자리 이하 입력")
	@Pattern(regexp = "^[0-9]+$",message = "숫자만 입력가능")
	private String price; // 길이체크할때는 String으로 해야한다.
	
	@NotEmpty(message = "출판사 입력 누락")
	private String publisher;
	
	@NotNull(message = "서점 1개 이상은 선택해야합니다.")
	private String bookstore;
	
	@NotNull(message = "배송비 체크해주세요")
	private String kind;
	
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getBookstore() {
		return bookstore;
	}
	public void setBookstore(String bookstore) {
		this.bookstore = bookstore;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	
}
