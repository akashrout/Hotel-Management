package com.example.demo.hotel.food.category.pojo;

public class Status {
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public Status(String status) {
		super();
		this.status = status;
	}

	@Override
	public String toString() {
		return "Status [status=" + status + "]";
	}

}
