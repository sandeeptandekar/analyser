
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

<li><g:each in="${result}" var="ana"><g:if test="${ana.key =='1'}">



             <g:each in="${ana.value}" var="a">

      

  <g:each in="${a.value}" var="i"> 
     <span id="name" class="property-value"><a href="${i.value}">Ticket Url</a></span>
  </g:each>
</g:each>
    
    
</g:if>
</g:each>
                                </li>
                        </ul>
                </div>
<div id="show-logCase" class="content scaffold-show" role="main">
			<h1>Summary</h1>
 <g:each in="${result}" var="ana">

<g:if test="${ana.key == '0'}">
<ol class="property-list logCase">
<ul>
<li class="fieldcontain">
 <span id="name" class="property-label"> Case Id</span>
                                        <span id="name" class="property-value"><g:each in="${ana.value}" var="a"><g:each in="${a.value}" var="b"><g:each in=" ${b.value}" var="c">${c}</g:each></g:each></g:each></span>
</li>
</ul>
</ol>
</g:if>
        
<g:else>
<g:if test="${ana.key =='1'}">
</g:if>
<g:else>
<fieldSet class="label">

 <span id="name" class="property-label">${ana.key}</span>
</fieldSet>
           <table border="1" width="100%">  

</tr>    
             <th>Category</th>
             <th>Count</th>
</tr>

           
           
             <g:each in="${ana.value}" var="a">
<tr>
<td>${a.key}</td>   
               <td> <g:set var="counter" value="${1}" />            
  <g:each in="${a.value}" var="i">
    <a href="${i.value}">${i.key}</a>
  </g:each>
</g:each>      
    </td>
           </tr>

        </table>
</g:else>
</g:else>
</g:each>
</pre>
	</body>

</html>




