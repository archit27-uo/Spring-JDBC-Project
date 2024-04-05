package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int insert(Student student) {
		String query = "insert into student(id, name, city) values(?,?,?)";
		int r = this.template.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

}
