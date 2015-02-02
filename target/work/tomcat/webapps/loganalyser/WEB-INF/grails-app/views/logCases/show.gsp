
<%@ page import="com.LogCases" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'logCases.label', default: 'LogCases')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-logCases" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-logCases" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list logCases">
			
				<g:if test="${logCasesInstance?.ticketUrl}">
				<li class="fieldcontain">
					<span id="ticketUrl-label" class="property-label"><g:message code="logCases.ticketUrl.label" default="Ticket Url" /></span>
					
						<span class="property-value" aria-labelledby="ticketUrl-label"><g:fieldValue bean="${logCasesInstance}" field="ticketUrl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${logCasesInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="logCases.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${logCasesInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${logCasesInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="logCases.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${logCasesInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${logCasesInstance?.product}">
				<li class="fieldcontain">
					<span id="product-label" class="property-label"><g:message code="logCases.product.label" default="Product" /></span>
					
						<span class="property-value" aria-labelledby="product-label"><g:link controller="product" action="show" id="${logCasesInstance?.product?.id}">${logCasesInstance?.product?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${logCasesInstance?.uploadedFilePath}">
				<li class="fieldcontain">
					<span id="uploadedFilePath-label" class="property-label"><g:message code="logCases.uploadedFilePath.label" default="Uploaded File Path" /></span>
					
						<span class="property-value" aria-labelledby="uploadedFilePath-label"><g:fieldValue bean="${logCasesInstance}" field="uploadedFilePath"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:logCasesInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${logCasesInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
