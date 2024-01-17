package com.project.bookbank.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="book_genre")
public class Genres {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bg_id")
	private Integer bgId;
	
	public List<Books> getBook() {
		return book;
	}

	public void setBook(List<Books> book) {
		this.book = book;
	}

	@Column(name="bg_name")
	private String bgName;
	
	@Column(name="bg_desc")
	private String bgDesc;
	
    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Books> book = new ArrayList<>();
	
	public Integer getBgId() {
		return bgId;
	}

	public void setBgId(Integer bgId) {
		this.bgId = bgId;
	}

	public String getBgName() {
		return bgName;
	}

	public void setBgName(String bgName) {
		this.bgName = bgName;
	}

	public String getBgDesc() {
		return bgDesc;
	}

	public void setBgDesc(String bgDesc) {
		this.bgDesc = bgDesc;
	}

	@Override
	public String toString() {
		return "Genre [bgId=" + bgId + ", bgName=" + bgName + ", bgDesc=" + bgDesc + "]";
	}

	
}
