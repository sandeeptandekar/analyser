import com.ExceptionRef
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_loganalyser_exceptionRef_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/exceptionRef/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('textField','g',8,['name':("description"),'required':(""),'value':(exceptionRefInstance?.description)],-1)
printHtmlPart(1)
invokeTag('select','g',15,['id':("category"),'name':("category"),'from':(ExceptionRef.fetchAllCategory()),'required':(""),'value':(exceptionRefInstance?.category),'class':("many-to-one")],-1)
printHtmlPart(2)
expressionOut.print(exceptionRefInstance?.key)
printHtmlPart(3)
invokeTag('select','g',29,['id':("product"),'name':("product.id"),'from':(com.Product.list()),'optionKey':("id"),'required':(""),'value':(exceptionRefInstance?.product?.id),'class':("many-to-one")],-1)
printHtmlPart(4)
invokeTag('textField','g',35,['name':("resolution"),'required':(""),'value':(exceptionRefInstance?.resolution)],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422437610000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
