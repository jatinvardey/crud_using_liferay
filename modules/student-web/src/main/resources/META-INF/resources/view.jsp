<%@ include file="init.jsp"%>
<%@page import="java.util.List"%>
<%@ page
	import="com.liferay.portal.kernel.util.ParamUtil,com.liferay.portal.kernel.dao.search.ResultRow,com.ignek.student.model.student"%>

<p style="text-align: center;">
	<b>List Of Students</b>
</p>

<%
List<student> studentList = (List<student>) renderRequest.getAttribute("studentList");
%>

<portlet:renderURL var="addStudentURL">
	<portlet:param name="mvcPath" value="/addStudent.jsp"></portlet:param>
</portlet:renderURL>
<aui:button-row style="text-align: center;">
	<aui:button primary="true" onClick="${addStudentURL}"
		value="Add Student"></aui:button>
</aui:button-row>
<table class="table table-striped">
	<tr>
		<th>Name</th>
		<th>Mobile Number</th>
		<th>Gender</th>
		<th>Email</th>
		<th>Birthdate</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${studentList}" var="student">

		<portlet:renderURL var="editStudentURL">
			<portlet:param name="studentId" value="${student.getStudentId()}" />
			<portlet:param name="name" value="${student.getName()}" />
			<portlet:param name="mobilenumber"
				value="${student.getMobilenumber()}" />
			<portlet:param name="gender" value="${student.getGender()}" />
			<portlet:param name="email" value="${student.getEmail()}" />
			<portlet:param name="birthdate" value="${student.getBirthdate()}" />
			<portlet:param name="mvcPath" value="/editStudent.jsp" />
		</portlet:renderURL>
		<portlet:actionURL name="deleteStudent" var="deleteStudentURL">
			<portlet:param name="studentId" value="${student.getStudentId()}" />
		</portlet:actionURL>

		<tr>
			<td>${student.name}</td>
			<td>${student.mobilenumber}</td>
			<td>${student.gender}</td>
			<td>${student.email}</td>
			<td>${student.birthdate}</td>
			<td><liferay-ui:icon-list>
					<liferay-ui:icon image="edit" message="edit"
						url="${editStudentURL}" />
					<liferay-ui:icon image="delete" message="delete"
						url="${deleteStudentURL}" />
				</liferay-ui:icon-list></td>
		</tr>
	</c:forEach>
</table>