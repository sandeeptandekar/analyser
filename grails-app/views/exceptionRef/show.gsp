
<%@ page import="com.ExceptionRef" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
		<g:set var="entityName" value="${message(code: 'exceptionRef.label', default: 'ExceptionRef')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-exceptionRef" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:each in="${id2}" var="c"><g:link action="summary" id="${c.value}"> Back</g:link></g:each></li>
</ul>
		</div>
		<div id="show-exceptionRef" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list exceptionRef">
			
				<g:if test="${exceptionRefInstance?.category}">
				<li class="fieldcontain">
					<span id="category-label" class="property-label"><g:message code="exceptionRef.category.label" default="Category" /></span>
					
						<span class="property-value" aria-labelledby="category-label"><g:fieldValue bean="${exceptionRefInstance}" field="category"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${exceptionRefInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="exceptionRef.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${exceptionRefInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${exceptionRefInstance?.key}">
				<li class="fieldcontain">
					<span id="key-label" class="property-label"><g:message code="exceptionRef.key.label" default="Key" /></span>
					
						<span class="property-value" aria-labelledby="key-label"><pre><g:fieldValue bean="${exceptionRefInstance}" field="key"/></pre></span>
					
				</li>
				</g:if>
			
				<g:if test="${exceptionRefInstance?.product}">
				<li class="fieldcontain">
					<span id="product-label" class="property-label"><g:message code="exceptionRef.product.label" default="Product" /></span>
					
						<span class="property-value" aria-labelledby="product-label"><g:link controller="product" action="show" id="${exceptionRefInstance?.product?.id}">${exceptionRefInstance?.product?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${exceptionRefInstance?.resolution}">
				<li class="fieldcontain">
					<span id="resolution-label" class="property-label"><g:message code="exceptionRef.resolution.label" default="Resolution" /></span>
					
						<span class="property-value" aria-labelledby="resolution-label"><g:fieldValue bean="${exceptionRefInstance}" field="resolution"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:exceptionRefInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${exceptionRefInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
