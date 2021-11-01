<%@ include file="init.jsp"%>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="editStudent" var="editStudentURL" />
<%
String studentId = renderRequest.getParameter("studentId");
String name = renderRequest.getParameter("name");
String mobilenumber = renderRequest.getParameter("mobilenumber");
String gender = renderRequest.getParameter("gender");
String email = renderRequest.getParameter("email");
String birthdate = renderRequest.getParameter("birthdate");
%>

<h2 style="text-align: center;">Edit Student</h2>

<aui:form action="${editStudentURL}" method="POST">
	<aui:fieldset>
		<aui:input name="studentId" type="hidden"
			value="<%=Long.parseLong(studentId)%>" />

		<aui:input label="Name" name="name" type="text"></aui:input>

		<aui:input label="Mobile Number" name="mobilenumber" type="number">
			<aui:validator name="maxLength">10</aui:validator>
			<aui:validator name="minLength">10</aui:validator>
		</aui:input>

		<aui:field-wrapper>
			<h5>Gender:</h5>
			<aui:input label="Male" name="gender" value="Male" type="radio"></aui:input>
			<aui:input label="Female" name="gender" value="Female" type="radio"></aui:input>
		</aui:field-wrapper>

		<aui:input label="Email" name="email" type="email">
			<aui:validator name="email"></aui:validator>
		</aui:input>

		<aui:input label="Birthdate" name="birthdate" type="date"
			value="<%=birthdate%>"></aui:input>

	</aui:fieldset>
	<aui:button-row style="text-align: center;">
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="${viewURL}"></aui:button>
	</aui:button-row>
</aui:form>