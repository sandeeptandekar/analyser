import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_copydisplay_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/copy/display.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
for( ana in (flName) ) {
printHtmlPart(4)
expressionOut.print(ana.key)
printHtmlPart(5)
for( a in (ana.value) ) {
printHtmlPart(6)
invokeTag('set','g',20,['var':("counter"),'value':(1)],-1)
printHtmlPart(7)
for( i in (a.value) ) {
printHtmlPart(8)
invokeTag('set','g',22,['var':("counter"),'value':(counter + 1)],-1)
printHtmlPart(1)
if(true && ((counter % 2)==0)) {
printHtmlPart(9)
expressionOut.print(i)
printHtmlPart(10)
expressionOut.print(i)
printHtmlPart(11)
invokeTag('set','g',25,['var':("counter"),'value':(counter +1)],-1)
printHtmlPart(1)
}
printHtmlPart(12)
}
printHtmlPart(1)
}
printHtmlPart(13)
}
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',34,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1421674246000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
