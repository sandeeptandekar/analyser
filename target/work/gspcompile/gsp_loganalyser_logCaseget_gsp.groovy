import com.LogCase
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCaseget_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCase/get.gsp" }
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
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (logCaseInstance?.dateCreated)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("logCase.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',30,['date':(logCaseInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (logCaseInstance?.expContainer)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("logCase.expContainer.label"),'default':("Exp Container")],-1)
printHtmlPart(19)
for( e in (logCaseInstance.expContainer) ) {
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(e.title.encodeAsHTML())
})
invokeTag('link','g',40,['controller':("expContainer"),'action':("show"),'id':(e.id)],4)
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(17)
if(true && (logCaseInstance?.lastUpdated)) {
printHtmlPart(23)
invokeTag('message','g',48,['code':("logCase.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(24)
invokeTag('formatDate','g',50,['date':(logCaseInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (logCaseInstance?.product)) {
printHtmlPart(25)
invokeTag('message','g',57,['code':("logCase.product.label"),'default':("Product")],-1)
printHtmlPart(26)
createTagBody(3, {->
expressionOut.print(logCaseInstance?.product?.encodeAsHTML())
})
invokeTag('link','g',59,['controller':("product"),'action':("show"),'id':(logCaseInstance?.product?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (logCaseInstance?.ticketUrl)) {
printHtmlPart(27)
invokeTag('message','g',66,['code':("logCase.ticketUrl.label"),'default':("Ticket Url")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',68,['bean':(logCaseInstance),'field':("ticketUrl")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (logCaseInstance?.uploadedFilePath)) {
printHtmlPart(29)
invokeTag('message','g',75,['code':("logCase.uploadedFilePath.label"),'default':("Uploaded File Path")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',77,['bean':(logCaseInstance),'field':("uploadedFilePath")],-1)
printHtmlPart(16)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',85,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',85,['class':("edit"),'action':("edit"),'resource':(logCaseInstance)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',86,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(0)
invokeTag('actionSubmit','g',87,['action':("page"),'class':("show"),'value':("Summary")],-1)
printHtmlPart(34)
})
invokeTag('form','g',87,['url':([resource:logCaseInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',90,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1421672843000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
