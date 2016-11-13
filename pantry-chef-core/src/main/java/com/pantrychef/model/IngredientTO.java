package com.pantrychef.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;

import com.pantrychef.utils.Mapper;

@Entity(name="ingredients")
public class IngredientTO extends BaseTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5620092402195950733L;

	private String name;
	private String description;
	private String about;
	@Column(name = "main_tag")
	private UUID mainTag;

	@Column
	private String tags;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public List<UUID> getTags() {
		return Mapper.getInstance().readUUIDList(tags);
	}
	public void setTags(List<UUID> tags) {
		this.tags = Mapper.getInstance().write(tags);
	}
}