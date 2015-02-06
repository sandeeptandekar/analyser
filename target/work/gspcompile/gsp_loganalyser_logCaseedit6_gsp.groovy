import com.ExceptionRef
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCaseedit6_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCase/edit6.gsp" }
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
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',13,['code':("default.home.label")],-1)
printHtmlPart(7)
for( ana in (black) ) {
if(true && (ana.key == 'back')) {
printHtmlPart(8)
expressionOut.print(ana.value)
printHtmlPart(9)
}
}
printHtmlPart(10)
for( ana in (black) ) {
if(true && (ana.key == 'ticket')) {
printHtmlPart(8)
expressionOut.print(ana.value)
printHtmlPart(11)
}
}
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
for( ana in (black) ) {
printHtmlPart(14)
if(true && (ana.key == '1')) {
printHtmlPart(15)
expressionOut.print(ana.value)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (ana.key == '2')) {
printHtmlPart(18)
expressionOut.print(ana.value)
printHtmlPart(19)
}
printHtmlPart(1)
if(true && (ana.key == '3')) {
printHtmlPart(20)
invokeTag('select','g',55,['id':("category"),'name':("category"),'from':(ExceptionRef.fetchAllCategory()),'required':(""),'value':(ana.value),'class':("many-to-one")],-1)
printHtmlPart(21)
}
printHtmlPart(1)
if(true && (ana.key == '4')) {
printHtmlPart(22)
invokeTag('textArea','g',65,['id':("description"),'name':("description"),'required':(""),'value':(ana.value)],-1)
printHtmlPart(23)
}
printHtmlPart(1)
if(true && (ana.key == '5')) {
printHtmlPart(24)
invokeTag('textField','g',75,['id':("resolution"),'name':("resolution"),'required':(""),'value':(ana.value)],-1)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (ana.key == '6')) {
printHtmlPart(27)
invokeTag('hiddenField','g',84,['id':("caseId"),'name':("caseId"),'required':(""),'value':(ana.value)],-1)
printHtmlPart(28)
}
printHtmlPart(26)
if(true && (ana.key == '7')) {
printHtmlPart(29)
invokeTag('hiddenField','g',94,['id':("ref"),'name':("ref"),'required':(""),'value':(ana.value)],-1)
printHtmlPart(28)
}
printHtmlPart(30)
}
printHtmlPart(31)
invokeTag('actionSubmit','g',117,['class':("delete"),'action':("show2"),'value':("update")],-1)
printHtmlPart(32)
})
invokeTag('form','g',120,['method':("PUT")],2)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',127,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1423050609000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
