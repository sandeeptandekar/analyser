import com.LogException
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logException_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logException/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: logExceptionInstance, field: 'expContainer', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("logException.expContainer.label"),'default':("Exp Container")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("expContainer"),'name':("expContainer.id"),'from':(com.ExpContainer.list()),'optionKey':("id"),'required':(""),'value':(logExceptionInstance?.expContainer?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: logExceptionInstance, field: 'expRef', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("logException.expRef.label"),'default':("Exp Ref")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("expRef"),'name':("expRef.id"),'from':(com.ExceptionRef.list()),'optionKey':("id"),'required':(""),'value':(logExceptionInstance?.expRef?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: logExceptionInstance, field: 'frequency', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("logException.frequency.label"),'default':("Frequency")],-1)
printHtmlPart(2)
invokeTag('field','g',28,['name':("frequency"),'type':("number"),'value':(logExceptionInstance.frequency),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: logExceptionInstance, field: 'logFilePath', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("logException.logFilePath.label"),'default':("Log File Path")],-1)
printHtmlPart(2)
invokeTag('textField','g',37,['name':("logFilePath"),'required':(""),'value':(logExceptionInstance?.logFilePath)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1419931641000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
