
<%@ page import="com.ExceptionRef" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'exceptionRef.label', default: 'ExceptionRef')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-exceptionRef" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-exceptionRef" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="category" title="${message(code: 'exceptionRef.category.label', default: 'Category')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'exceptionRef.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="key" title="${message(code: 'exceptionRef.key.label', default: 'Key')}" />
					
						<th><g:message code="exceptionRef.product.label" default="Product" /></th>
					
						<g:sortableColumn property="resolution" title="${message(code: 'exceptionRef.resolution.label', default: 'Resolution')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${exceptionRefInstanceList}" status="i" var="exceptionRefInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${exceptionRefInstance.id}">${fieldValue(bean: exceptionRefInstance, field: "category")}</g:link></td>
					
						<td>${fieldValue(bean: exceptionRefInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: exceptionRefInstance, field: "key")}</td>
					
						<td>${fieldValue(bean: exceptionRefInstance, field: "product")}</td>
					
						<td>${fieldValue(bean: exceptionRefInstance, field: "resolution")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${exceptionRefInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
