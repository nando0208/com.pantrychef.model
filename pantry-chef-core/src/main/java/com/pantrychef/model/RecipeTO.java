package com.pantrychef.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;

import com.pantrychef.utils.Mapper;

@Entity(name = "recipes")
public class RecipeTO extends BaseTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7741409539824250727L;
	
	private String name;
	private String description;
	private String about;
	@Column(columnDefinition = "jsonb")
    @Type(type="jsonb")
	private String components;
	private String yeld;
	@Column(name="preparation_time")
	private String preparationTime;
	private String author;
	private UUID provider;
	
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
	public List<UUID> getComponents() {
		return Mapper.getInstance().readUUIDList(components);
	}
	public void setComponents(List<UUID> components) {
		this.components = Mapper.getInstance().write(components);
	}
	public String getYeld() {
		return yeld;
	}
	public void setYeld(String yeld) {
		this.yeld = yeld;
	}
	public String getPreparationTime() {
		return preparationTime;
	}
	public void setPreparationTime(String preparationTime) {
		this.preparationTime = preparationTime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public UUID getProvider() {
		return provider;
	}
	public void setProvider(UUID provider) {
		this.provider = provider;
	}
}
