package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate template;
	RowMapper<Student> rowMapper = new RowMapperImpl();
	
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

	@Override
	public int change(Student student) {
		String query = "update student set name=?, city=? where id=?";
		int r = this.template.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

	@Override
	public int delete(Student student) {
		String query = "DELETE FROM student WHERE id=?";
		int r = this.template.update(query, student.getId());
		return 0;
	}

	@Override
	public Student getStudent(int studentId) {
		String query = "select * from student where id=?";
		
		Student s = this.template.queryForObject(query, rowMapper, studentId);
		return s;
	}

	@Override
	public List<Student> getAllStudent() {
		String query = "select * from student";
		List<Student> student = this.template.query(query, new RowMapperImpl());
		
		return student;
	}
}
