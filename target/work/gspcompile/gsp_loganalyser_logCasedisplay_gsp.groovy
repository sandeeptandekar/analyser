import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCasedisplay_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCase/display.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'logCase.label', default: 'LogCase'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',13,['code':("default.home.label")],-1)
printHtmlPart(8)
for( ana in (result) ) {
if(true && (ana.key =='1')) {
printHtmlPart(9)
for( a in (ana.value) ) {
printHtmlPart(10)
for( i in (a.value) ) {
printHtmlPart(11)
expressionOut.print(i.value)
printHtmlPart(12)
}
printHtmlPart(1)
}
printHtmlPart(13)
}
printHtmlPart(1)
}
printHtmlPart(14)
for( ana in (result) ) {
printHtmlPart(15)
if(true && (ana.key == '0')) {
printHtmlPart(16)
for( a in (ana.value) ) {
for( b in (a.value) ) {
printHtmlPart(17)
for( c in (b.value) ) {
printHtmlPart(17)
expressionOut.print(c)
printHtmlPart(17)
}
}
}
printHtmlPart(18)
}
else {
printHtmlPart(1)
if(true && (ana.key =='1')) {
printHtmlPart(1)
}
else {
printHtmlPart(19)
expressionOut.print(ana.key)
printHtmlPart(20)
for( a in (ana.value) ) {
printHtmlPart(21)
expressionOut.print(a.key)
printHtmlPart(22)
for( i in (a.value) ) {
printHtmlPart(23)
expressionOut.print(i.value)
printHtmlPart(24)
expressionOut.print(i.key)
printHtmlPart(25)
}
printHtmlPart(1)
}
printHtmlPart(26)
}
printHtmlPart(1)
}
printHtmlPart(15)
}
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',83,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422352255000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
