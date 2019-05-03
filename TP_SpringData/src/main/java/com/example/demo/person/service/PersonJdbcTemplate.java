package com.example.demo.person.service;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcTemplate {

	
	@Autowired
    private DataSource dataSourceToto;
	private JdbcTemplate jdbcTemplate;
	
	
	 public void addAPerson(String name, String lastName, Integer age){
         
         JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceToto);
         jdbcTemplate.update("INSERT INTO person(firstName,lastName,age)VALUES(?,?,?)",name,lastName,age );
         
 }
	
	public void setDataSourceToto(DataSource dataSource) {
        this.dataSourceToto = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
}
}
