package com.backendforfooddelci.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="nutritionalInformation")
@Getter
@Setter
public class NutritionalInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nutriInfo_id")
    private long id;
    
    @Column(name="calories")
    private String calories;
    
    @Column(name="fat")
    private String fat;
    
    @Column(name="protein")
    private String protein;
    
    @Column(name="carbohydrates")
    private String carbohydrates;
    
    @Column(name="cholesterol")
    private String cholesterol;
    
    @OneToOne
    @JoinColumn(name = "food_id")
    private FoodMenu food;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	public String getFat() {
		return fat;
	}

	public void setFat(String fat) {
		this.fat = fat;
	}

	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	public String getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(String carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public String getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(String cholesterol) {
		this.cholesterol = cholesterol;
	}

	public NutritionalInformation(long id, String calories, String fat, String protein, String carbohydrates,
			String cholesterol) {
		super();
		this.id = id;
		this.calories = calories;
		this.fat = fat;
		this.protein = protein;
		this.carbohydrates = carbohydrates;
		this.cholesterol = cholesterol;
	}

	public NutritionalInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
