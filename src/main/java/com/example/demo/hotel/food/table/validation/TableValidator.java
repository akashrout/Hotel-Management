package com.example.demo.hotel.food.table.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.table.bean.TableBean;
import com.example.demo.hotel.food.table.service.TableSevice;

// TODO: Auto-generated Javadoc
/**
 * The Class TableValidator.
 */
@Service
public class TableValidator {

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

		if ((tableBean.getTableName() == null) || (tableBean.getTableDescription()) == null) {
			return false;

		} else {
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
		if (tableSevice.isTablePresent(tableName)) {
			return true;
		} else {
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
		if ((tableBean.getTableId() == null) || (tableBean.getTableName() == null)
				|| (tableBean.getTableDescription()) == null) {
			return false;
		} else {
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
		if (tableSevice.isTablePresent(tableId)) {
			return true;
			
		} else {
			return false;
		}
		
	}

}
