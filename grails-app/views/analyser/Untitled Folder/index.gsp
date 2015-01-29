
<%@ page import="com.Analyser" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'analyser.label', default: 'Analyser')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-analyser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-analyser" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="line" title="${message(code: 'analyser.line.label', default: 'Line')}" />
					
						<g:sortableColumn property="frequency" title="${message(code: 'analyser.frequency.label', default: 'Frequency')}" />
					
						<g:sortableColumn property="file" title="${message(code: 'analyser.file.label', default: 'File')}" />
					
						<g:sortableColumn property="occurence" title="${message(code: 'analyser.occurence.label', default: 'Occurence')}" />
					
						<g:sortableColumn property="stack" title="${message(code: 'analyser.stack.label', default: 'Stack')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${analyserInstanceList}" status="i" var="analyserInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${analyserInstance.id}">${fieldValue(bean: analyserInstance, field: "line")}</g:link></td>
					
						<td>${fieldValue(bean: analyserInstance, field: "frequency")}</td>
					
						<td>${fieldValue(bean: analyserInstance, field: "file")}</td>
					
						<td>${fieldValue(bean: analyserInstance, field: "occurence")}</td>
					
						<td>${fieldValue(bean: analyserInstance, field: "stack")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${analyserInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
