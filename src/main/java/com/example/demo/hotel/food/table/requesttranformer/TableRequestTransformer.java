package com.example.demo.hotel.food.table.requesttranformer;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.hotel.food.table.bean.TableBean;
import com.example.demo.hotel.food.table.entity.TableEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class TableRequestTransformer.
 */
public class TableRequestTransformer {

	/**
	 * Gets the table bean list.
	 *
	 * @param tableEntities the table entities
	 * @return the table bean list
	 */
	public static List<TableBean> getTableBeanList(List<TableEntity> tableEntities) {
		List<TableBean> tableBeans = new ArrayList<TableBean>();
		for (TableEntity tableEntity : tableEntities) {
			tableBeans.add(new TableBean(tableEntity.getTableId(), tableEntity.getTableName(), tableEntity.getTableDescription(), tableEntity.getIsTableLock()));
			
			
		}
		return tableBeans;
	}

	/**
	 * Gets the tabel entity.
	 *
	 * @param tableBean the table bean
	 * @return the tabel entity
	 */
	public static TableEntity getTabelEntity(TableBean tableBean) {
		TableEntity tableEntity = new TableEntity(tableBean.getTableName(), tableBean.getTableDescription(), 0);
		// TODO Auto-generated method stub
		return tableEntity;
	}

}
