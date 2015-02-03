

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
                       <li><g:each in="${hm}" var="ana"><g:if test="${ana.key == '1'}"><a href="${ana.value}"> Back</a></g:if></g:each></li>
  <li><g:each in="${hm}" var="ana"><g:if test="${ana.key == 'ticket'}"><a href="${ana.value}"> Ticket Url</a></g:if></g:each></li>

                        </ul>
                </div>
<div id="show-logCase" class="content scaffold-show" role="main">

<ol class="property-list logCase">
               


       

        <g:each in="${hm}" var="ana">
      <g:if test="${ana.key == 'key'}">
 <li class="fieldcontain">   

                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="Key" /></span>

                                         <span class="property-value" aria-labelledby="dateCreated-label"><pre>${ana.value}</pre></span>

                          </li>      

          </g:if>


<g:if test="${ana.key == 'frequency'}">
    <li class="fieldcontain">

                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="frequency" /></span>

                                                <span class="property-value" aria-labelledby="dateCreated-label">${ana.value}</span>

</li>                                

          </g:if>
<g:if test="${ana.key == 'pproduct'}">
    <li class="fieldcontain">
                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="product" /></span>

                                                <span class="property-value" aria-labelledby="dateCreated-label">${ana.value}</span>

                                </li>

          </g:if>
<g:if test="${ana.key == 'category'}">
    <li class="fieldcontain">
                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="case id" /></span>

                                                <span class="property-value" aria-labelledby="dateCreated-label">${ana.value}</span>

                                </li>

          </g:if>
<g:if test="${ana.key == 'resolution'}">
    <li class="fieldcontain">
                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="Resolution" /></span>

                                                <span class="property-value" aria-labelledby="dateCreated-label">${ana.value}</span>

                                </li>

          </g:if>
<g:if test="${ana.key == 'description'}">
    <li class="fieldcontain">
                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="description" /></span>

                                                <span class="property-value" aria-labelledby="dateCreated-label">${ana.value}</span>

                                </li>

          </g:if>
<g:if test="${ana.key == 'Folder name'}">
    <li class="fieldcontain">
                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="Folder" /></span>

                                                <span class="property-value" aria-labelledby="dateCreated-label">${ana.value}</span>

                                </li>

          </g:if>

<g:if test="${ana.key == 'Case id'}">
    <li class="fieldcontain">
                                        <span id="dateCreated-label" class="property-label"><g:message code="logCase.dateCreated.label" default="Category" /></span>

                                                <span class="property-value" aria-labelledby="dateCreated-label">${ana.value}</span>

                                </li>

          </g:if>




<g:if test="${ana.key == 'product'}">
<g:form>
<div class="message" role="status">

 <span class="property-value" aria-labelledby="dateCreated-label"><a href="${ana.value}"> Edit </a>
</span>

</div>
</g:form>
</g:if>





</g:each>

</ol>
   </div>
       
                        
                        

	</body>

</html>



