package com.example.demo.hotel.food.table.service;

import java.util.List;

import com.example.demo.hotel.food.table.bean.TableBean;

// TODO: Auto-generated Javadoc
/**
 * The Interface TableSevice.
 */
public interface TableSevice {
	
	/**
	 * Gets the all tables.
	 *
	 * @return the all tables
	 */
	public List<TableBean> getAllTables();
	
	/**
	 * Creates the table.
	 *
	 * @param tableBean the table bean
	 * @return the table bean
	 */
	public TableBean createTable(TableBean tableBean);
	
	/**
	 * Checks if is table present.
	 *
	 * @param tableName the table name
	 * @return true, if is table present
	 */
	public boolean isTablePresent(String tableName);
	
	/**
	 * Checks if is table present.
	 *
	 * @param tableId the table id
	 * @return true, if is table present
	 */
	public boolean isTablePresent(Long tableId);
	
	/**
	 * Update table.
	 *
	 * @param tableBean the table bean
	 * @return the table bean
	 */
	public TableBean updateTable(TableBean tableBean);
	
	/**
	 * Deletetable.
	 *
	 * @param tableId the table id
	 */
	public void deletetable(Long tableId);

}
