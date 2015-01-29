
<!DOCTYPE html>
<html>
	<head>
<meta name="layout" content="main">
	</head>
	<body>
<g:form>
        <table border="1" width="100%">    

        <tr>
      
        <th>ExpRefId</th>
        <th>value</th>
         </tr>

        <g:each in="${hm}" var="ana">

<g:if test="{ana.key == 'ledit'}">
<span class="property-value" aria-labelledby="product-label"><a href="${ana.value}" > Edit </a></span>
</g:if>


<g:else>
      
          <tr>
           <td>${ana.key}</td>
           <td> ${ana.value}</td>
           
       </tr>
        
          

</g:else>
</g:each>
</table>

          
                        </g:form>
                        

	</body>

</html>


