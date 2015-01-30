import com.Analyser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_analyserhome_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/analyser/home.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('require','r',6,['module':("fileuploader")],-1)
printHtmlPart(2)
invokeTag('layoutResources','r',7,[:],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('textField','g',39,['name':("ticket")],-1)
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
createClosureForHtmlPart(8, 4)
invokeTag('onComplete','uploader',54,[:],4)
printHtmlPart(7)
})
invokeTag('uploader','uploader',55,['id':("fileUploader"),'url':([controller:'analyser', action:'test'])],3)
printHtmlPart(9)
invokeTag('actionSubmit','g',61,['value':("Analyse"),'action':("analyse")],-1)
printHtmlPart(10)
})
invokeTag('form','g',71,['method':("post"),'role':("form")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1419925380000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
