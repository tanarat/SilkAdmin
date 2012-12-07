package org.silk.checklist.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.silk.checklist.model.Checklist;
import org.silk.checklist.model.EvalForm;
import org.silk.checklist.service.ChecklistService;
import org.silk.checklist.service.EvalFormService;
import org.silk.common.model.Entrepreneur;
import org.silk.common.service.EntrepreneurService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EvalFormAction extends ActionSupport implements ModelDriven<EvalForm>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EvalForm form;
	private List<EvalForm> forms; 
	
	private EvalFormService formService = new EvalFormService();
	private EntrepreneurService entrepreneurService = new EntrepreneurService();
	private ChecklistService checklistService = new ChecklistService();
	


	
	
	public String doSave(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String entrepreneurIdSelected = request.getParameter("entrepreneurIdSelected");
		String checklistIdSelected = request.getParameter("checklistIdSelected");
		
		Entrepreneur entrepreneurSelected = entrepreneurService.getEntrepreneur(Long.parseLong(entrepreneurIdSelected));
		Checklist checklistSelected = checklistService.getChecklist(Long.parseLong(checklistIdSelected));
		
		form.setEntrepreneur(entrepreneurSelected);
		form.setChecklist(checklistSelected);
		formService.saveEvalForm(form);
		
		return SUCCESS;
	}
	public String evaluate(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String formId = request.getParameter("formId");
		if(formId!=null){
			form = formService.getEvalForm(Long.parseLong(formId));
		}
		return SUCCESS;
	}
	public String doList(){
		forms = formService.getAllEvalForms();
		
		return SUCCESS;
	}
	public String doDelete(){
		formService.deleteEvalForm(form.getId());
		return SUCCESS;
	}
	public String doInput(){

		return INPUT;
	}
	public String edit(){
		
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String formId = request.getParameter("formId");
		if(formId!=null){
			form = formService.getEvalForm(Long.parseLong(formId));
		}
		
		return INPUT;
	}
	
	public EvalForm getForm() {
		return form;
	}
	public void setForm(EvalForm form) {
		this.form = form;
	}
	public List<EvalForm> getForms() {
		return forms;
	}
	public void setForms(List<EvalForm> forms) {
		this.forms = forms;
	}
	public List<Entrepreneur> getEntrepreneurList(){
		return entrepreneurService.getAllEntrepreneurs();
	}
	public List<Checklist> getChecklistList(){
		return checklistService.getAllChecklists();
	}
	@Override
	public EvalForm getModel() {
		// TODO Auto-generated method stub
		return form;
	}

}
