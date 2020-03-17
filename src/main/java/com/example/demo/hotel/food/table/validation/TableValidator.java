package com.example.demo.hotel.food.table.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.table.bean.TableBean;
import com.example.demo.hotel.food.table.service.TableSevice;
import com.example.demo.hotel.food.table.serviceimpl.TableServiceImpl;

/**
 * The Class TableValidator.
 */
@Service
public class TableValidator {
	private static final Logger log = LoggerFactory.getLogger(TableValidator.class);

	/** The table sevice. */
	@Autowired
	private TableSevice tableSevice;

	/**
	 * Checks if is all field present.
	 *
	 * @param tableBean the table bean
	 * @return true, if is all field present
	 */
	public boolean isAllFieldPresent(TableBean tableBean) {
		log.info("Checking all required fields are there or not...");
		log.debug("Checking all required fields are there or not...");

		if ((tableBean.getTableName() == null) || (tableBean.getTableDescription()) == null) {
			log.info("All required fields are not present...");
			log.debug("All required fields are not present...");
			return false;

		} else {
			log.info("All required fields are present...");
			log.debug("All required fields are present...");
			return true;

		}
	}

	/**
	 * Checks if is table name available.
	 *
	 * @param tableName the table name
	 * @return true, if is table name available
	 */
	public boolean isTableNameAvailable(String tableName) {
		log.info("Checking if table name is present...");
		log.debug("Checking if table name is present...");
		if (tableSevice.isTablePresent(tableName)) {
			log.info("Table name is present...");
			log.debug("Table name is present...");
			return true;
		} else {
			log.info("Table name is not present...");
			log.debug("Table name is not present...");
			return false;
		}

	}

	/**
	 * Checks if is all field present for update.
	 *
	 * @param tableBean the table bean
	 * @return true, if is all field present for update
	 */
	public boolean isAllFieldPresentForUpdate(TableBean tableBean) {
		log.info("Checking all required fields are there or not...");
		log.debug("Checking all required fields are there or not...");
		if ((tableBean.getTableId() == null) || (tableBean.getTableName() == null)
				|| (tableBean.getTableDescription()) == null) {
			log.info("All required fields are not present...");
			log.debug("All required fields are not present...");
			return false;
		} else {
			log.info("All required fields are  present...");
			log.debug("All required fields are present...");
			return true;
		}

	}

	/**
	 * Checks if is table available.
	 *
	 * @param tableId the table id
	 * @return true, if is table available
	 */
	public boolean isTableAvailable(Long tableId) {
		log.info("Checking if table id is present...");
		log.debug("Checking if table id is present...");
		if (tableSevice.isTablePresent(tableId)) {
			log.info("Table name is  present...");
			log.debug("Table name is  present...");
			return true;

		} else {
			log.info("Table name is not present...");
			log.debug("Table name is not present...");
			return false;
		}

	}

}
