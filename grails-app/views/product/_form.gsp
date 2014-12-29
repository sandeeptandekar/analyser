<%@ page import="com.Product" %>



<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="product.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${productInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'productVersion', 'error')} required">
	<label for="productVersion">
		<g:message code="product.productVersion.label" default="Product Version" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="productVersion" required="" value="${productInstance?.productVersion}"/>

</div>

