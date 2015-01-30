import com.ExpContainer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_expContainer_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/expContainer/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: expContainerInstance, field: 'logCase', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("expContainer.logCase.label"),'default':("Log Case")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("logCase"),'name':("logCase.id"),'from':(com.LogCase.list()),'optionKey':("id"),'required':(""),'value':(expContainerInstance?.logCase?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: expContainerInstance, field: 'logException', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("expContainer.logException.label"),'default':("Log Exception")],-1)
printHtmlPart(5)
for( l in (expContainerInstance?.logException) ) {
printHtmlPart(6)
createTagBody(2, {->
expressionOut.print(l?.encodeAsHTML())
})
invokeTag('link','g',22,['controller':("logException"),'action':("show"),'id':(l.id)],2)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'logException.label', default: 'LogException')]))
})
invokeTag('link','g',25,['controller':("logException"),'action':("create"),'params':(['expContainer.id': expContainerInstance?.id])],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: expContainerInstance, field: 'title', 'error'))
printHtmlPart(10)
invokeTag('message','g',34,['code':("expContainer.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',37,['name':("title"),'required':(""),'value':(expContainerInstance?.title)],-1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1419931739000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
