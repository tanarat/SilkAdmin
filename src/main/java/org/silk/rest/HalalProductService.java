package org.silk.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.silk.common.dao.HalalProductDao;
import org.silk.common.dao.HalalProductDaoImpl;
import org.silk.common.model.HalalProduct;
import org.silk.halal.dao.impl.ProductDaoImpl;

@Path("/products")
public class HalalProductService {
	
	List<HalalProduct> productList = new ArrayList<HalalProduct>();
	HalalProductDao productDao = new ProductDaoImpl();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<HalalProduct> getProducts(){
		productList = productDao.list();
		return productList;
	}
	
	
}
