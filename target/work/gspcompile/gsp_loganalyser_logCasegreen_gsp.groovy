import org.example.Analyser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCasegreen_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCase/green.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','g',8,['src':("read.js")],-1)
printHtmlPart(1)
invokeTag('set','g',9,['var':("entityName"),'value':(message(code: 'logCase.label', default: 'LogCase'))],-1)
printHtmlPart(3)
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
for( ana in (black) ) {
if(true && (ana.key == '1')) {
printHtmlPart(9)
expressionOut.print(ana.value)
printHtmlPart(10)
}
}
printHtmlPart(11)
for( ana in (black) ) {
if(true && (ana.key == 'ticket')) {
printHtmlPart(9)
expressionOut.print(ana.value)
printHtmlPart(12)
}
}
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
for( ana in (black) ) {
printHtmlPart(1)
if(true && (ana.key =='1')) {
printHtmlPart(1)
}
else {
printHtmlPart(17)
if(true && (ana.key =='ticket')) {
printHtmlPart(1)
}
else {
printHtmlPart(18)
expressionOut.print(ana.value)
printHtmlPart(19)
expressionOut.print(ana.key)
printHtmlPart(20)
}
printHtmlPart(1)
}
printHtmlPart(21)
}
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',47,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422877013000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
