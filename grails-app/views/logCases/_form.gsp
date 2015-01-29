<%@ page import="com.LogCases" %>



<div class="fieldcontain ${hasErrors(bean: logCasesInstance, field: 'ticketUrl', 'error')} ">
	<label for="ticketUrl">
		<g:message code="logCases.ticketUrl.label" default="Ticket Url" />
		
	</label>
	<g:textField name="ticketUrl" value="${logCasesInstance?.ticketUrl}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: logCasesInstance, field: 'product', 'error')} required">
	<label for="product">
		<g:message code="logCases.product.label" default="Product" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="product" name="product.id" from="${com.Product.list()}" optionKey="id" required="" value="${logCasesInstance?.product?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: logCasesInstance, field: 'uploadedFilePath', 'error')} required">
	<label for="uploadedFilePath">
		<g:message code="logCases.uploadedFilePath.label" default="Uploaded File Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="uploadedFilePath" required="" value="${logCasesInstance?.uploadedFilePath}"/>

</div>

