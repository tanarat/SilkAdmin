package org.silk.checklist.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.silk.checklist.model.QuestionGroup;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class QuestionGroupDaoImpl implements QuestionGroupDao {
	@SessionTarget
	Session session;
 
	@TransactionTarget
	Transaction transaction;
	@Override
	public void save(QuestionGroup qGroup) {
		// TODO Auto-generated method stub
		session.saveOrUpdate(qGroup);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionGroup> list() {
		// TODO Auto-generated method stub
		if(session == null){
			System.out.println("has no session.......");
		}
		return session.createQuery("from QuestionGroup").list();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public QuestionGroup listById(Long id) {
		// TODO Auto-generated method stub
		QuestionGroup qGroup = new QuestionGroup();
		qGroup = (QuestionGroup)session.get(QuestionGroup.class, id);
		return qGroup;
	}


}
