package com.example.demo.model;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
public class mreq {
	private long id;
	private String name;
	private String gener;
	private String description;
	private double rate;
	
public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGener() {
		return gener;
	}

	public void setGener(String gener) {
		this.gener = gener;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public MultipartFile getImgdata() {
		return imgdata;
	}

	public void setImgdata(MultipartFile imgdata) {
		this.imgdata = imgdata;
	}

private MultipartFile imgdata;
	
}
