
<%@ page import="com.ExpContainer" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'expContainer.label', default: 'ExpContainer')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-expContainer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-expContainer" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list expContainer">
			
				<g:if test="${expContainerInstance?.logCase}">
				<li class="fieldcontain">
					<span id="logCase-label" class="property-label"><g:message code="expContainer.logCase.label" default="Log Case" /></span>
					
						<span class="property-value" aria-labelledby="logCase-label"><g:link controller="logCase" action="show" id="${expContainerInstance?.logCase?.id}">${expContainerInstance?.logCase.id.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${expContainerInstance?.logException}">
				<li class="fieldcontain">
					<span id="logException-label" class="property-label"><g:message code="expContainer.logException.label" default="Log Exception" /></span>
					
						<g:each in="${expContainerInstance.logException}" var="l">
						<span class="property-value" aria-labelledby="logException-label"><g:link controller="logException" action="show" id="${l.id}">${l.id.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${expContainerInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="expContainer.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${expContainerInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:expContainerInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${expContainerInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
