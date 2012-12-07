package org.silk.common.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.ServletActionContext;
import org.silk.common.dao.EntrepreneurDao;
import org.silk.common.dao.EntrepreneurDaoImpl;
import org.silk.common.dao.HalalProductDao;
import org.silk.common.dao.HalalProductDaoImpl;
import org.silk.common.model.Entrepreneur;
import org.silk.common.model.HalalProduct;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class HalalProductAction extends ActionSupport implements ModelDriven<HalalProduct>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HalalProduct halalProduct = new HalalProduct();
	private List<HalalProduct> halalProducts = new ArrayList<HalalProduct>();
	private HalalProductDao dao = new HalalProductDaoImpl();
	private EntrepreneurDao entrepreneurDao = new EntrepreneurDaoImpl();

	private String barcodeSearch;
	
//	private Long ownerId;
	/* List all entrepreneur's name
	 * Show in the combobox on add, edit page
	 * */
	private Map<Long,Entrepreneur> companyList = new LinkedHashMap<Long, Entrepreneur>(); ;
	public HalalProductAction(){

	}
	


	public Map<Long, Entrepreneur> getCompanyList() {
		List<Entrepreneur> list = entrepreneurDao.list();
		for (Entrepreneur entrepreneur : list) {
			companyList.put(entrepreneur.getId(), entrepreneur);
		}
		return companyList;
	}



	public void setCompanyList(Map<Long, Entrepreneur> companyList) {
		this.companyList = companyList;
	}



	@Override
	public HalalProduct getModel() {
		// TODO Auto-generated method stub
		return halalProduct;
	}
	
	public String save(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Long ownerId = Long.parseLong(request.getParameter("companySelected"));
		System.out.println("Owner id : " + ownerId);
		Entrepreneur owner = entrepreneurDao.getById(ownerId);
		halalProduct.setOwner(owner);
		dao.save(halalProduct);
		return SUCCESS;
	}
	
	public String list(){
		halalProducts = dao.list();
		return SUCCESS;
	}
	public String delete(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		dao.delete(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String search(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		barcodeSearch = request.getParameter("barcode");
		if(barcodeSearch!=null && barcodeSearch.length()==12){
			halalProduct = dao.listByHalalNo(barcodeSearch);
		}else if(barcodeSearch!=null && barcodeSearch.length()==13){
			halalProduct = dao.listByUpc(barcodeSearch);
		}else{
//			halalBarcode = new HalalBarcode();
			halalProduct = null;
		}
		if(halalProduct == null){
			return ERROR;
		}
		return SUCCESS;
	}
	/*
	 * To get single record by Id
	 */
	public String edit(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String id = request.getParameter("id");
		if(id!=null){
			halalProduct = dao.listById(Long.parseLong(request.getParameter("id")));
		}else{
			halalProduct = new HalalProduct();
		}
		
		return SUCCESS;
	}

	public HalalProduct getHalalProduct() {
		return halalProduct;
	}

	public void setHalalProduct(HalalProduct halalProduct) {
		this.halalProduct = halalProduct;
	}

	public List<HalalProduct> getHalalProducts() {
		return halalProducts;
	}

	public void setHalalProducts(List<HalalProduct> halalBarcodeList) {
		this.halalProducts = halalBarcodeList;
	}



	public String getBarcodeSearch() {
		return barcodeSearch;
	}



	public void setBarcodeSearch(String barcodeSearch) {
		this.barcodeSearch = barcodeSearch;
	}
	
}
