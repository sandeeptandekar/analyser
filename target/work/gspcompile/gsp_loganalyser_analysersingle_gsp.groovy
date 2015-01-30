import org.example.Analyser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_analysersingle_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/analyser/single.gsp" }
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
createTagBody(2, {->
printHtmlPart(3)
for( ana in (showPage) ) {
printHtmlPart(4)
expressionOut.print(ana.frequency)
printHtmlPart(5)
expressionOut.print(ana.line)
printHtmlPart(6)
expressionOut.print(ana.stack)
printHtmlPart(7)
expressionOut.print(ana.file)
printHtmlPart(8)
expressionOut.print(ana.occurence)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('actionSubmit','g',31,['value':("Home"),'action':("home")],-1)
printHtmlPart(11)
invokeTag('actionSubmit','g',32,['value':("List"),'action':("list")],-1)
printHtmlPart(12)
})
invokeTag('form','g',33,['name':("myform"),'method':("post")],2)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',34,[:],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1419231898000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
