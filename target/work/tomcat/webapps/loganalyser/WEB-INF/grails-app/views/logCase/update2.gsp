

<!DOCTYPE html>
<html>
	<head>
<meta name="layout" content="main">
                <g:set var="entityName" value="${message(code: 'logCase.label', default: 'LogCase')}" />
                <title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
<a href="#show-logCase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
                <div class="nav" role="navigation">
                        <ul>
                                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                       <li><g:each in="${black}" var="ana"><g:if test="${ana.key == '0'}"><a href="${ana.value}"> Back</a></g:if></g:each></li>
                        </ul>
                </div>
<div id="show-logCase" class="content scaffold-show" role="main">
<h1>Updated</h1>
<ol class="property-list logCase">
               


       

        <g:each in="${black}" var="ana">
      <g:if test="${ana.key == '1'}">
 <li class="fieldcontain">   

                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="Key" /></span>

                                         <span class="property-value" aria-labelledby="dateCreated-label"><pre>${ana.value}</pre></span>

                          </li>      

          </g:if>


<g:if test="${ana.key == '2'}">
    <li class="fieldcontain">

                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="category" /></span>

                                                <span class="property-value" aria-labelledby="dateCreated-label">${ana.value}</span>

</li>                                

          </g:if>
<g:if test="${ana.key == '3'}">
    <li class="fieldcontain">
                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="description" /></span>

                                                <span class="property-value" aria-labelledby="dateCreated-label">${ana.value}</span>

                                </li>

          </g:if>
<g:if test="${ana.key == '4'}">
    <li class="fieldcontain">
                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="resolution" /></span>

                                                <span class="property-value" aria-labelledby="dateCreated-label">${ana.value}</span>

                                </li>

          </g:if>
<g:if test="${ana.key == '5'}">
    <li class="fieldcontain">
                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="product" /></span>

                                                <span class="property-value" aria-labelledby="dateCreated-label">${ana.value}</span>

                                </li>

          </g:if>










</g:each>

</ol>
   </div>
       
                        
                        

	</body>

</html>



