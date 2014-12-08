package org.lightadmin.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category extends AbstractEntity {
	@NotNull
	@Size(min = 1, max = 25)
	private String name;
	
	@OneToMany(mappedBy = "category", cascade = { CascadeType.ALL })
	private List<Series> seriesList = new ArrayList<Series>();

	public Category(String name) {
		this.name = name;
	}

	public Category() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Series> getSeriesList() {
		return seriesList;
	}

	public void setSeriesList(List<Series> seriesList) {
		this.seriesList = seriesList;
	}

}
