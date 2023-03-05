package com.raster;

public class BookQuery {

	private String category;
	private boolean sortByRating;
	
	public BookQuery() {
		this.category = "";
		this.sortByRating = false;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isSort() {
		return sortByRating;
	}

	public void setSort(boolean sort) {
		this.sortByRating = sort;
	}
}
