import com.LogCase
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCaseindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCase/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'logCase.label', default: 'LogCase'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',28,['property':("id"),'defaultOrder':("desc"),'title':(message(code: 'logCase.id.label', default: 'Case id'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',30,['property':("dateCreated"),'defaultOrder':("desc"),'title':(message(code: 'logCase.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',32,['property':("lastUpdated"),'title':(message(code: 'logCase.lastUpdated.label', default: 'Last Updated')),'defaultOrder':("desc")],-1)
printHtmlPart(14)
invokeTag('message','g',34,['code':("logCase.product.label"),'default':("Product")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',36,['property':("ticketUrl"),'title':(message(code: 'logCase.ticketUrl.label', default: 'Ticket Url')),'defaultOrder':("desc")],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',38,['property':("uploadedFilePath"),'title':(message(code: 'logCase.uploadedFilePath.label', default: 'Uploaded File Path')),'defaultOrder':("desc")],-1)
printHtmlPart(16)
loop:{
int i = 0
for( logCaseInstance in (logCaseInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(logCaseInstance.id)
})
invokeTag('link','g',46,['action':("page1"),'id':(logCaseInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: logCaseInstance, field: "dateCreated"))
printHtmlPart(20)
invokeTag('formatDate','g',49,['date':(logCaseInstance.lastUpdated)],-1)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: logCaseInstance, field: "product"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: logCaseInstance, field: "ticketUrl"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: logCaseInstance, field: "uploadedFilePath"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',62,['total':(logCaseInstanceCount ?: 0)],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422529897000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
