import org.example.Analyser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_analyserupload_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/analyser/upload.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('head','uploader',5,[:],-1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
invokeTag('radio','g',10,['name':("mygroup"),'value':("Genespring")],-1)
printHtmlPart(3)
invokeTag('radio','g',11,['name':("mygroup"),'value':("Ngs4")],-1)
printHtmlPart(4)
invokeTag('textField','g',18,['name':("ticket")],-1)
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
createClosureForHtmlPart(7, 4)
invokeTag('onSubmit','uploader',27,[:],4)
printHtmlPart(6)
})
invokeTag('uploader','uploader',29,['id':("fileupload"),'url':([controller:'analyser', action:'store'])],3)
printHtmlPart(8)
invokeTag('actionSubmit','g',31,['value':("Save"),'action':("index")],-1)
printHtmlPart(9)
})
invokeTag('form','g',35,['name':("myform"),'method':("post")],2)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',37,[:],1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418104893000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
