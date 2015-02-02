<!DOCTYPE html>

<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'logCase.label', default: 'LogCase')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
      <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.2.min.js"></script>

<uploader:head />
	</head>
	<body>
		<a href="#create-logCase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-logCase" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${logCaseInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${logCaseInstance}" var="error">
				<li> <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form controller="logCase" action="analyse">
				<fieldset class="form">
<g:render template="form"/>

<uploader:uploader id="fileUploader" url="${[controller:'logCase', action:'test']}">
                                           <uploader:onComplete>

    alert('Thank you for uploading the file '+fileName);
console.log(responseJSON);
if(responseJSON.success) {
$('#uploadedFilePath').val(responseJSON.filePath);
}
                                           </uploader:onComplete>
                                           </uploader:uploader>



</fieldSet>
				<fieldset class="buttons">
					
 <g:submitButton name="Analyse" action="analyse" />

				</fieldset>

			</g:form>
		</div>
	</body>
</html>
