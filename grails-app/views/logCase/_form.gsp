<%@ page import="com.LogCase" %>



<div class="fieldcontain ${hasErrors(bean: logCaseInstance, field: 'expContainer', 'error')} ">
	<label for="expContainer">
		<g:message code="logCase.expContainer.label" default="Exp Container" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${logCaseInstance?.expContainer?}" var="e">
    <li><g:link controller="expContainer" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="expContainer" action="create" params="['logCase.id': logCaseInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'expContainer.label', default: 'ExpContainer')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: logCaseInstance, field: 'product', 'error')} required">
	<label for="product">
		<g:message code="logCase.product.label" default="Product" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="product" name="product.id" from="${com.Product.list()}" optionKey="id" required="" value="${logCaseInstance?.product?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: logCaseInstance, field: 'ticketUrl', 'error')} required">
	<label for="ticketUrl">
		<g:message code="logCase.ticketUrl.label" default="Ticket Url" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ticketUrl" required="" value="${logCaseInstance?.ticketUrl}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: logCaseInstance, field: 'uploadedFilePath', 'error')} required">
	<label for="uploadedFilePath">
		<g:message code="logCase.uploadedFilePath.label" default="Uploaded File Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="uploadedFilePath" required="" value="${logCaseInstance?.uploadedFilePath}"/>

</div>

