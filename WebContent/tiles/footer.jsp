<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>


			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Form Layouts</li>
						<s:url var="index_url" action="index" />
						<li class="active"><s:a href="%{index_url}">Horizontal Form Layout</s:a></li>
						<s:url var="vertical_url" action="vertical" />
						<li><s:a href="%{vertical_url}">Vertical Form Layout</s:a></li>
						<s:url var="validation_url" action="validation" />
						<li><s:a href="%{validation_url}">Client Validation</s:a></li>
						<s:url var="advanced_url" action="advanced" />
						<li><s:a href="%{advanced_url}">Advanced Examples</s:a></li>
						<s:url var="jquery_url" action="jquery" />
						<li><s:a href="%{jquery_url}">Struts2 jQuery UI Form Elements</s:a></li>
						<s:url var="custom_url" action="custom" />
						<li><s:a href="%{custom_url}">With Custom Theme</s:a></li>
					</ul>
				</div>
			</div>
