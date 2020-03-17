package com.example.demo.hotel.food.table.responsetranformer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.hotel.food.item.responsetransformer.ItemResponseTransformer;
import com.example.demo.hotel.food.table.bean.TableBean;
import com.example.demo.hotel.food.table.entity.TableEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class TableResponseTransformer.
 */
public class TableResponseTransformer {
	private static final Logger log = LoggerFactory.getLogger(TableResponseTransformer.class);

	/**
	 * Gets the table bean.
	 *
	 * @param tableEntity the table entity
	 * @return the table bean
	 */
	public static TableBean getTableBean(TableEntity tableEntity) {
		log.info(" Converting tableEntity to tableBean...");
		log.debug("Converting tableEntity to tableBean...");
		log.info("Returning tableBean to Service...");
		log.debug("Returning tableBean to Service...");

		return new TableBean(tableEntity.getTableId(), tableEntity.getTableName(), tableEntity.getTableDescription(),
				tableEntity.getIsTableLock());
	}

}
