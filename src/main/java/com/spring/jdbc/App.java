package com.spring.jdbc;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

/**
 * Hello world!
 *
 */
/**
 * 
 */
public class App 
{
    public static void main( String[] args ) throws BeansException{
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        StudentDao studentDao = context.getBean("studentDao", StudentDaoImpl.class);
        
//        Student student = new Student();
//        student.setId(3);
//        student.setName("Archit");
//        student.setCity("Khairagarh");
        
        List<Student> result = studentDao.getAllStudent();
         
        for(Student s: result) {
        	 System.out.println("Added "+s);  
        }
     
    }
}
