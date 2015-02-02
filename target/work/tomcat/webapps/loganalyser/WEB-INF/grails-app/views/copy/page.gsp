
<!DOCTYPE html>
<html>
        <head>
<meta name="layout" content="main">
        </head>
        <body>

<g:form name="my" method="post"> 


           <table border="1" width="100%">
        <tr>
        <th>Category</th>
        <th>count</th>
</tr>

 <g:each in="${result}" var="a">
         <tr>
          <td>${a.key} </td>
           <td>${a.value}</td>
</tr>
</g:each>
   
           
        </table>


<g:actionSubmit value="list" action="index"/>

</g:form>

</pre>

        </body>

</html>


