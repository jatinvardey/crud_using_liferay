<%@ include file="init.jsp"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addStudent" var="addStudentURL"/>
			
<h2 style="text-align: center;">Add Student</h2>

<aui:form action="${addStudentURL}" name="studentForm" method="POST">
	<aui:fieldset>
		<aui:input label="Name" name="name" type="text">
			<aui:validator name="required" />
		</aui:input>

		<aui:input label="Mobile Number" name="mobilenumber" type="number">
			<aui:validator name="required" />
			<aui:validator name="maxLength">10</aui:validator>
			<aui:validator name="minLength">10</aui:validator>			
		</aui:input>

		<aui:field-wrapper> 
		<h5>Gender:</h5>
		<aui:input label="Male" name="gender" value="Male" type="radio"></aui:input>
		<aui:input label="Female" name="gender" value="Female" type="radio"></aui:input>
		</aui:field-wrapper> 

		<aui:input label="Email" name="email" type="email">
			<aui:validator name="required" />
			<aui:validator name="email"></aui:validator>
		</aui:input>

		<aui:input label="Birthdate" name="birthdate" type="date">
			<aui:validator name="required" />
		</aui:input>

	</aui:fieldset>

<aui:button-row  style="text-align: center;">
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="${viewURL}"></aui:button>
	</aui:button-row>

</aui:form>