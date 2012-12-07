package org.silk.common.dao;

import java.util.List;

import org.silk.common.model.HalalProduct;



public interface HalalProductDao{
	public void save(HalalProduct halalBarcode);
	public List<HalalProduct> list();
	public void delete(Long id);
	public HalalProduct listById(Long id);
	public HalalProduct listByHalalNo(String halalNo);
	public HalalProduct listByUpc(String upc);
}
