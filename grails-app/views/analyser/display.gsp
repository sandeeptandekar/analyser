<%@ page import="org.example.Analyser" %>
<!DOCTYPE html>
<html>
	<head>

	</head>
	<body>
        <table border="1" width="100%">    
        <tr>
        <th>Id</th>
        <th>Line</th>
        <th>Frequency</th>
        <th>Stacktrace</th>
<th>File Path</th>
<th>occurence</th>
         </tr>

        <g:each in="${resultList}" var="ana">
          <tr>
           <td><g:link action="show" id="${ana.id}">${ana.id}</g:link>
           <td> ${ana.line}</td>
           <td> ${ana.frequency}</td>
           <td style= "width: 20%; overflow: hidden;">${ana.stack}</td>
           <td>${ana.file}</td>
           <td>${ana.occurence}</td>
           </tr>
        </g:each>
          </table>
	</body>

</html>


