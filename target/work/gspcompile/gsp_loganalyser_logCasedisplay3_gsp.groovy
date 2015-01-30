import com.LogCase
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCasedisplay3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCase/display3.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('javascript','g',6,['src':("read.js")],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
for( ana in (value) ) {
printHtmlPart(6)
expressionOut.print(ana.id)
printHtmlPart(7)
expressionOut.print(ana.category)
printHtmlPart(8)
expressionOut.print(ana.description)
printHtmlPart(9)
expressionOut.print(ana.key)
printHtmlPart(10)
expressionOut.print(ana.product)
printHtmlPart(11)
expressionOut.print(ana.resolution)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('actionSubmit','g',44,['value':("List"),'action':("index")],-1)
printHtmlPart(14)
})
invokeTag('form','g',45,['name':("myform"),'method':("post")],2)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',47,['style':(" background:#9CB071")],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1421673845000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
