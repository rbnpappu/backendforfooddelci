package com.backendforfooddelci.Entity;


import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restrutant")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor 
@AllArgsConstructor
public class RegisterRestrutant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rest_id")
    private Long restId;
    
    @Column(name = "rest_name")
    private String restName;
    
    @Column(name = "rest_desc")
    private String restDesc;
    
    @Column(name = "rest_address")
    private String restAddress;
    
    @Column(name = "contact_info")
    private String contInfo;
    
    @OneToMany(mappedBy = "registerResturant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OperatingTimeForRestrotant> openingHour;
    
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Menuforrestotant> menus;
    
    @Column(name="restroImage")
    private String restoImages;

	public Long getRestId() {
		return restId;
	}

	public void setRestId(Long restId) {
		this.restId = restId;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getRestDesc() {
		return restDesc;
	}

	public void setRestDesc(String restDesc) {
		this.restDesc = restDesc;
	}

	public String getRestAddress() {
		return restAddress;
	}

	public void setRestAddress(String restAddress) {
		this.restAddress = restAddress;
	}

	public String getContInfo() {
		return contInfo;
	}

	public void setContInfo(String contInfo) {
		this.contInfo = contInfo;
	}

	public Set<OperatingTimeForRestrotant> getOpeningHour() {
		return openingHour;
	}

	public void setOpeningHour(Set<OperatingTimeForRestrotant> openingHour) {
		this.openingHour = openingHour;
	}

	public List<Menuforrestotant> getMenus() {
		return menus;
	}

	public void setMenus(List<Menuforrestotant> menus) {
		this.menus = menus;
	}

	public String getRestoImages() {
		return restoImages;
	}

	public void setRestoImages(String restoImages) {
		this.restoImages = restoImages;
	}

	public RegisterRestrutant(Long restId, String restName, String restDesc, String restAddress, String contInfo,
			Set<OperatingTimeForRestrotant> openingHour, List<Menuforrestotant> menus, String restoImages) {
		super();
		this.restId = restId;
		this.restName = restName;
		this.restDesc = restDesc;
		this.restAddress = restAddress;
		this.contInfo = contInfo;
		this.openingHour = openingHour;
		this.menus = menus;
		this.restoImages = restoImages;
	}

	   public RegisterRestrutant() {
	        // Default constructor
	    }
    

}