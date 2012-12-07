package test;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class StudentDaoImpl  {
	@SessionTarget
	Session session;
 
	@TransactionTarget
	Transaction transaction;
	public void save(Student student) {
		// TODO Auto-generated method stub
		session.saveOrUpdate(student);
	}

	@SuppressWarnings("unchecked")
	public List<Student> list() {
		// TODO Auto-generated method stub
		return session.createQuery("from Student").list();
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	public Student listById(Long id) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student = (Student)session.get(Student.class, id);
		return student;
	}


}
