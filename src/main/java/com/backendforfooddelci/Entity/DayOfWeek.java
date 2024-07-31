package com.backendforfooddelci.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Day_ofWeek")
public class DayOfWeek {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "start_day_of_week")
    private String startDayOfWeek;
    
    @Column(name = "end_day_of_week")
    private String endDayOfWeek;
    
    @OneToOne
    @JoinColumn(name = "operatingTime_id")
    private OperatingTimeForRestaurant operatingTime;
    
    public DayOfWeek() {
        super();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartDayOfWeek() {
		return startDayOfWeek;
	}

	public void setStartDayOfWeek(String startDayOfWeek) {
		this.startDayOfWeek = startDayOfWeek;
	}

	public String getEndDayOfWeek() {
		return endDayOfWeek;
	}

	public void setEndDayOfWeek(String endDayOfWeek) {
		this.endDayOfWeek = endDayOfWeek;
	}

	public DayOfWeek(Long id, String startDayOfWeek, String endDayOfWeek) {
		super();
		this.id = id;
		this.startDayOfWeek = startDayOfWeek;
		this.endDayOfWeek = endDayOfWeek;
	}
    
   
}
