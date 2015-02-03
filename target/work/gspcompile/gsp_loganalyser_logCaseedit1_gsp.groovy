import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCaseedit1_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCase/edit1.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
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
for( ana in (hm) ) {
if(true && (ana.key == '1')) {
printHtmlPart(8)
expressionOut.print(ana.value)
printHtmlPart(9)
}
}
printHtmlPart(10)
for( ana in (hm) ) {
if(true && (ana.key == 'ticket')) {
printHtmlPart(8)
expressionOut.print(ana.value)
printHtmlPart(11)
}
}
printHtmlPart(12)
for( ana in (hm) ) {
printHtmlPart(13)
if(true && (ana.key == 'key')) {
printHtmlPart(14)
invokeTag('message','g',32,['code':("logCase.dateCreated.label"),'default':("Key")],-1)
printHtmlPart(15)
expressionOut.print(ana.value)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (ana.key == 'frequency')) {
printHtmlPart(18)
invokeTag('message','g',44,['code':("logCase.dateCreated.label"),'default':("frequency")],-1)
printHtmlPart(19)
expressionOut.print(ana.value)
printHtmlPart(20)
}
printHtmlPart(1)
if(true && (ana.key == 'pproduct')) {
printHtmlPart(21)
invokeTag('message','g',53,['code':("logCase.dateCreated.label"),'default':("product")],-1)
printHtmlPart(19)
expressionOut.print(ana.value)
printHtmlPart(22)
}
printHtmlPart(1)
if(true && (ana.key == 'category')) {
printHtmlPart(21)
invokeTag('message','g',62,['code':("logCase.dateCreated.label"),'default':("case id")],-1)
printHtmlPart(19)
expressionOut.print(ana.value)
printHtmlPart(22)
}
printHtmlPart(1)
if(true && (ana.key == 'resolution')) {
printHtmlPart(21)
invokeTag('message','g',71,['code':("logCase.dateCreated.label"),'default':("Resolution")],-1)
printHtmlPart(19)
expressionOut.print(ana.value)
printHtmlPart(22)
}
printHtmlPart(1)
if(true && (ana.key == 'description')) {
printHtmlPart(21)
invokeTag('message','g',80,['code':("logCase.dateCreated.label"),'default':("description")],-1)
printHtmlPart(19)
expressionOut.print(ana.value)
printHtmlPart(22)
}
printHtmlPart(1)
if(true && (ana.key == 'Folder name')) {
printHtmlPart(21)
invokeTag('message','g',89,['code':("logCase.dateCreated.label"),'default':("Folder")],-1)
printHtmlPart(19)
expressionOut.print(ana.value)
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (ana.key == 'Case id')) {
printHtmlPart(21)
invokeTag('message','g',99,['code':("logCase.dateCreated.label"),'default':("Category")],-1)
printHtmlPart(19)
expressionOut.print(ana.value)
printHtmlPart(22)
}
printHtmlPart(24)
if(true && (ana.key == 'product')) {
printHtmlPart(1)
createTagBody(4, {->
printHtmlPart(25)
expressionOut.print(ana.value)
printHtmlPart(26)
})
invokeTag('form','g',118,[:],4)
printHtmlPart(1)
}
printHtmlPart(27)
}
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',133,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422877359000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
