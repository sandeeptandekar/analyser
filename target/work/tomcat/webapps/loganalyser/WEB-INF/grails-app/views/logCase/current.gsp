<%@ page import="com.LogCase" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'logCase.label', default: 'LogCase')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-logCase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-logCase" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
                                            <th><g:message code="logCase.id.label" default="Case id" /></th>


					
						<g:sortableColumn property="dateCreated" title="${message(code: 'logCase.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'logCase.lastUpdated.label', default: 'Last Updated')}" />
					
						<th><g:message code="logCase.product.label" default="Product" /></th>
					
						<g:sortableColumn property="ticketUrl" title="${message(code: 'logCase.ticketUrl.label', default: 'Ticket Url')}" />
					
						<g:sortableColumn property="uploadedFilePath" title="${message(code: 'logCase.uploadedFilePath.label', default: 'Uploaded File Path')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${smallList}" status="i" var="logCaseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                
					<td>${fieldValue(bean: logCaseInstance, field: "id")}</td>
						<td><g:link action="show" id="${logCaseInstance.id}">${fieldValue(bean: logCaseInstance, field: "dateCreated")}</g:link></td>
					
						<td><g:formatDate date="${logCaseInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: logCaseInstance, field: "product")}</td>
					
						<td>${fieldValue(bean: logCaseInstance, field: "ticketUrl")}</td>
					
						<td>${fieldValue(bean: logCaseInstance, field: "uploadedFilePath")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${logCaseInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
