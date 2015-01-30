import org.example.Analyser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_analyseranalyse_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/analyser/analyse.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('captureHead','sitemesh',5,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
for( ana in (smallList) ) {
printHtmlPart(3)
createTagBody(3, {->
expressionOut.print(ana.id)
})
invokeTag('link','g',19,['action':("show"),'id':(ana.id)],3)
printHtmlPart(4)
expressionOut.print(ana.line)
printHtmlPart(5)
expressionOut.print(ana.frequency)
printHtmlPart(6)
expressionOut.print(ana.stack)
printHtmlPart(6)
expressionOut.print(ana.file)
printHtmlPart(6)
expressionOut.print(ana.occurence)
printHtmlPart(7)
}
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',28,[:],1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418994214000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
