package com.example.demo.hotel.food.table.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.item.responsetransformer.ItemResponseTransformer;
import com.example.demo.hotel.food.table.bean.TableBean;
import com.example.demo.hotel.food.table.entity.TableEntity;
import com.example.demo.hotel.food.table.repo.TableRepository;
import com.example.demo.hotel.food.table.requesttranformer.TableRequestTransformer;
import com.example.demo.hotel.food.table.responsetranformer.TableResponseTransformer;
import com.example.demo.hotel.food.table.service.TableSevice;

/**
 * The Class TableServiceImpl.
 */
@Service
public class TableServiceImpl implements TableSevice {
	private static final Logger log = LoggerFactory.getLogger(TableServiceImpl.class);

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
		log.info("Inside getAll Tables...");
		log.debug("Inside getAll Tables...");
		List<TableEntity> tableEntities = tableRepository.findAll();
		log.info(" getting all tables...");
		log.debug(" getting all tables...");
		System.out.println("Inside :  " + tableEntities);
		List<TableBean> tableBeans = TableRequestTransformer.getTableBeanList(tableEntities);
		log.info("Returning tableBean to Controller...");
		log.debug("Returning tableBean to Controller...");
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
		log.info("Entering CreateTable...");
		log.debug("Entering CreateTable...");

		TableEntity tableEntity = TableRequestTransformer.getTabelEntity(tableBean);
		log.info("Inserting new table to the DB...");
		log.debug("Inserting new table to the DB...");
		tableRepository.save(tableEntity);
		TableBean bean = TableResponseTransformer.getTableBean(tableEntity);
		log.info("Returning newly created tableBean to Controller...");
		log.debug("Returning newly created tableBean to Controller...");

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
		log.info("Checking if table name is present...");
		log.debug("Checking if table name is present...");
		if (tableRepository.existsByTableName(tableName)) {
			log.info("Table name is present...");
			log.debug("Table name is present...");
			System.out.println("Table already available...");
			return true;
		} else {
			log.info("Table name is not present...");
			log.debug("Table name is not present...");
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
		log.info("Checking if table id is present...");
		log.debug("Checking if table id is present...");
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
		log.info("Entering CreateTable...");
		log.debug("Entering CreateTable...");
		TableEntity tableEntity = tableRepository.findById(tableBean.getTableId()).get();
		if (tableEntity != null) {
			log.info("Adding all details of the existing item for update...");
			log.debug("Adding all details of the existing item for update...");
			tableEntity.setTableName(tableBean.getTableName());
			tableEntity.setTableDescription(tableBean.getTableDescription());
			tableEntity.setIsTableLock(0);

		}
		log.info("Updating the table details to the DB...");
		log.debug("Updating the table details to the DB...");
		tableRepository.save(tableEntity);
		TableBean bean = TableResponseTransformer.getTableBean(tableEntity);
		log.info("Returning updated tableBean to Controller...");
		log.debug("Returning updated tableBean to Controller...");
		return bean;
	}

	/**
	 * Deletetable.
	 *
	 * @param tableId the table id
	 */
	@Override
	public void deletetable(Long tableId) {
		log.info("Deleting the table...");
		log.debug("Deleting the table...");
		tableRepository.deleteById(tableId);

	}

}
