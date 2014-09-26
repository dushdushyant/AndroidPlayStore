<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<link rel="shortcut icon" href="images/headerIcon.png">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<link href="<%=request.getContextPath()%>/css/login.css"
	rel="stylesheet" type="text/css" />
<title>Login page</title>
<s:head/>
</head>


<body id=body>
<div id="Login_body" align="center"><!--<div id="Login">

--><!--<table id="Login" border="0">
	--><s:form action="Login">
	<table align="center">
		<tr>
			<td align="center" class="heading"><br>
			</td>
		</tr>
				<tr>
			<td align="center"><font color="#0099CC" face="Serif" size="6">Application Manager Console</font></td>
		</tr>

		<tr>
			<td>
			<table align="center" border="0">
				<tr>
					<td><s:textfield label="User Name" name="username" /></td>

				</tr>
				<tr>
					<td><s:password label="Password" name="password" size="20" />
					</td>

				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td><s:submit align="center" /></td>
		</tr>
		<tr>
			<td><font color="#4863A0"> Please enter your Username and
			Password to enter.</font></td>
		</tr>
		<tr>
			<td></td>
		</tr>

	</table>
</s:form> <!-- <a href="<s:url action = 'toDevice'/>">Not Registered?</a> --> <!--</table>
--></div>
<!--</div>
-->
<div id=bg></div>
</body>

</html>