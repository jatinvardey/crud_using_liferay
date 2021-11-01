<%@ include file="init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil,com.liferay.portal.kernel.dao.search.ResultRow,com.ignek.student.model.student" %>

<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");
    ResultRow row = (ResultRow) request.getAttribute("SEARCH_CONTAINER_RESULT_ROW");
    student student = (student) row.getObject();
%>

<liferay-ui:icon-list>
 	 <portlet:renderURL var="editStudentURL">
        <portlet:param name="studentId" value="<%=String.valueOf(student.getStudentId()) %>" />
        <portlet:param name="name" value="<%=student.getName() %>" />
        <portlet:param name="mobilenumber" value="<%=student.getMobilenumber() %>" />
        <portlet:param name="gender" value="<%=student.getGender() %>" />
        <portlet:param name="email" value="<%=student.getEmail() %>" />
        <portlet:param name="birthdate" value="<%=String.valueOf(student.getBirthdate()) %>" />
        <portlet:param name="mvcPath" value="/editStudent.jsp" />
     </portlet:renderURL>

     <liferay-ui:icon image="edit" message="edit" url="${editStudentURL}"/>

     <portlet:actionURL name="deleteStudent" var="deleteStudentURL">
            <portlet:param name="studentId" value="<%= String.valueOf(student.getStudentId()) %>" />
     </portlet:actionURL>     

        <liferay-ui:icon image="delete" message="delete" url="${deleteStudentURL}"/>
</liferay-ui:icon-list>