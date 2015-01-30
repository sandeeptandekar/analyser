import com.LogCase
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCaseshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCase/show.gsp" }
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
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
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
invokeTag('message','g',12,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',15,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',17,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',17,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',21,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (logCaseInstance?.dateCreated)) {
printHtmlPart(14)
invokeTag('message','g',29,['code':("logCase.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',31,['date':(logCaseInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (logCaseInstance?.expContainer)) {
printHtmlPart(18)
invokeTag('message','g',39,['code':("logCase.expContainer.label"),'default':("Exp Container")],-1)
printHtmlPart(19)
for( e in (logCaseInstance.expContainer) ) {
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(e.title.encodeAsHTML())
})
invokeTag('link','g',42,['controller':("expContainer"),'action':("show"),'id':(e.id)],4)
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (logCaseInstance?.lastUpdated)) {
printHtmlPart(24)
invokeTag('message','g',49,['code':("logCase.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(25)
invokeTag('formatDate','g',51,['date':(logCaseInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(26)
if(true && (logCaseInstance?.product)) {
printHtmlPart(27)
invokeTag('message','g',58,['code':("logCase.product.label"),'default':("Product")],-1)
printHtmlPart(28)
createTagBody(3, {->
expressionOut.print(logCaseInstance?.product?.encodeAsHTML())
})
invokeTag('link','g',60,['controller':("product"),'action':("show"),'id':(logCaseInstance?.product?.id)],3)
printHtmlPart(16)
}
printHtmlPart(29)
if(true && (logCaseInstance?.ticketUrl)) {
printHtmlPart(30)
invokeTag('message','g',69,['code':("logCase.ticketUrl.label"),'default':("Ticket Url")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',71,['bean':(logCaseInstance),'field':("ticketUrl")],-1)
printHtmlPart(16)
}
printHtmlPart(26)
if(true && (logCaseInstance?.uploadedFilePath)) {
printHtmlPart(32)
invokeTag('message','g',78,['code':("logCase.uploadedFilePath.label"),'default':("Uploaded File Path")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',80,['bean':(logCaseInstance),'field':("uploadedFilePath")],-1)
printHtmlPart(16)
}
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(35)
createTagBody(3, {->
invokeTag('message','g',88,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',88,['class':("edit"),'action':("edit"),'resource':(logCaseInstance)],3)
printHtmlPart(36)
invokeTag('actionSubmit','g',89,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(37)
})
invokeTag('form','g',91,['url':([resource:logCaseInstance, action:'delete']),'method':("delete")],2)
printHtmlPart(38)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(39)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1421993435000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
