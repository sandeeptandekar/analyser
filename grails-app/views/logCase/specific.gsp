<%@ page import="com.LogCase" %>
<!DOCTYPE html>
<html>
	<head>
<meta name="layout" content="main"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
<g:javascript src="read.js" />

	</head>
	<body>







<g:form name="myform" method="post">
        <table border="1" width="100%" align="center">    
        <tr>
        <th>Id</th>
        <th>date Created</th>
        <th>Last Updated</th>
        <th>Product</th>
<th>Ticket Url</th>
<th>Uploaded File Path</th>
         </tr>

        <g:each in="${result}" var="ana">
          <tr>
           <td>${ana.id}
           <td> ${ana.dateCreated}</td>
           <td> ${ana.lastUpdated}</td>
           <td style= "width: 20%; overflow: hidden;">${ana.product}</td>

           <td>${ana.ticketUrl}</td>
           <td>${ana.uploadedFilePath}</td>
           </tr>
        </g:each>
          </table>


     <g:actionSubmit value="List" action="index" />
</g:form>
	</body>

</html>


