<%@ page import="org.example.Analyser" %>
<!DOCTYPE html>
<html>
	<head>
<meta name="layout" content="main">
	</head>
	<body>
        <table border="1" width="100%">    

        <tr>
      
        <th>ExpRefId</th>
        
         </tr>

        <g:each in="${flName}" var="ana">
          <tr>
           <td>${ana.key}</td>
           <td><a href=${ana.value}>${ana.value}</a></td>
           
       </tr>
        </g:each>
          </table>
	</body>

</html>


