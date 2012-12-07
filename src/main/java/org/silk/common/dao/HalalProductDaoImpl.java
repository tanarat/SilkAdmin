package org.silk.common.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.silk.common.model.HalalProduct;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;


public class HalalProductDaoImpl implements HalalProductDao{
	@SessionTarget
	Session session;
 
	@TransactionTarget
	Transaction transaction;


	@Override
	public void save(HalalProduct halalBarcode) {
		// TODO Auto-generated method stub
		session.saveOrUpdate(halalBarcode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HalalProduct> list() {
		// TODO Auto-generated method stub
		return session.createQuery("from HalalProduct").list();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HalalProduct listById(Long id) {
		// TODO Auto-generated method stub
		HalalProduct halal = new HalalProduct();
		halal = (HalalProduct)session.get(HalalProduct.class,id);
		return halal;
	}

	@Override
	public HalalProduct listByHalalNo(String halalNo) {
		// TODO Auto-generated method stub
		Query query = session.createQuery("from HalalProduct where halal_no = :halalNo ");
		query.setParameter("halalNo", halalNo);
		List list = query.list();
		if(list==null || list.size()==0){
			return null;
		}else{
			return (HalalProduct) list.get(0);
		}
	}
	@Override
	public HalalProduct listByUpc(String upc) {
		// TODO Auto-generated method stub
		Query query = session.createQuery("from HalalProduct where barcode = :upc ");
		query.setParameter("upc", upc);
		List list = query.list();
		if(list==null || list.size()==0){
			return null;
		}else{
			return (HalalProduct) list.get(0);
		}
	}
}
