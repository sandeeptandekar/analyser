<%@ page import="org.example.Analyser" %>
<!DOCTYPE html>
<html>
<head>
<uploader:head />
<body>
<g:form name="myform" method="post" >
<pre>
<label>Product </label>
                                         <g:radio name="mygroup" value="Genespring"/>Genespring
                                         <g:radio name="mygroup" value="Ngs4"/>Ngs4<br/>

           



           <label>Ticket link </label>
                                          <g:textField name="ticket"/><br/>

           


                                                
           
<uploader:uploader id="fileupload" url="${[controller:'analyser', action:'store']}">

<uploader:onSubmit> alert('file' + fileName + 'uploaded'); </uploader:onSubmit>

</uploader:uploader>

                                            <g:actionSubmit value="Save"action="index"/>
       

</pre>
</g:form>

</body>
</html>





