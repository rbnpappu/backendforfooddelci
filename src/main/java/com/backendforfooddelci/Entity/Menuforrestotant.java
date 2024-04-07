package com.backendforfooddelci.Entity;

import java.util.Set;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="menu")
public class Menuforrestotant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
	private long id;
	
	@Column(name="food_name")
	private String foodName;
	@Column(name="food_description")
	private String foodDesrciption;
	
	@Column(name="category")
	private String category;
	
	   @OneToOne(mappedBy = "food", cascade = CascadeType.ALL)
	   private NutritionalInformation nutritionalValue;
	
	   @ManyToOne
	   @JoinColumn(name = "rest_id")
	   private RegisterRestrutant  restaurant;
	   
	   @Column(name="food_image")
	   private String FoodImage;

	public Menuforrestotant(long id, String foodName, String foodDesrciption, String category,
			NutritionalInformation nutritionalValue, RegisterRestrutant restaurant, String foodImage) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.foodDesrciption = foodDesrciption;
		this.category = category;
		this.nutritionalValue = nutritionalValue;
		this.restaurant = restaurant;
		FoodImage = foodImage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodDesrciption() {
		return foodDesrciption;
	}

	public void setFoodDesrciption(String foodDesrciption) {
		this.foodDesrciption = foodDesrciption;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public NutritionalInformation getNutritionalValue() {
		return nutritionalValue;
	}

	public void setNutritionalValue(NutritionalInformation nutritionalValue) {
		this.nutritionalValue = nutritionalValue;
	}

	public RegisterRestrutant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RegisterRestrutant restaurant) {
		this.restaurant = restaurant;
	}

	public String getFoodImage() {
		return FoodImage;
	}

	public void setFoodImage(String foodImage) {
		FoodImage = foodImage;
	}

	public Menuforrestotant() {
		super();
		// TODO Auto-generated constructor stub
	}

	   

	


	

}
