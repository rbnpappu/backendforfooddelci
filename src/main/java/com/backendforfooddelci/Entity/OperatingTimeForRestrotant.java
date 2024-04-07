package com.backendforfooddelci.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class OperatingTimeForRestrotant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Assuming you want to store the day of the week as well
    @OneToOne(mappedBy="operatingTime", cascade = CascadeType.ALL)
    private DayOfWeek dayOfWeek;

    private Timestamp openingTime;
    private Timestamp closingTime;

    @ManyToOne
    @JoinColumn(name = "rest_id")
    private RegisterRestrutant registerResturant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Timestamp getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(Timestamp openingTime) {
		this.openingTime = openingTime;
	}

	public Timestamp getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(Timestamp closingTime) {
		this.closingTime = closingTime;
	}

	public RegisterRestrutant getRegisterResturant() {
		return registerResturant;
	}

	public void setRegisterResturant(RegisterRestrutant registerResturant) {
		this.registerResturant = registerResturant;
	}

	public OperatingTimeForRestrotant(Long id, DayOfWeek dayOfWeek, Timestamp openingTime, Timestamp closingTime,
			RegisterRestrutant registerResturant) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.registerResturant = registerResturant;
	}

	public OperatingTimeForRestrotant() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
    // Constructors, getters, and setters...
}
