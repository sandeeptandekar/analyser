import com.Analyser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_analyser_Untitled_Folder_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/analyser/Untitled Folder/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: analyserInstance, field: 'line', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("analyser.line.label"),'default':("Line")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("line"),'required':(""),'value':(analyserInstance?.line)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: analyserInstance, field: 'frequency', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("analyser.frequency.label"),'default':("Frequency")],-1)
printHtmlPart(2)
invokeTag('field','g',19,['name':("frequency"),'type':("number"),'value':(analyserInstance.frequency),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: analyserInstance, field: 'file', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("analyser.file.label"),'default':("File")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("file"),'required':(""),'value':(analyserInstance?.file)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: analyserInstance, field: 'occurence', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("analyser.occurence.label"),'default':("Occurence")],-1)
printHtmlPart(2)
invokeTag('textField','g',37,['name':("occurence"),'required':(""),'value':(analyserInstance?.occurence)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: analyserInstance, field: 'stack', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("analyser.stack.label"),'default':("Stack")],-1)
printHtmlPart(2)
invokeTag('textField','g',46,['name':("stack"),'required':(""),'value':(analyserInstance?.stack)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1419921837000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
