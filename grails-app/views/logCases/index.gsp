
<%@ page import="com.LogCases" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'logCases.label', default: 'LogCases')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-logCases" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-logCases" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="ticketUrl" title="${message(code: 'logCases.ticketUrl.label', default: 'Ticket Url')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'logCases.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'logCases.lastUpdated.label', default: 'Last Updated')}" />
					
						<th><g:message code="logCases.product.label" default="Product" /></th>
					
						<g:sortableColumn property="uploadedFilePath" title="${message(code: 'logCases.uploadedFilePath.label', default: 'Uploaded File Path')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${logCasesInstanceList}" status="i" var="logCasesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${logCasesInstance.id}">${fieldValue(bean: logCasesInstance, field: "ticketUrl")}</g:link></td>
					
						<td><g:formatDate date="${logCasesInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${logCasesInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: logCasesInstance, field: "product")}</td>
					
						<td>${fieldValue(bean: logCasesInstance, field: "uploadedFilePath")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${logCasesInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
