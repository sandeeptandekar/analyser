
<%@ page import="com.SingleLog" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'singleLog.label', default: 'SingleLog')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-singleLog" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-singleLog" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list singleLog">
			
				<g:if test="${singleLogInstance?.expContainer}">
				<li class="fieldcontain">
					<span id="expContainer-label" class="property-label"><g:message code="singleLog.expContainer.label" default="Exp Container" /></span>
					
						<span class="property-value" aria-labelledby="expContainer-label"><g:link controller="expContainer" action="show" id="${singleLogInstance?.expContainer?.id}">${singleLogInstance?.expContainer?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${singleLogInstance?.expRef}">
				<li class="fieldcontain">
					<span id="expRef-label" class="property-label"><g:message code="singleLog.expRef.label" default="Exp Ref" /></span>
					
						<span class="property-value" aria-labelledby="expRef-label"><g:link controller="exceptionRef" action="show" id="${singleLogInstance?.expRef?.id}">${singleLogInstance?.expRef?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${singleLogInstance?.frequency}">
				<li class="fieldcontain">
					<span id="frequency-label" class="property-label"><g:message code="singleLog.frequency.label" default="Frequency" /></span>
					
						<span class="property-value" aria-labelledby="frequency-label"><g:fieldValue bean="${singleLogInstance}" field="frequency"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${singleLogInstance?.logFilePath}">
				<li class="fieldcontain">
					<span id="logFilePath-label" class="property-label"><g:message code="singleLog.logFilePath.label" default="Log File Path" /></span>
					
						<span class="property-value" aria-labelledby="logFilePath-label"><g:fieldValue bean="${singleLogInstance}" field="logFilePath"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:singleLogInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${singleLogInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
