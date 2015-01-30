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
printHtmlPart(11)
if(true && (ana.key == 'key')) {
printHtmlPart(12)
invokeTag('message','g',30,['code':("logCase.dateCreated.label"),'default':("Key")],-1)
printHtmlPart(13)
expressionOut.print(ana.value)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (ana.key == 'frequency')) {
printHtmlPart(16)
invokeTag('message','g',42,['code':("logCase.dateCreated.label"),'default':("frequency")],-1)
printHtmlPart(17)
expressionOut.print(ana.value)
printHtmlPart(18)
}
printHtmlPart(1)
if(true && (ana.key == 'pproduct')) {
printHtmlPart(19)
invokeTag('message','g',51,['code':("logCase.dateCreated.label"),'default':("product")],-1)
printHtmlPart(17)
expressionOut.print(ana.value)
printHtmlPart(20)
}
printHtmlPart(1)
if(true && (ana.key == 'category')) {
printHtmlPart(19)
invokeTag('message','g',60,['code':("logCase.dateCreated.label"),'default':("case id")],-1)
printHtmlPart(17)
expressionOut.print(ana.value)
printHtmlPart(20)
}
printHtmlPart(1)
if(true && (ana.key == 'resolution')) {
printHtmlPart(19)
invokeTag('message','g',69,['code':("logCase.dateCreated.label"),'default':("Resolution")],-1)
printHtmlPart(17)
expressionOut.print(ana.value)
printHtmlPart(20)
}
printHtmlPart(1)
if(true && (ana.key == 'description')) {
printHtmlPart(19)
invokeTag('message','g',78,['code':("logCase.dateCreated.label"),'default':("description")],-1)
printHtmlPart(17)
expressionOut.print(ana.value)
printHtmlPart(20)
}
printHtmlPart(1)
if(true && (ana.key == 'Folder name')) {
printHtmlPart(19)
invokeTag('message','g',87,['code':("logCase.dateCreated.label"),'default':("Folder")],-1)
printHtmlPart(17)
expressionOut.print(ana.value)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (ana.key == 'Case id')) {
printHtmlPart(19)
invokeTag('message','g',97,['code':("logCase.dateCreated.label"),'default':("Category")],-1)
printHtmlPart(17)
expressionOut.print(ana.value)
printHtmlPart(20)
}
printHtmlPart(22)
if(true && (ana.key == 'product')) {
printHtmlPart(1)
createTagBody(4, {->
printHtmlPart(23)
expressionOut.print(ana.value)
printHtmlPart(24)
})
invokeTag('form','g',116,[:],4)
printHtmlPart(1)
}
printHtmlPart(25)
}
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',131,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422513524000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
