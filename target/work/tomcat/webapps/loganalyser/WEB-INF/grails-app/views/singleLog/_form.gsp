<%@ page import="com.SingleLog" %>



<div class="fieldcontain ${hasErrors(bean: singleLogInstance, field: 'expContainer', 'error')} required">
	<label for="expContainer">
		<g:message code="singleLog.expContainer.label" default="Exp Container" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="expContainer" name="expContainer.id" from="${com.ExpContainer.list()}" optionKey="id" required="" value="${singleLogInstance?.expContainer?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: singleLogInstance, field: 'expRef', 'error')} required">
	<label for="expRef">
		<g:message code="singleLog.expRef.label" default="Exp Ref" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="expRef" name="expRef.id" from="${com.ExceptionRef.list()}" optionKey="id" required="" value="${singleLogInstance?.expRef?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: singleLogInstance, field: 'frequency', 'error')} required">
	<label for="frequency">
		<g:message code="singleLog.frequency.label" default="Frequency" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="frequency" type="number" value="${singleLogInstance.frequency}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: singleLogInstance, field: 'logFilePath', 'error')} required">
	<label for="logFilePath">
		<g:message code="singleLog.logFilePath.label" default="Log File Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="logFilePath" required="" value="${singleLogInstance?.logFilePath}"/>

</div>

