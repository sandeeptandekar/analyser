import com.ExceptionRef
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_exceptionRefshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/exceptionRef/show.gsp" }
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
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'exceptionRef.label', default: 'ExceptionRef'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',9,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',12,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',15,['code':("default.home.label")],-1)
printHtmlPart(8)
for( c in (id2) ) {
createClosureForHtmlPart(9, 3)
invokeTag('link','g',16,['action':("summary"),'id':(c.value)],3)
}
printHtmlPart(10)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (exceptionRefInstance?.category)) {
printHtmlPart(15)
invokeTag('message','g',28,['code':("exceptionRef.category.label"),'default':("Category")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',30,['bean':(exceptionRefInstance),'field':("category")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (exceptionRefInstance?.description)) {
printHtmlPart(19)
invokeTag('message','g',37,['code':("exceptionRef.description.label"),'default':("Description")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',39,['bean':(exceptionRefInstance),'field':("description")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (exceptionRefInstance?.key)) {
printHtmlPart(21)
invokeTag('message','g',46,['code':("exceptionRef.key.label"),'default':("Key")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',48,['bean':(exceptionRefInstance),'field':("key")],-1)
printHtmlPart(23)
}
printHtmlPart(18)
if(true && (exceptionRefInstance?.product)) {
printHtmlPart(24)
invokeTag('message','g',55,['code':("exceptionRef.product.label"),'default':("Product")],-1)
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(exceptionRefInstance?.product?.encodeAsHTML())
})
invokeTag('link','g',57,['controller':("product"),'action':("show"),'id':(exceptionRefInstance?.product?.id)],3)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (exceptionRefInstance?.resolution)) {
printHtmlPart(26)
invokeTag('message','g',64,['code':("exceptionRef.resolution.label"),'default':("Resolution")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',66,['bean':(exceptionRefInstance),'field':("resolution")],-1)
printHtmlPart(17)
}
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createTagBody(3, {->
invokeTag('message','g',74,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',74,['class':("edit"),'action':("edit"),'resource':(exceptionRefInstance)],3)
printHtmlPart(30)
invokeTag('actionSubmit','g',75,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(31)
})
invokeTag('form','g',77,['url':([resource:exceptionRefInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422446449000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
