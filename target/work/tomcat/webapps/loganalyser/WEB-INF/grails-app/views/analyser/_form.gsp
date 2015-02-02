<%@ page import="org.example.Analyser" %>



<div class="fieldcontain ${hasErrors(bean: analyserInstance, field: 'line', 'error')} required">
	<label for="line">
		<g:message code="analyser.line.label" default="Line" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="line" required="" value="${analyserInstance?.line}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: analyserInstance, field: 'frequency', 'error')} required">
	<label for="frequency">
		<g:message code="analyser.frequency.label" default="Frequency" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="frequency" required="" value="${analyserInstance?.frequency}"/>

</div>

