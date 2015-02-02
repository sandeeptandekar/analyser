
<%@ page import="com.LogException" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
                 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
<g:javascript src="read.js" />
		<g:set var="entityName" value="${message(code: 'logException.label', default: 'LogException')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-logException" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-logException" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list logException">
			
				<g:if test="${logExceptionInstance?.expContainer}">
				<li class="fieldcontain">
					<span id="expContainer-label" class="property-label"><g:message code="logException.expContainer.label" default="Folder Name" /></span>
					
						<span class="property-value" aria-labelledby="expContainer-label"><g:link controller="expContainer" action="show" id="${logExceptionInstance?.expContainer?.id}">${logExceptionInstance?.expContainer.title.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${logExceptionInstance?.expRef}">
				<li class="fieldcontain">
					<span id="expRef-label" class="property-label"><g:message code="logException.expRef.label" default="Key" /></span>
					
						<span  class="property-value" aria-labelledby="expRef-label"><g:link controller="exceptionRef" action="show" id="${logExceptionInstance?.expRef?.id}">${logExceptionInstance?.expRef.key.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${logExceptionInstance?.frequency}">
				<li class="fieldcontain">
					<span id="frequency-label" class="property-label"><g:message code="logException.frequency.label" default="Frequency" /></span>
					
						<span class="property-value" aria-labelledby="frequency-label"><g:fieldValue bean="${logExceptionInstance}" field="frequency"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${logExceptionInstance?.logFilePath}">
				<li class="fieldcontain">
					<span id="logFilePath-label" class="property-label"><g:message code="logException.logFilePath.label" default="Log File Path" /></span>
					
						<span class="property-value" aria-labelledby="logFilePath-label"><g:fieldValue bean="${logExceptionInstance}" field="logFilePath"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:logExceptionInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${logExceptionInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
