
<!DOCTYPE html>
<html>
	<head>
<meta name="layout" content="main">
	</head>
	<body>

 <g:each in="${flName}" var="ana">
           <table border="1" width="100%">    
        <tr>
        <th>Folder</th>
        <th>Red</th>
        <th>Green</th>
        <th>Black</th>
         </tr> <tr>
           <td>${ana.key} </td>
           <g:each in="${ana.value}" var="a">
             <td>   
                <g:set var="counter" value="${1}" />            
  <g:each in="${a.value}" var="i">
    <g:set var="counter" value="${counter + 1}" />
<g:if test="${(counter % 2)==0}">
<a href="${i}">${i}</a>
<g:set var="counter" value="${counter +1}" />
</g:if>
  </g:each>
</g:each>      
    </td>
           </tr>
        </table>
</g:each>
</pre>
	</body>

</html>


