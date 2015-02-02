<%@ page import="com.Analyser" %>



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
	<g:field name="frequency" type="number" value="${analyserInstance.frequency}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: analyserInstance, field: 'file', 'error')} required">
	<label for="file">
		<g:message code="analyser.file.label" default="File" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="file" required="" value="${analyserInstance?.file}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: analyserInstance, field: 'occurence', 'error')} required">
	<label for="occurence">
		<g:message code="analyser.occurence.label" default="Occurence" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="occurence" required="" value="${analyserInstance?.occurence}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: analyserInstance, field: 'stack', 'error')} required">
	<label for="stack">
		<g:message code="analyser.stack.label" default="Stack" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="stack" required="" value="${analyserInstance?.stack}"/>

</div>

