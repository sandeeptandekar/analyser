<%@ page import="com.ExceptionRef" %>

<table>
<tr>
<td>
	Description
</td>
<td>	<g:textField name="description" required="" value="${exceptionRefInstance?.description}"/>

</td>
<tr>
<tr>
<td>Category</td>

<td><g:select id="category" name="category" from="${ExceptionRef.fetchAllCategory()}"  required="" value="${exceptionRefInstance?.category}" class="many-to-one"/>
</td>
<tr>
<tr>
<td>	
Key</td>
<td>${exceptionRefInstance?.key}
	
</td>
</tr>


<tr>
	<td>Product</td>
	<td><g:select id="product" name="product.id" from="${com.Product.list()}" optionKey="id" required="" value="${exceptionRefInstance?.product?.id}" class="many-to-one"/></td>

</tr>

<tr>
	<td>Resolution</td>
	<td><g:textField name="resolution" required="" value="${exceptionRefInstance?.resolution}"/>

</td>
</tr>
</table>

