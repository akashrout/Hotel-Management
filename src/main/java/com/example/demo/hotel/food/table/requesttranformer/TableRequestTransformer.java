package com.example.demo.hotel.food.table.requesttranformer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.hotel.food.item.requesttransformer.ItemrequestTransformer;
import com.example.demo.hotel.food.table.bean.TableBean;
import com.example.demo.hotel.food.table.entity.TableEntity;

/**
 * The Class TableRequestTransformer.
 */
public class TableRequestTransformer {
	private static final Logger log = LoggerFactory.getLogger(TableRequestTransformer.class);

	/**
	 * Gets the table bean list.
	 *
	 * @param tableEntities the table entities
	 * @return the table bean list
	 */
	public static List<TableBean> getTableBeanList(List<TableEntity> tableEntities) {
		log.info(" Converting listOfTableEntity to tableBeam...");
		log.debug("Converting listOfTableEntity to tableBeam...");
		List<TableBean> tableBeans = new ArrayList<TableBean>();
		log.info(" Adding listOfTableEntity to itemBeam...");
		log.debug("Adding listOfTableEntity to itemBeam...");
		for (TableEntity tableEntity : tableEntities) {
			tableBeans.add(new TableBean(tableEntity.getTableId(), tableEntity.getTableName(),
					tableEntity.getTableDescription(), tableEntity.getIsTableLock()));
		}
		log.info("Returning tableBean to Service...");
		log.debug("Returning tableBean to Service...");
		return tableBeans;
	}

	/**
	 * Gets the tabel entity.
	 *
	 * @param tableBean the table bean
	 * @return the tabel entity
	 */
	public static TableEntity getTabelEntity(TableBean tableBean) {
		log.info(" Converting tableBean to tableEntity...");
		log.debug("Converting tableBean to tableEntity...");
		TableEntity tableEntity = new TableEntity(tableBean.getTableName(), tableBean.getTableDescription(), 0);
		log.info("Returning tableEntity to Service...");
		log.debug("Returning tableEntity to Service...");
		return tableEntity;
	}

}
