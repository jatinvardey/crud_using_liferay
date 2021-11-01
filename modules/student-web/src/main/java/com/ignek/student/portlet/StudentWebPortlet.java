package com.ignek.student.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ignek.student.constants.StudentWebPortletKeys;
import com.ignek.student.model.student;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author ignek
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.Jatin",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=StudentWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + StudentWebPortletKeys.STUDENTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator"
	},
	service = Portlet.class
)
public class StudentWebPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	com.ignek.student.service.studentLocalService studentLocalService;

	@ProcessAction(name = "addStudent")
	public void addStudent(ActionRequest request, ActionResponse response) {

		long studentId = counterLocalService.increment(this.getClass().getName());
		String name = ParamUtil.getString(request, "name");
		String mobilenumber = ParamUtil.getString(request, "mobilenumber");
		String gender = ParamUtil.getString(request, "gender");
		String email = ParamUtil.getString(request, "email");
		String birthdate = ParamUtil.getString(request, "birthdate");

		student student = studentLocalService.createstudent(studentId);
		student.setName(name);
		student.setMobilenumber(mobilenumber);
		student.setGender(gender);
		student.setEmail(email);
		student.setBirthdate(birthdate);
		studentLocalService.addstudent(student);
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		List<student> studentList = studentLocalService.getstudents(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("studentList", studentList);
		super.render(renderRequest, renderResponse);
	}
	
	@ProcessAction(name = "deleteStudent")
    public void deleteStudent(ActionRequest request, ActionResponse response){
        long studentId = ParamUtil.getLong(request, "studentId");
        try {
            studentLocalService.deletestudent(studentId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

	@ProcessAction(name = "editStudent")
    public void editStudent(ActionRequest request, ActionResponse response) {

        long studentId = ParamUtil.getLong(request, "studentId");
        String name = ParamUtil.getString(request, "name");
        String mobilenumber = ParamUtil.getString(request, "mobilenumber");
        String gender = ParamUtil.getString(request, "gender");
        String email = ParamUtil.getString(request, "email");
        String birthdate = ParamUtil.getString(request, "birthdate");
        
        student student = null;
		try {
			student = studentLocalService.getstudent(studentId);
		} catch (PortalException e) {
			e.printStackTrace();
		} 
        student.setName(name);
        student.setMobilenumber(mobilenumber);
        student.setGender(gender);
        student.setEmail(email);
        student.setBirthdate(birthdate);
        studentLocalService.updatestudent(student);
    }
}