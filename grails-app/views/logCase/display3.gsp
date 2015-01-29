<%@ page import="com.LogCase" %>
<!DOCTYPE html>
<html>
	<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
<g:javascript src="read.js" />

	</head>
	<body style=" background:#9CB071">
<pre>

<center><h2>Detailed Description<h2></center>





<g:form name="myform" method="post">
        <table border="1" width="100%" align="center">    
        <tr>
        <th>Id</th>
        <th>category</th>
        <th>description</th>
        <th>key</th>
<th>product</th>
<th>resolution</th>
         </tr>

        <g:each in="${value}" var="ana">
          <tr>
           <td>${ana.id}
           <td> ${ana.category}</td>
           <td> ${ana.description}</td>
           <td style= "width: 20%; overflow: hidden;" class="property-value">${ana.key}
</td>

           <td>${ana.product}</td>
           <td>${ana.resolution}</td>
           </tr>
        </g:each>
          </table>


     <g:actionSubmit value="List" action="index" />
</g:form>

<pre>	</body>

</html>


