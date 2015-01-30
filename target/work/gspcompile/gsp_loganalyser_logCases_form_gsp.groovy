import com.LogCases
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCases_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCases/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: logCasesInstance, field: 'ticketUrl', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("logCases.ticketUrl.label"),'default':("Ticket Url")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("ticketUrl"),'value':(logCasesInstance?.ticketUrl)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: logCasesInstance, field: 'product', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("logCases.product.label"),'default':("Product")],-1)
printHtmlPart(5)
invokeTag('select','g',19,['id':("product"),'name':("product.id"),'from':(com.Product.list()),'optionKey':("id"),'required':(""),'value':(logCasesInstance?.product?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: logCasesInstance, field: 'uploadedFilePath', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("logCases.uploadedFilePath.label"),'default':("Uploaded File Path")],-1)
printHtmlPart(5)
invokeTag('textField','g',28,['name':("uploadedFilePath"),'required':(""),'value':(logCasesInstance?.uploadedFilePath)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1421900491000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
