import com.ExceptionRef
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_logCaseupdate1_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/logCase/update1.gsp" }
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
for( ana in (hm) ) {
if(true && (ana.key == '1')) {
printHtmlPart(8)
expressionOut.print(ana.value)
printHtmlPart(9)
}
}
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
for( ana in (black) ) {
printHtmlPart(12)
if(true && (ana.key == '1')) {
printHtmlPart(13)
expressionOut.print(ana.value)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (ana.key == '2')) {
printHtmlPart(16)
expressionOut.print(ana.value)
printHtmlPart(17)
}
printHtmlPart(1)
if(true && (ana.key == '3')) {
printHtmlPart(18)
invokeTag('select','g',53,['id':("category"),'name':("category"),'from':(ExceptionRef.fetchAllCategory()),'required':(""),'value':(ana.value),'class':("many-to-one")],-1)
printHtmlPart(19)
}
printHtmlPart(1)
if(true && (ana.key == '4')) {
printHtmlPart(20)
invokeTag('textField','g',63,['id':("description"),'name':("description"),'required':(""),'value':(ana.value)],-1)
printHtmlPart(21)
}
printHtmlPart(1)
if(true && (ana.key == '5')) {
printHtmlPart(22)
invokeTag('textField','g',73,['id':("resolution"),'name':("resolution"),'required':(""),'value':(ana.value)],-1)
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (ana.key == '6')) {
printHtmlPart(25)
invokeTag('hiddenField','g',82,['id':("caseId"),'name':("caseId"),'required':(""),'value':(ana.value)],-1)
printHtmlPart(26)
}
printHtmlPart(24)
if(true && (ana.key == '7')) {
printHtmlPart(27)
invokeTag('hiddenField','g',92,['id':("ref"),'name':("ref"),'required':(""),'value':(ana.value)],-1)
printHtmlPart(26)
}
printHtmlPart(28)
}
printHtmlPart(29)
invokeTag('actionSubmit','g',115,['class':("delete"),'action':("update2"),'value':("update")],-1)
printHtmlPart(30)
})
invokeTag('form','g',118,['method':("PUT")],2)
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',125,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422516296000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
