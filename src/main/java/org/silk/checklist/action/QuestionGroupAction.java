package org.silk.checklist.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.silk.checklist.dao.QuestionGroupDao;
import org.silk.checklist.dao.QuestionGroupDaoImpl;
import org.silk.checklist.model.QuestionGroup;
import org.silk.checklist.service.QuestionGroupService;
import org.silk.common.model.Entrepreneur;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class QuestionGroupAction extends ActionSupport implements Preparable{ //ModelDriven<QuestionGroup>,

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private QuestionGroup questionGroup;// = new QuestionGroup();
	private List<QuestionGroup> questionGroups; // = new ArrayList<QuestionGroup>();
	
	private QuestionGroupService questionGroupService = new QuestionGroupService();

	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("prepare...");

//		System.out.println(questionGroup.getId());
		if(questionGroup != null && questionGroup.getId() != null){
			System.out.println("group id " + questionGroup.getId());
			System.out.println("group name " + questionGroup.getGroupName());
			questionGroup = questionGroupService.getQuestionGroup(questionGroup.getId());
			System.out.println("group id " + questionGroup.getId());
			System.out.println("group name " + questionGroup.getGroupName());
		}
	}
	
//	public QuestionGroup getModel() {
//		// TODO Auto-generated method stub
//		return questionGroup;
//	}
	
	public String doSave(){
		questionGroupService.saveQuestionGroup(questionGroup);
		return SUCCESS;
	}
	public String doList(){
		System.out.println("do list..");
		questionGroups = questionGroupService.getAllQuestionGroups();
		return SUCCESS;
	}
	public String doDelete(){
		questionGroupService.deleteQuestionGroup(questionGroup.getId());
		return SUCCESS;
	}
	public String doInput(){
		System.out.println("group name : " + questionGroup.getGroupName());
		return INPUT;
	}
	public String edit(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String qGroupId = request.getParameter("qGroupId");
		if(qGroupId!=null){
			questionGroup = questionGroupService.getQuestionGroup(Long.parseLong(qGroupId));
		}
		return SUCCESS;
	}
	/*
	 * To get single record by Id
	 */
//	public String edit(){
//		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
//		String id = request.getParameter("id");
//		if(id!=null){
//			questionGroup = dao.listById(Long.parseLong(request.getParameter("id")));
//		}else{
//			questionGroup = new QuestionGroup();
//		}
//		
//		return SUCCESS;
//	}
	public QuestionGroup getQuestionGroup() {
		return questionGroup;
	}

	public void setQuestionGroup(QuestionGroup qgroup) {
		this.questionGroup = qgroup;
	}

	public List<QuestionGroup> getQuestionGroups() {
		return questionGroups;
	}
	public void setQuestionGroups(List<QuestionGroup> qgroups) {
		this.questionGroups = qgroups;
	}


	

}
