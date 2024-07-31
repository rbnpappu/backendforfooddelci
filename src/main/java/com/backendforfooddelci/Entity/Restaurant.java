package com.backendforfooddelci.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "restName")
    private String restName;

    @Column(name = "restAddress")
    private String restAddress;

    @Column(name = "contactInfo")
    private String contactInfo;
    
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookSeats> bookSeats;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OperatingTimeForRestaurant> openingHour;

    @Column(name = "cuisine")
    private String cuisine;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FoodMenu> menus;

    @Column(name="restoImage")
    private String restoImages;
    
    @Column(name="review")
    private double review;

    @Column(name="latitude")
    private double latitude; // Latitude

    @Column(name="longitude")
    private double longitude; // Longitude

    @Column(name="hygieneRating")
    private double hygieneRating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getRestAddress() {
		return restAddress;
	}

	public void setRestAddress(String restAddress) {
		this.restAddress = restAddress;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public List<BookSeats> getBookSeats() {
		return bookSeats;
	}

	public void setBookSeats(List<BookSeats> bookSeats) {
		this.bookSeats = bookSeats;
	}

	public List<OperatingTimeForRestaurant> getOpeningHour() {
		return openingHour;
	}

	public void setOpeningHour(List<OperatingTimeForRestaurant> openingHour) {
		this.openingHour = openingHour;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public List<FoodMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<FoodMenu> menus) {
		this.menus = menus;
	}

	public String getRestoImages() {
		return restoImages;
	}

	public void setRestoImages(String restoImages) {
		this.restoImages = restoImages;
	}

	public double getReview() {
		return review;
	}

	public void setReview(double review) {
		this.review = review;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getHygieneRating() {
		return hygieneRating;
	}

	public void setHygieneRating(double hygieneRating) {
		this.hygieneRating = hygieneRating;
	}

	public Restaurant(Long id, String restName, String restAddress, String contactInfo, List<BookSeats> bookSeats,
			List<OperatingTimeForRestaurant> openingHour, String cuisine, List<FoodMenu> menus,
			String restoImages, double review, double latitude, double longitude, double hygieneRating) {
		super();
		this.id = id;
		this.restName = restName;
		this.restAddress = restAddress;
		this.contactInfo = contactInfo;
		this.bookSeats = bookSeats;
		this.openingHour = openingHour;
		this.cuisine = cuisine;
		this.menus = menus;
		this.restoImages = restoImages;
		this.review = review;
		this.latitude = latitude;
		this.longitude = longitude;
		this.hygieneRating = hygieneRating;
	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters and Setters
    // Constructors
}
