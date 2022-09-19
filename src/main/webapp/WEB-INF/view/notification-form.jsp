<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>

<head>
<title>Notification Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="notification">
 
 Type: <form:input path="type" />

 		<br><br>
 
 Header: <form:input path="header" />
  		<form:errors path="header" cssClass="error"/>
		<br><br>
 
 Body: <form:textarea path="body" />
		<form:errors path="body" cssClass="error"/>
		<br><br>

		<input type="submit" value="Submit" />

	</form:form>

</body>

</html>