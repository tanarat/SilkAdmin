package org.silk.checklist.dao; 

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.silk.checklist.model.NoReason;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class NoReasonDaoImpl implements NoReasonDao {
	@SessionTarget
	Session session;
 
	@TransactionTarget
	Transaction transaction;
	@Override
	public void save(NoReason reason) {
		// TODO Auto-generated method stub
		session.saveOrUpdate(reason);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NoReason> list() {
		// TODO Auto-generated method stub
		System.out.println("list all NoReasons");
		return session.createQuery("from NoReason").list();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public NoReason getById(Long id) {
		// TODO Auto-generated method stub
		NoReason reason = new NoReason();
		reason = (NoReason)session.get(NoReason.class, id);
		return reason;
	}

	@Override
	public List<NoReason> getByQuestionId(Long questionId) {
		// TODO Auto-generated method stub
		String hql = "from NoReason r where r.question = :questionId";
		return session.createQuery(hql).setParameter("questionId", questionId).list();
		
	}

	

}
