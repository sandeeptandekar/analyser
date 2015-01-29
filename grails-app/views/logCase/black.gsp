<%@ page import="com.ExceptionRef" %>
<!DOCTYPE html>
<html>
	<head>
<meta name="layout" content="main">
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
<g:javascript src="read.js" />
<g:set var="entityName" value="${message(code: 'logCase.label', default: 'LogCase')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
<a href="#show-logCase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                                <li><g:each in="${black}" var="ana"><g:if test="${ana.key == '1'}"><a href="${ana.value}"> Back</a></g:if></g:each></li>
</ul>
		</div>
        
<div id="show-logCase" class="content scaffold-show" role="main">
			<h1>Exception with Black category</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>			

<ol class="property-list logCase">

       <g:each in="${black}" var="ana">
       <g:if test="${ana.key =='1'}">
</g:if>
<g:else>   
<ul>
<li class="fieldcontain">           
          <a class="property-value" href=${ana.value}>${ana.key}</a>
           
</li>
</ul>
</g:else>      
        </g:each>
</ol>          
	</body>

</html>


