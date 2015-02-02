
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
                                            

<g:sortableColumn property="id" defaultOrder="desc" title="${message(code: 'logCase.id.label', default: 'Case id')}"  />
					
						<g:sortableColumn property="dateCreated"  defaultOrder="desc" title="${message(code: 'logCase.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'logCase.lastUpdated.label', default: 'Last Updated')}" defaultOrder="desc" />
					
						<th><g:message code="logCase.product.label" default="Product" /></th>
					
						<g:sortableColumn property="ticketUrl" title="${message(code: 'logCase.ticketUrl.label', default: 'Ticket Url')}" defaultOrder="desc"/>
					
						<g:sortableColumn property="uploadedFilePath" title="${message(code: 'logCase.uploadedFilePath.label', default: 'Uploaded File Path')}" defaultOrder="desc" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${logCaseInstanceList}" status="i" var="logCaseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                
					<td><g:link action="page1" id="${logCaseInstance.id}">${logCaseInstance.id}</g:link></td>
						<td>${fieldValue(bean: logCaseInstance, field: "dateCreated")}</td>
					
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
