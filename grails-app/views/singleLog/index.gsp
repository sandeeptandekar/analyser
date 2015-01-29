
<%@ page import="com.SingleLog" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'singleLog.label', default: 'SingleLog')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-singleLog" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-singleLog" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="singleLog.expContainer.label" default="Exp Container" /></th>
					
						<th><g:message code="singleLog.expRef.label" default="Exp Ref" /></th>
					
						<g:sortableColumn property="frequency" title="${message(code: 'singleLog.frequency.label', default: 'Frequency')}" />
					
						<g:sortableColumn property="logFilePath" title="${message(code: 'singleLog.logFilePath.label', default: 'Log File Path')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${singleLogInstanceList}" status="i" var="singleLogInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${singleLogInstance.id}">${fieldValue(bean: singleLogInstance, field: "expContainer")}</g:link></td>
					
						<td>${fieldValue(bean: singleLogInstance, field: "expRef")}</td>
					
						<td>${fieldValue(bean: singleLogInstance, field: "frequency")}</td>
					
						<td>${fieldValue(bean: singleLogInstance, field: "logFilePath")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${singleLogInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
