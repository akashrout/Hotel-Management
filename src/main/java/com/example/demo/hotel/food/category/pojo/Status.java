package com.example.demo.hotel.food.category.pojo;

// TODO: Auto-generated Javadoc
/**
 * The Class Status.
 */
public class Status {

	/** The status. */
	private String status;

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Instantiates a new status.
	 *
	 * @param status the status
	 */
	public Status(String status) {
		super();
		this.status = status;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Status [status=" + status + "]";
	}

}
