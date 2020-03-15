package com.example.demo.hotel.food.table.responsetranformer;

import com.example.demo.hotel.food.table.bean.TableBean;
import com.example.demo.hotel.food.table.entity.TableEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class TableResponseTransformer.
 */
public class TableResponseTransformer {

	/**
	 * Gets the table bean.
	 *
	 * @param tableEntity the table entity
	 * @return the table bean
	 */
	public static TableBean getTableBean(TableEntity tableEntity) {
		
		return new TableBean(tableEntity.getTableId(), tableEntity.getTableName(), tableEntity.getTableDescription(), tableEntity.getIsTableLock());
	}

}
