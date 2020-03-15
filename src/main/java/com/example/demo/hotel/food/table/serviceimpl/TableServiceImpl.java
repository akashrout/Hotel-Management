package com.example.demo.hotel.food.table.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.table.bean.TableBean;
import com.example.demo.hotel.food.table.entity.TableEntity;
import com.example.demo.hotel.food.table.repo.TableRepository;
import com.example.demo.hotel.food.table.requesttranformer.TableRequestTransformer;
import com.example.demo.hotel.food.table.responsetranformer.TableResponseTransformer;
import com.example.demo.hotel.food.table.service.TableSevice;

// TODO: Auto-generated Javadoc
/**
 * The Class TableServiceImpl.
 */
@Service
public class TableServiceImpl implements TableSevice {
	
	/** The table repository. */
	@Autowired
	private TableRepository tableRepository;

	/**
	 * Gets the all tables.
	 *
	 * @return the all tables
	 */
	@Override
	public List<TableBean> getAllTables() {
		List<TableEntity> tableEntities = tableRepository.findAll();
		System.out.println("Inside :  " + tableEntities);
		List<TableBean> tableBeans = TableRequestTransformer.getTableBeanList(tableEntities);
		return tableBeans;
	}

	/**
	 * Creates the table.
	 *
	 * @param tableBean the table bean
	 * @return the table bean
	 */
	@Override
	public TableBean createTable(TableBean tableBean) {

		TableEntity tableEntity = TableRequestTransformer.getTabelEntity(tableBean);
		tableRepository.save(tableEntity);
		TableBean bean = TableResponseTransformer.getTableBean(tableEntity);

		return bean;
	}

	/**
	 * Checks if is table present.
	 *
	 * @param tableName the table name
	 * @return true, if is table present
	 */
	@Override
	public boolean isTablePresent(String tableName) {
		if (tableRepository.existsByTableName(tableName)) {
			System.out.println("Table already available...");
			return true;
		} else {
			System.out.println("Table Not Present...");
			return false;
		}

	}

	/**
	 * Checks if is table present.
	 *
	 * @param tableId the table id
	 * @return true, if is table present
	 */
	@Override
	public boolean isTablePresent(Long tableId) {
		return tableRepository.findById(tableId).isPresent();

	}

	/**
	 * Update table.
	 *
	 * @param tableBean the table bean
	 * @return the table bean
	 */
	@Override
	public TableBean updateTable(TableBean tableBean) {
		TableEntity tableEntity = tableRepository.findById(tableBean.getTableId()).get();
		if (tableEntity!=null) {
			tableEntity.setTableName(tableBean.getTableName());
			tableEntity.setTableDescription(tableBean.getTableDescription());
			tableEntity.setIsTableLock(0);
			
		}
		tableRepository.save(tableEntity);
		TableBean bean = TableResponseTransformer.getTableBean(tableEntity);
		return bean;
	}

	/**
	 * Deletetable.
	 *
	 * @param tableId the table id
	 */
	@Override
	public void deletetable(Long tableId) {
		tableRepository.deleteById(tableId);
		
	}

}
