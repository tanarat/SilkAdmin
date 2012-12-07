package test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Circle circle;
	private List<Circle> circleList = CircleDao.circleList;
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public List<Circle> getCircleList() {
		return circleList;
	}
	public void setCircleList(List<Circle> circleList) {
		this.circleList = circleList;
	}
	public String add(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String txtRadius = request.getParameter("txtRadius");
		System.out.println(txtRadius);
		circleList.add(new Circle(Double.parseDouble(txtRadius)));
		return SUCCESS;
	}
	
}
