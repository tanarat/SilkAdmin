package org.silk.checklist.dao; 

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.silk.checklist.model.Checklist;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class ChecklistDaoImpl implements ChecklistDao {
	@SessionTarget
	Session session;
 
	@TransactionTarget
	Transaction transaction;
	@Override
	public void save(Checklist checklist) {
		// TODO Auto-generated method stub
		session.saveOrUpdate(checklist);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Checklist> list() {
		// TODO Auto-generated method stub
		System.out.println("list all Checklists");
		return session.createQuery("from Checklist").list();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Checklist getById(Long id) {
		// TODO Auto-generated method stub
		Checklist checklist = new Checklist();
		checklist = (Checklist)session.get(Checklist.class, id);
		return checklist;
	}


	

}
