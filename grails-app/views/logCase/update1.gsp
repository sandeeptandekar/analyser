<%@ page import="com.ExceptionRef" %>
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
 <li><g:each in="${black}" var="ana"><g:if test="${ana.key == 'ticket'}"><a href="${ana.value}"> Ticket Url</a></g:if></g:each></li>
                       
 </ul>
                </div>
<div id="show-logCase" class="content scaffold-show" role="main">

<ol class="property-list logCase">

               

<g:form method="PUT">
<table>
       

        <g:each in="${black}" var="ana">
      <g:if test="${ana.key == '1'}">
 <tr>

 <td>Key</td>

 <td>${ana.value}
</td>
                          </tr>      

          </g:if>


<g:if test="${ana.key == '2'}">
    <tr>

    <td>Product</td>
 <td>${ana.value}</td>
                                                

</tr>                                

          </g:if>
<g:if test="${ana.key == '3'}">
    <tr>
<td> Category</td>
                                                <td> <g:select id="category" name="category" from="${ExceptionRef.fetchAllCategory()}"  required="" value="${ana.value}" class="many-to-one"/>
</td>
                                </tr>

          </g:if>
<g:if test="${ana.key == '4'}">
    
     <tr>
<td>Description</td>

        <td>                                        <g:textArea  id="description" name="description" required="" value="${ana.value}"/></td>


                                </tr>

          </g:if>
<g:if test="${ana.key == '5'}">
    <tr>
    <td>resolution</td>          

                                               <td>  <g:textField  id="resolution" name="resolution" required="" value="${ana.value}"/></td>

                                </tr>

          </g:if>

<g:if test="${ana.key == '6'}">
    <li class="fieldcontain">
                                        
                                                <g:hiddenField  id="caseId" name="caseId" required="" value="${ana.value}"/>

                                </li>

          </g:if>

<g:if test="${ana.key == '7'}">
    <li class="fieldcontain">
                                        

                                                <g:hiddenField  id="ref" name="ref" required="" value="${ana.value}"/>

                                </li>

          </g:if>














</g:each>
</table>
</fieldSet>
<fieldset class="buttons">
<g:actionSubmit class="delete" action="update2" value="update"  />
</fieldSet>

</g:form>
</ol>
   </div>
       
                        
                        

	</body>

</html>



