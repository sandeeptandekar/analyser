import com.LogCase
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCasecurrent_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCase/current.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'logCase.label', default: 'LogCase'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',13,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',18,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('message','g',25,['code':("logCase.id.label"),'default':("Case id")],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("dateCreated"),'title':(message(code: 'logCase.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',31,['property':("lastUpdated"),'title':(message(code: 'logCase.lastUpdated.label', default: 'Last Updated'))],-1)
printHtmlPart(15)
invokeTag('message','g',33,['code':("logCase.product.label"),'default':("Product")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',35,['property':("ticketUrl"),'title':(message(code: 'logCase.ticketUrl.label', default: 'Ticket Url'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',37,['property':("uploadedFilePath"),'title':(message(code: 'logCase.uploadedFilePath.label', default: 'Uploaded File Path'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( logCaseInstance in (smallList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
expressionOut.print(fieldValue(bean: logCaseInstance, field: "id"))
printHtmlPart(20)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: logCaseInstance, field: "dateCreated"))
})
invokeTag('link','g',46,['action':("show"),'id':(logCaseInstance.id)],3)
printHtmlPart(21)
invokeTag('formatDate','g',48,['date':(logCaseInstance.lastUpdated)],-1)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: logCaseInstance, field: "product"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: logCaseInstance, field: "ticketUrl"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: logCaseInstance, field: "uploadedFilePath"))
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',61,['total':(logCaseInstanceCount ?: 0)],-1)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',64,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1420205429000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
