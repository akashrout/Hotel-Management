package com.example.demo.hotel.food.table.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class TableBean.
 */
public class TableBean {

	/** The table id. */
	private Long tableId;

	/** The table name. */
	private String tableName;

	/** The table description. */
	private String tableDescription;

	/** The is table lock. */
	private int isTableLock;

	/**
	 * Instantiates a new table bean.
	 */
	public TableBean() {

	}

	/**
	 * Instantiates a new table bean.
	 *
	 * @param tableName        the table name
	 * @param tableDescription the table description
	 * @param isTableLock      the is table lock
	 */
	public TableBean(String tableName, String tableDescription, int isTableLock) {

		this.tableName = tableName;
		this.tableDescription = tableDescription;
		this.isTableLock = isTableLock;
	}

	/**
	 * Instantiates a new table bean.
	 *
	 * @param tableId          the table id
	 * @param tableName        the table name
	 * @param tableDescription the table description
	 * @param isTableLock      the is table lock
	 */
	public TableBean(Long tableId, String tableName, String tableDescription, int isTableLock) {
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableDescription = tableDescription;
		this.isTableLock = isTableLock;
	}

	/**
	 * Gets the table id.
	 *
	 * @return the table id
	 */
	public Long getTableId() {
		return tableId;
	}

	/**
	 * Sets the table id.
	 *
	 * @param tableId the new table id
	 */
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	/**
	 * Gets the table name.
	 *
	 * @return the table name
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * Sets the table name.
	 *
	 * @param tableName the new table name
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * Gets the table description.
	 *
	 * @return the table description
	 */
	public String getTableDescription() {
		return tableDescription;
	}

	/**
	 * Sets the table description.
	 *
	 * @param tableDescription the new table description
	 */
	public void setTableDescription(String tableDescription) {
		this.tableDescription = tableDescription;
	}

	/**
	 * Gets the checks if is table lock.
	 *
	 * @return the checks if is table lock
	 */
	public int getIsTableLock() {
		return isTableLock;
	}

	/**
	 * Sets the checks if is table lock.
	 *
	 * @param isTableLock the new checks if is table lock
	 */
	public void setIsTableLock(int isTableLock) {
		this.isTableLock = isTableLock;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "TableBean [tableId=" + tableId + ", tableName=" + tableName + ", tableDescription=" + tableDescription
				+ ", isTableLock=" + isTableLock + "]";
	}

}
