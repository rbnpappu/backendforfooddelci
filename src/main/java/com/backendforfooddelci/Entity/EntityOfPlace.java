package com.backendforfooddelci.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EntityOfPlace")
public class EntityOfPlace {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id")
	  private Long id;
	
	private String cityName;
	private double lng;
	private double lat;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public EntityOfPlace(String cityName, double lng, double lat) {
		super();
		this.cityName = cityName;
		this.lng = lng;
		this.lat = lat;
	}
	
	public EntityOfPlace() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
