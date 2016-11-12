package com.pantrychef.model;

import java.util.List;

public class Ingredient extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3467041004296560644L;
	
	private String name;
	private String description;
	private String about;
	private Tag mainTag;
	private List<Tag> tags;
	
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
	public Tag getMainTag() {
		return mainTag;
	}
	public void setMainTag(Tag mainTag) {
		this.mainTag = mainTag;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
