import com.LogCase
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCase_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCase/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: logCaseInstance, field: 'product', 'error'))
printHtmlPart(1)
invokeTag('message','g',12,['code':("logCase.product.label"),'default':("Product")],-1)
printHtmlPart(2)
invokeTag('select','g',15,['id':("product"),'name':("product.id"),'from':(com.Product.list()),'optionKey':("id"),'required':(""),'value':(logCaseInstance?.product?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: logCaseInstance, field: 'ticketUrl', 'error'))
printHtmlPart(4)
invokeTag('message','g',21,['code':("logCase.ticketUrl.label"),'default':("Ticket Url")],-1)
printHtmlPart(2)
invokeTag('textField','g',24,['name':("ticketUrl"),'required':(""),'value':(logCaseInstance?.ticketUrl)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: logCaseInstance, field: 'uploadedFilePath', 'error'))
printHtmlPart(5)
invokeTag('message','g',30,['code':("logCase.uploadedFilePath.label"),'default':("Uploaded File Path")],-1)
printHtmlPart(2)
invokeTag('textField','g',33,['name':("uploadedFilePath"),'required':(""),'value':(logCaseInstance?.uploadedFilePath)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',36,['name':("path"),'required':(""),'value':(logCaseInstance?.uploadedFilePath)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1423150046000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
