<%@ page import="com.Analyser" %>
<!DOCTYPE html>
<html>
<head>

  <r:require module="fileuploader" />
  <r:layoutResources />


</head>
<body>


<g:form method="post"  role="form">
<fieldset id="center">
<pre>
          <div class="container">
          <div class="jumbotron">
          <h1>Log Analyser</h1>
          </div>

            



           <div class="col-sm-4">
           <label>Product </label>
                                           <select name="haircolor">
                                           <option value="1">Select a product</option>
                                           <option value="2">Genespring</option>
                                           <option value="3">Ngs</option>
                                           </select>

           



          <label>Ticket link </label>
                                           <g:textField name="ticket"/><br/>

           


                                                
           
                                           <uploader:uploader id="fileUploader" url="${[controller:'analyser', action:'test']}">
                                           <uploader:onComplete>
    
    alert('Thank you for uploading the file '+fileName); 
console.log(responseJSON);
if(responseJSON.success) {
$('#path').val(responseJSON.filePath);
} 
                                           </uploader:onComplete>
                                           </uploader:uploader>

            <input type="hidden" name="Filepath" id="path">
               


                                           <g:actionSubmit value="Analyse"action="analyse"/>

                                       
                                          
                                           
       

</pre>
</div>
</fieldset>
</g:form>
</body>
</html>






