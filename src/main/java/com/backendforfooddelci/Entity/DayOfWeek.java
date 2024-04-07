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
@Table(name="DayOfWeek")
public class DayOfWeek {
	
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   
	   @Column(name="id")
	   private Long id;
	   
	  @Column(name="start") 
	  private String start;
	  
	  @Column(name="end")
	  private String end;
	  
	  @OneToOne
	  @JoinColumn(name = "operatingTime_id")
	  private OperatingTimeForRestrotant operatingTime;

	public DayOfWeek() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public OperatingTimeForRestrotant getOperatingTime() {
		return operatingTime;
	}

	public void setOperatingTime(OperatingTimeForRestrotant operatingTime) {
		this.operatingTime = operatingTime;
	}

	public DayOfWeek(Long id, String start, String end, OperatingTimeForRestrotant operatingTime) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.operatingTime = operatingTime;
	}

	

}
