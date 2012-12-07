package org.silk.common.service;

import java.util.List;

import org.silk.common.dao.EntrepreneurDao;
import org.silk.common.dao.EntrepreneurDaoImpl;
import org.silk.common.model.Entrepreneur;

public class EntrepreneurService {
	private EntrepreneurDao entrepreneurDao = new EntrepreneurDaoImpl();
	public List<Entrepreneur> getAllEntrepreneurs() {
		// TODO Auto-generated method stub
		return entrepreneurDao.list();
	}

	public void deleteEntrepreneur(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void saveEntrepreneur(Entrepreneur entrepreneur) {
		// TODO Auto-generated method stub
		entrepreneurDao.save(entrepreneur);
	}

	public Entrepreneur getEntrepreneur(long id) {
		// TODO Auto-generated method stub
		return entrepreneurDao.getById(id);
	}

	

}
