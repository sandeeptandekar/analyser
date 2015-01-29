<%@ page import="org.example.Analyser" %>
<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>

      <center> Display of Single row</center>   
<g:form name="myform" method="post">
<pre>

        <g:each in="${showPage}" var="ana">
          
   Frequency  =       ${ana.frequency}



   Line       =       ${ana.line}
 

   Stacktrace  =      ${ana.stack}
    
   
   File Path   =       ${ana.file}

   
   Occurence   =       ${ana.occurence}
           
        </g:each>
     </pre>
 <g:actionSubmit value="Home" action="home" />
  <g:actionSubmit value="List" action="list" />
</g:form>  
	</body>
</html>



