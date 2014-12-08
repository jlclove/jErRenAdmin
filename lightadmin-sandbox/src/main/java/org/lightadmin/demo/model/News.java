package org.lightadmin.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

@Entity
public class News extends AbstractEntity {

	@NotNull
	@Size(min = 1, max = 100)
	private String title;

	@Size(max = 255)
	private String content;

	private String type;

	@Temporal(TemporalType.DATE)
	private Date releaseDate;

	public News(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public News() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}
