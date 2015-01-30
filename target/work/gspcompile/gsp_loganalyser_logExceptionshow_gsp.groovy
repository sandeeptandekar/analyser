import com.LogException
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logExceptionshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logException/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('javascript','g',8,['src':("read.js")],-1)
printHtmlPart(2)
invokeTag('set','g',9,['var':("entityName"),'value':(message(code: 'logException.label', default: 'LogException'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',10,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',13,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',16,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',17,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',17,['class':("list"),'action':("index")],2)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('message','g',18,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',18,['class':("create"),'action':("create")],2)
printHtmlPart(10)
invokeTag('message','g',22,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (logExceptionInstance?.expContainer)) {
printHtmlPart(15)
invokeTag('message','g',30,['code':("logException.expContainer.label"),'default':("Folder Name")],-1)
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(logExceptionInstance?.expContainer.title.encodeAsHTML())
})
invokeTag('link','g',32,['controller':("expContainer"),'action':("show"),'id':(logExceptionInstance?.expContainer?.id)],3)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (logExceptionInstance?.expRef)) {
printHtmlPart(19)
invokeTag('message','g',39,['code':("logException.expRef.label"),'default':("Key")],-1)
printHtmlPart(20)
createTagBody(3, {->
expressionOut.print(logExceptionInstance?.expRef.key.encodeAsHTML())
})
invokeTag('link','g',41,['controller':("exceptionRef"),'action':("show"),'id':(logExceptionInstance?.expRef?.id)],3)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (logExceptionInstance?.frequency)) {
printHtmlPart(21)
invokeTag('message','g',48,['code':("logException.frequency.label"),'default':("Frequency")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',50,['bean':(logExceptionInstance),'field':("frequency")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (logExceptionInstance?.logFilePath)) {
printHtmlPart(23)
invokeTag('message','g',57,['code':("logException.logFilePath.label"),'default':("Log File Path")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',59,['bean':(logExceptionInstance),'field':("logFilePath")],-1)
printHtmlPart(17)
}
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
invokeTag('message','g',67,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',67,['class':("edit"),'action':("edit"),'resource':(logExceptionInstance)],3)
printHtmlPart(27)
invokeTag('actionSubmit','g',68,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(28)
})
invokeTag('form','g',70,['url':([resource:logExceptionInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1421931658000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
