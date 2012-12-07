package org.silk.checklist.dao; 

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.silk.checklist.model.EvalForm;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class EvalFormDaoImpl implements EvalFormDao {
	@SessionTarget
	Session session;
 
	@TransactionTarget
	Transaction transaction;
	@Override
	public void save(EvalForm form) {
		// TODO Auto-generated method stub
		session.saveOrUpdate(form);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EvalForm> list() {
		// TODO Auto-generated method stub
		System.out.println("list all EvalForms");
		return session.createQuery("from EvalForm").list();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public EvalForm getById(Long id) {
		// TODO Auto-generated method stub
		EvalForm form = new EvalForm();
		form = (EvalForm)session.get(EvalForm.class, id);
		return form;
	}


	

}
