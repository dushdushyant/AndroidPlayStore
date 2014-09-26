<%@page import="com.apk.manager.util.ApkFetcher"%>
<%@page import="com.apk.manager.util.AppManagerProperties"%>
<%@page import="java.io.File"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
<script type="text/javascript">
	function confirmDemoReset() {
		return confirm("Do you want to reset the demo data?");
	}
</script>
<link rel="shortcut icon" href="images/headerIcon.png">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="Expires" content="0">
<title>Home</title>
<link href="<%=request.getContextPath()%>/css/report.css"
	rel="stylesheet" type="text/css" />
</head>


<body>
	<div id="wrapper">
		<!-- Including the header jsp page -->
		<jsp:include page="header.jsp" />
		<!-- end of jsp header include -->
		<!-- end div#header -->
		<div id="menu">
			<ul>
				<li class="active"><a href="#">Home</a></li>
				<li><a href="<s:url action = 'AppDetails'/>">Application
						Details</a></li>
				<li><a href="<s:url action = 'PostApp'/>">Post Application</a></li>
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
							<a href="#">Application Manager - Home</a>
						</h2>
						<p class="byline"></p>
						<div class="entry">

							<p>
								<jsp:scriptlet>System.out.println("#########################"+AppManagerProperties.getInstance().getApkLocn()); File fodlerName = new File(AppManagerProperties.getInstance().getApkLocn());
			request.setAttribute("apkList",ApkFetcher.getInstance().getApkFiles(fodlerName));
					</jsp:scriptlet>
								<display:table id="data" export="true" name="apkList"
									defaultsort="10" defaultorder="ascending" pagesize="15">
									<display:setProperty name="paging.banner.placement"
										value="both" />
									<display:column property='apkName' title="APK Name"
										sortable="true" headerClass=""/>
								</display:table>
								<br> <strong> </strong><br />
							</p>

							<p>
								<s:form action="RabbitTest">
----------------------------
</s:form>
							</p>
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