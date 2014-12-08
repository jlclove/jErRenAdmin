package org.lightadmin.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Series extends AbstractEntity {
	@Column
	@NotBlank
	private String name;

	@ManyToOne(optional = false, cascade = CascadeType.MERGE)
	private Category category;

	public Series() {

	}

	public Series(String name, Category category) {
		this.name = name;
		this.category = category;
	}

	@JsonIgnore
	public Series getCopy() {
		return new Series(this.name, this.category);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
