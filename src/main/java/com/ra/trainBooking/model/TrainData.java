package com.ra.trainBooking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "Reservation")
public class TrainData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
    private String filterDate;
	
	private String toDestination;
	
	private String fromDestination;
	
	private Double price; 
	
	private String TrainName;
	
	private String time;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getFilterDate() {
		return filterDate;
	}

	public void setFilterDate(String filterDate) {
		this.filterDate = filterDate;
	}

	public String getToDestination() {
		return toDestination;
	}

	public void setToDestination(String toDestination) {
		this.toDestination = toDestination;
	}

	public String getFromDestination() {
		return fromDestination;
	}

	public void setFromDestination(String fromDestination) {
		this.fromDestination = fromDestination;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTrainName() {
		return TrainName;
	}

	public void setTrainName(String trainName) {
		TrainName = trainName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
}
