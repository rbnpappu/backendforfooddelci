package com.backendforfooddelci.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="FoodMenu")
public class FoodMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;
    
    @Column(name="foodName")
    private String foodName;
    
    @Column(name="type")
    private String type;
    
    
    @Column(name="food_itemsOff")
    private String offInFoodItems;
   
    @OneToOne( cascade = CascadeType.ALL)
    private NutritionalInformation nutritionalValue;
    

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Restaurant restaurant;

    @Column(name="price")
    private String price;
    
    @Column(name="food_image")
    private String foodImage;
    
    @Column(name="food_review")
    private double foodReview;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOffInFoodItems() {
		return offInFoodItems;
	}

	public void setOffInFoodItems(String offInFoodItems) {
		this.offInFoodItems = offInFoodItems;
	}

	public NutritionalInformation getNutritionalValue() {
		return nutritionalValue;
	}

	public void setNutritionalValue(NutritionalInformation nutritionalValue) {
		this.nutritionalValue = nutritionalValue;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}

	public double getFoodReview() {
		return foodReview;
	}

	public void setFoodReview(double foodReview) {
		this.foodReview = foodReview;
	}

	public FoodMenu(Long id, String foodName, String type, String offInFoodItems,
			NutritionalInformation nutritionalValue, Restaurant restaurant, String price, String foodImage,
			double foodReview) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.type = type;
		this.offInFoodItems = offInFoodItems;
		this.nutritionalValue = nutritionalValue;
		this.restaurant = restaurant;
		this.price = price;
		this.foodImage = foodImage;
		this.foodReview = foodReview;
	}

	public FoodMenu() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

}
