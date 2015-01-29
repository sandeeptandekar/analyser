<%@ page import="com.ExceptionRef" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'exceptionRef.label', default: 'ExceptionRef')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-exceptionRef" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="edit-exceptionRef" class="content scaffold-edit" role="main">
			<h1>Edit</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${exceptionRefInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${exceptionRefInstance}" var="error">
				<li> <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:hm, action:'update']" method="PUT" style="width: 960px" >
				
				
					<g:render template="form"/>
	




			<fieldSet class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				
</fieldSet>
			</g:form>
		</div>
	</body>
</html>
