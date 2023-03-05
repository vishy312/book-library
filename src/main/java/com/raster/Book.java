package com.raster;

import com.raster.exceptions.BookNotFoundException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_gen")
	@SequenceGenerator(name="seq_gen", allocationSize=5)
	private Long id;
	private String image;
	private String name;
	private String author;
	private String format;
	private double bookDepositoryStars;
	private double price;
	private String currency;
	private double oldPrice;
	private Long isbn;
	private String category;
	private String imgPaths;
	
	public Book(Long id, String image, String name, String author, String format, double bookDepositoryStars,
			double price, String currency, double oldPrice, Long isbn, String category, String imgPaths) {
		this.id = id;
		this.image = image;
		this.name = name;
		this.author = author;
		this.format = format;
		this.bookDepositoryStars = bookDepositoryStars;
		this.price = price;
		this.currency = currency;
		this.oldPrice = oldPrice;
		this.isbn = isbn;
		this.category = category;
		this.imgPaths = imgPaths;
	}

	public Book() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public double getBookDepositoryStars() {
		return bookDepositoryStars;
	}

	public void setBookDepositoryStars(double bookDepositoryStars) {
		this.bookDepositoryStars = bookDepositoryStars;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImgPaths() {
		return imgPaths;
	}

	public void setImgPaths(String imgPaths) {
		this.imgPaths = imgPaths;
	}
	
	public void validate(){
		if(this.image.isEmpty() || this.image == null){
			throw new BookNotFoundException("image link is either null or empty");
		}
		if(this.name.isEmpty() || this.name == null){
			throw new BookNotFoundException("name is either null or empty");
		}
		if(this.author.isEmpty() || this.author == null){
			throw new BookNotFoundException("author is either null or empty");
		}
		if(this.format.isEmpty() || this.format == null){
			throw new BookNotFoundException("format link is either null or empty");
		}

		if(this.currency.isEmpty() || this.currency == null){
			throw new BookNotFoundException("currency is either null or empty");
		}
		if(this.isbn == null){
			throw new BookNotFoundException("isbn is either null");
		}
		if(this.category.isEmpty() || this.category == null){
			throw new BookNotFoundException("category is either null or empty");
		}
		if(this.imgPaths.isEmpty() || this.imgPaths == null){
			throw new BookNotFoundException("imgPaths is either null or empty");
		}
	}
}
