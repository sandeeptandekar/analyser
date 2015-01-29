<%@ page import="com.ExpContainer" %>



<div class="fieldcontain ${hasErrors(bean: expContainerInstance, field: 'logCase', 'error')} required">
	<label for="logCase">
		<g:message code="expContainer.logCase.label" default="Log Case" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="logCase" name="logCase.id" from="${com.LogCase.list()}" optionKey="id" required="" value="${expContainerInstance?.logCase?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: expContainerInstance, field: 'logException', 'error')} ">
	<label for="logException">
		<g:message code="expContainer.logException.label" default="Log Exception" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${expContainerInstance?.logException?}" var="l">
    <li><g:link controller="logException" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="logException" action="create" params="['expContainer.id': expContainerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'logException.label', default: 'LogException')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: expContainerInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="expContainer.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${expContainerInstance?.title}"/>

</div>

