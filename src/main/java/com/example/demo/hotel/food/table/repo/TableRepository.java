package com.example.demo.hotel.food.table.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.hotel.food.table.entity.TableEntity;

public interface TableRepository extends JpaRepository<TableEntity, Long> {

	/**
	 * Exists by table name.
	 *
	 * @param tableName the table name
	 * @return true, if successful
	 */
	public boolean existsByTableName(String tableName);

}
