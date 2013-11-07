<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<sb:head includeScripts="false" includeScriptsValidation="false"
	includeStylesResponsive="true" />

<style type="text/css">
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<title>Login Page</title>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">Some top things here.</div>
		</div>
	</div>


	<div class="container-fluid">
		<div class="row-fluid">


			<%-- 		      <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">
                    Form Layouts
                    </li>
                    <s:url var="index_url" action="index"/>
                    <li><s:a href="%{index_url}">Horizontal Form Layout</s:a></li>
                    <s:url var="vertical_url" action="vertical"/>
                    <li class="active"><s:a href="%{vertical_url}">Vertical Form Layout</s:a></li>
                    <s:url var="validation_url" action="validation"/>
                    <li><s:a href="%{validation_url}">Client Validation</s:a></li>
                     <s:url var="advanced_url" action="advanced"/>
                    <li><s:a href="%{advanced_url}">Advanced Examples</s:a></li>
                    <s:url var="jquery_url" action="jquery"/>
                    <li><s:a href="%{jquery_url}">Struts2 jQuery UI Form Elements</s:a></li>
               </ul>
            </div>
        </div> --%>


			<div class="span9">
				<s:actionerror theme="bootstrap" />
				<s:actionmessage theme="bootstrap" />
				<s:fielderror theme="bootstrap" />


				<s:form action="login" enctype="multipart/form-data"
					theme="bootstrap" cssClass="form-horizontal">
					<s:textfield name="username" placeholder="login"
						label="input user name" tooltip="input username here" />

					<s:password name="password" placeholder="password"
						label="input password" tooltip="input username here" />

					<s:submit cssClass="btn" />
				</s:form>
			</div>
			<br> Or register <a
				href='<s:url action="regPageMD" namespace="/registration"/>'><font
				color="red">HERE</font></a>
			<s:debug />
		</div>

		<footer class="footer">
		<p class="pull-right">
			<a href="#">Back to top</a>
		</p>

		<p>
			Created by <a href="http://twitter.com/jogep" target="_blank">@jogep</a>.
		</p>
		</footer>


	</div>
</body>
</html>