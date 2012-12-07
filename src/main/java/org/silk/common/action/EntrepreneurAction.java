package org.silk.common.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.silk.common.dao.EntrepreneurDao;
import org.silk.common.dao.EntrepreneurDaoImpl;
import org.silk.common.model.Entrepreneur;
import org.silk.common.model.HalalProduct;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EntrepreneurAction extends ActionSupport implements ModelDriven<Entrepreneur>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Entrepreneur entrepreneur = new Entrepreneur();
	private List<Entrepreneur> entrepreneurList = new ArrayList<Entrepreneur>();
	private EntrepreneurDao dao = new EntrepreneurDaoImpl();
	@Override
	public Entrepreneur getModel() {
		// TODO Auto-generated method stub
		return entrepreneur;
	}
	
	public String save(){
		dao.save(entrepreneur);
		return SUCCESS;
	}
	public String list(){
		entrepreneurList = dao.list();
		return SUCCESS;
	}
	public String delete(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		dao.delete(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	/*
	 * To get single record by Id
	 */
	public String edit(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String id = request.getParameter("id");
		if(id!=null){
			entrepreneur = dao.getById(Long.parseLong(request.getParameter("id")));
		}else{
			entrepreneur = new Entrepreneur();
		}
		
		return SUCCESS;
	}
	public Entrepreneur getEntrepreneur() {
		return entrepreneur;
	}

	public void setEntrepreneur(Entrepreneur entrepreneur) {
		this.entrepreneur = entrepreneur;
	}

	public List<Entrepreneur> getEntrepreneurList() {
		return entrepreneurList;
	}
	public void setEntrepreneurList(List<Entrepreneur> entrepreneurList) {
		this.entrepreneurList = entrepreneurList;
	}

}
