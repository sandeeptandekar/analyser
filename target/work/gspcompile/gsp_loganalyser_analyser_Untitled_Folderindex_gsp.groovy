import com.Analyser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_analyser_Untitled_Folderindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/analyser/Untitled Folder/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'analyser.label', default: 'Analyser'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',27,['property':("line"),'title':(message(code: 'analyser.line.label', default: 'Line'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("frequency"),'title':(message(code: 'analyser.frequency.label', default: 'Frequency'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',31,['property':("file"),'title':(message(code: 'analyser.file.label', default: 'File'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',33,['property':("occurence"),'title':(message(code: 'analyser.occurence.label', default: 'Occurence'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',35,['property':("stack"),'title':(message(code: 'analyser.stack.label', default: 'Stack'))],-1)
printHtmlPart(14)
loop:{
int i = 0
for( analyserInstance in (analyserInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: analyserInstance, field: "line"))
})
invokeTag('link','g',43,['action':("show"),'id':(analyserInstance.id)],3)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: analyserInstance, field: "frequency"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: analyserInstance, field: "file"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: analyserInstance, field: "occurence"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: analyserInstance, field: "stack"))
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
invokeTag('paginate','g',58,['total':(analyserInstanceCount ?: 0)],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',61,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1419921836000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
