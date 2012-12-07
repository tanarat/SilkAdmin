package org.silk.halal.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.silk.SessionFactoryHelper;
import org.silk.common.dao.HalalProductDao;
import org.silk.common.model.HalalProduct;

public class ProductDaoImpl implements HalalProductDao {
	private SessionFactory sessionFactory;
	private Session session;
	
	public ProductDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		sessionFactory = SessionFactoryHelper.getSessionFactory();
		session = sessionFactory.openSession();
	}

	@Override
	public void save(HalalProduct halalBarcode) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<HalalProduct> list() {
		// TODO Auto-generated method stub
		
		List<HalalProduct> list = session.createQuery("from HalalBarcode").list();
		
		return list;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public HalalProduct listById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HalalProduct listByHalalNo(String halalNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HalalProduct listByUpc(String upc) {
		// TODO Auto-generated method stub
		return null;
	}

}
