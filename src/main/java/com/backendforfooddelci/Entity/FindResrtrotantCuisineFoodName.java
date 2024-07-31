package com.backendforfooddelci.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FindResrtrotantCuisineFoodName {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
		public Long id;
	 
	 private String name;
	 
		 private String type;
		 private String image;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public FindResrtrotantCuisineFoodName(Long id, String name, String type, String image) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.image = image;
		}
		public FindResrtrotantCuisineFoodName() {
			super();
			// TODO Auto-generated constructor stub
		}
		 
		 
}
