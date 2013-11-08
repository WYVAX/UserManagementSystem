<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>


				<div class="hello-unit">
					<h1>
						Welcome,
						<s:property value="%{session_user.fullName()}" />
					</h1>
					<s:if test='%{session_user.hasRole("ADMIN")}'>
						<a href='<s:url action="adminDashboard" namespace="/security"/>'
							class="btn btn-primary btn-large">Administration</a>
					</s:if>
					<s:else>
					</s:else>

				</div>
				<h3>
					<font color="green">Your Addresses List: </font>
				</h3>
				<div>
					<s:action name="addresses" namespace="/security"
						executeResult="true"></s:action>
				</div>

				<a href='<s:url action="logout" namespace="/registration" /> '>Logout</a>
