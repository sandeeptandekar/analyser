import org.example.Analyser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_analyserdisplay_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/analyser/display.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
for( ana in (resultList) ) {
printHtmlPart(4)
createTagBody(3, {->
expressionOut.print(ana.id)
})
invokeTag('link','g',20,['action':("show"),'id':(ana.id)],3)
printHtmlPart(5)
expressionOut.print(ana.line)
printHtmlPart(6)
expressionOut.print(ana.frequency)
printHtmlPart(7)
expressionOut.print(ana.stack)
printHtmlPart(8)
expressionOut.print(ana.file)
printHtmlPart(8)
expressionOut.print(ana.occurence)
printHtmlPart(9)
}
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',29,[:],1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1419242770000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
