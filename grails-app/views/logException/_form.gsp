<%@ page import="com.LogException" %>



<div class="fieldcontain ${hasErrors(bean: logExceptionInstance, field: 'expContainer', 'error')} required">
	<label for="expContainer">
		<g:message code="logException.expContainer.label" default="Exp Container" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="expContainer" name="expContainer.id" from="${com.ExpContainer.list()}" optionKey="id" required="" value="${logExceptionInstance?.expContainer?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: logExceptionInstance, field: 'expRef', 'error')} required">
	<label for="expRef">
		<g:message code="logException.expRef.label" default="Exp Ref" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="expRef" name="expRef.id" from="${com.ExceptionRef.list()}" optionKey="id" required="" value="${logExceptionInstance?.expRef?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: logExceptionInstance, field: 'frequency', 'error')} required">
	<label for="frequency">
		<g:message code="logException.frequency.label" default="Frequency" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="frequency" type="number" value="${logExceptionInstance.frequency}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: logExceptionInstance, field: 'logFilePath', 'error')} required">
	<label for="logFilePath">
		<g:message code="logException.logFilePath.label" default="Log File Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="logFilePath" required="" value="${logExceptionInstance?.logFilePath}"/>

</div>

