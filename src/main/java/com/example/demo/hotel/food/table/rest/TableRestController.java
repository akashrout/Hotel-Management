package com.example.demo.hotel.food.table.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hotel.food.category.pojo.Status;
import com.example.demo.hotel.food.table.bean.TableBean;
import com.example.demo.hotel.food.table.service.TableSevice;
import com.example.demo.hotel.food.table.validation.TableValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class TableRestController.
 */
@RestController
@RequestMapping("/table")
public class TableRestController {

	/** The table service. */
	@Autowired
	private TableSevice tableService;

	/** The table validator. */
	@Autowired
	private TableValidator tableValidator;

	/**
	 * List all tables.
	 *
	 * @return the response entity
	 */
	@GetMapping("alltables")
	public ResponseEntity<List<TableBean>> listAllTables() {
		List<TableBean> tableBeans = tableService.getAllTables();
		if (tableBeans.isEmpty()) {
			return new ResponseEntity<List<TableBean>>(tableBeans, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<TableBean>>(tableBeans, HttpStatus.OK);
	}

	/**
	 * Adds the table.
	 *
	 * @param tableBean the table bean
	 * @return the response entity
	 */
	@PostMapping("create")
	public ResponseEntity<TableBean> addTable(@RequestBody TableBean tableBean) {

		if (tableValidator.isAllFieldPresent(tableBean)) {
			if (tableValidator.isTableNameAvailable(tableBean.getTableName())) {

				return new ResponseEntity(new Status("Thia table is already available..."), HttpStatus.NOT_ACCEPTABLE);
			} else {
				TableBean bean = tableService.createTable(tableBean);
				return new ResponseEntity<TableBean>(bean, HttpStatus.CREATED);

			}

		} else {
			return new ResponseEntity(new Status("Some Item Details are missing..."), HttpStatus.CONFLICT);

		}

	}

	/**
	 * Update table.
	 *
	 * @param tableBean the table bean
	 * @return the response entity
	 */
	@PutMapping("update")
	public ResponseEntity<TableBean> updateTable(@RequestBody TableBean tableBean) {

		if (tableValidator.isAllFieldPresentForUpdate(tableBean)) {
			if (tableValidator.isTableAvailable(tableBean.getTableId())) {
				TableBean bean = tableService.updateTable(tableBean);
				System.out.println("Updated Values: " + bean);
				return new ResponseEntity(bean, HttpStatus.ACCEPTED);

			} else {
				return new ResponseEntity(new Status("Unable to update!!, This table is not available..."),
						HttpStatus.NOT_ACCEPTABLE);
			}

		} else {
			return new ResponseEntity(new Status("Unable to update!!, Some Item Details are missing..."),
					HttpStatus.CONFLICT);
		}

	}

	/**
	 * Delete table.
	 *
	 * @param tableBean the table bean
	 * @return the response entity
	 */
	@DeleteMapping("delete")
	public ResponseEntity<TableBean> deleteTable(@RequestBody TableBean tableBean) {

		if (tableValidator.isTableAvailable(tableBean.getTableId())) {
			tableService.deletetable(tableBean.getTableId());
			return new ResponseEntity(new Status("Table Deleted Succesfully..."), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity(new Status("Unable to delete!!, This table is not available..."),
					HttpStatus.CONFLICT);

		}

	}

}
