
<%@ page import="com.LogCase" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'logCase.label', default: 'LogCase')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-logCase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-logCase" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list logCase">
			
				<g:if test="${logCaseInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${logCaseInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${logCaseInstance?.expContainer}">
				<li class="fieldcontain">
					<span id="expContainer-label" class="property-label"><g:message code="logCase.expContainer.label" default="Exp Container" /></span>
					
						<g:each in="${logCaseInstance.expContainer}" var="e">
						<span class="property-value" aria-labelledby="expContainer-label"><g:link controller="expContainer" action="show" id="${e.id}">${e.title.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${logCaseInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="logCase.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${logCaseInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${logCaseInstance?.product}">
				<li class="fieldcontain">
					<span id="product-label" class="property-label"><g:message code="logCase.product.label" default="Product" /></span>
					
						<span class="property-value" aria-labelledby="product-label"><g:link controller="product" action="show" id="${logCaseInstance?.product?.id}">${logCaseInstance?.product?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${logCaseInstance?.ticketUrl}">
				<li class="fieldcontain">
					<span id="ticketUrl-label" class="property-label"><g:message code="logCase.ticketUrl.label" default="Ticket Url" /></span>
					
						<span class="property-value" aria-labelledby="ticketUrl-label"><g:fieldValue bean="${logCaseInstance}" field="ticketUrl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${logCaseInstance?.uploadedFilePath}">
				<li class="fieldcontain">
					<span id="uploadedFilePath-label" class="property-label"><g:message code="logCase.uploadedFilePath.label" default="Uploaded File Path" /></span>
					
						<span class="property-value" aria-labelledby="uploadedFilePath-label"><g:fieldValue bean="${logCaseInstance}" field="uploadedFilePath"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:logCaseInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${logCaseInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
<g:actionSubmit action="page"  class="show" value="Summary"/>	</fieldset></g:form>
			
		</div>
	</body>
</html>
