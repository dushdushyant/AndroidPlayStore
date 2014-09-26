<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>

<link rel="shortcut icon" href="images/headerIcon.png">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="Expires" content="0">
<title>Deploy App</title>
<link href="<%=request.getContextPath()%>/css/report.css"
	rel="stylesheet" type="text/css" />
	<s:head/>
</head>


<body>
	<div id="wrapper">
		<!-- Including the header jsp page -->
		<jsp:include page="header.jsp" />
		<!-- end of jsp header include -->
		<!-- end div#header -->
		<div id="menu">
			<ul>
				<li><a href="<s:url action = 'Home'/>">Home</a></li>
				<li><a href="<s:url action = 'AppDetails'/>">Application
						Details</a></li>
				<li class="active"><a href="">Post Application</a></li>
				<li><a href="<s:url action = 'DelApp'/>">Delete Application</a></li>
				<li><a href="<s:url action = 'HelpApp'/>">Help</a></li>
			</ul>
		</div>
		<!-- end div#menu -->
		<div id="page">
			<div id="page-bgtop">
				<div id="content">
					<div class="post">
						<h2 class="title">
							<a href="#">Application Manager - Deploy App</a>
						</h2>
						<p class="byline"></p>
						<div class="entry">
							<s:actionerror />
							<s:form action="upload" method="post"
								enctype="multipart/form-data">
								<s:file name="userApk" label="Select Apk File" />
								<table align="center" border="0">
									<tr>
										<td><s:textfield label="Application Name" name="appName" /></td>

									</tr>
									<tr>
										<td><s:textfield label="App Owner" name="appOwner"
												size="20" /></td>

									</tr>
									<tr>
										<td><s:textfield label="App Ver" name="appVer"
												size="20" /></td>

									</tr>
								</table>
								<s:submit value="Upload" align="center" />
							</s:form>

						</div>
						<div class="meta"></div>
					</div>
				</div>
				<div style="clear: both; height: 1px"></div>
			</div>
		</div>
		<!-- end div#page -->
<!-- Footer begins -->
		<jsp:include page="footer.jsp" />
		<!-- footer ends -->
		<!-- end div#footer -->
	</div>
	<!-- end div#wrapper -->


</body>
</html>