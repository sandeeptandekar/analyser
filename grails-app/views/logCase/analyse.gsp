<%@ page import="com.LogCase" %>
<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
        <table border="1">
        <tr>
        <th>Id</th>
        <th>Key</th>
         </tr>

        <g:each in="${smallList}" var="ana">
          <tr>
           <td><g:link action="show" id="${ana.id}">${ana.id}</g:link>
           <td> ${ana.key}</td>
           </tr>
        </g:each>
          </table>  
	</body>
</html>


