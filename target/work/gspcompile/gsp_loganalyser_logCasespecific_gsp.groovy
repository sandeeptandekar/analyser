import com.LogCase
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCasespecific_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCase/specific.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','g',7,['src':("read.js")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
for( ana in (result) ) {
printHtmlPart(7)
expressionOut.print(ana.id)
printHtmlPart(8)
expressionOut.print(ana.dateCreated)
printHtmlPart(9)
expressionOut.print(ana.lastUpdated)
printHtmlPart(10)
expressionOut.print(ana.product)
printHtmlPart(11)
expressionOut.print(ana.ticketUrl)
printHtmlPart(12)
expressionOut.print(ana.uploadedFilePath)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('actionSubmit','g',43,['value':("List"),'action':("index")],-1)
printHtmlPart(1)
})
invokeTag('form','g',44,['name':("myform"),'method':("post")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',45,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1421662937000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
