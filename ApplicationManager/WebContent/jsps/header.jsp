<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<div id="header">
<div id="logo">
<h1><a href="#">Manager Console</a></h1>
<h2><a href="http://www.google.com/">Crass App Space</a></h2>
<div id="greet">Welcome <s:property value="#session.empName" /></div>
<div id="logout"><a href="<s:url action = 'Logout'/>">Logout</a></div>
</div>
</div>