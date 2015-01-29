package com



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional


import grails.converters.JSON

import files.Verify
import files.FileFilter
import java.util.Date;
import java.text.SimpleDateFormat
import java.io.File;
import java.io.InputStream;
import java.util.List
import java.util.ArrayList;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.io.FileUtils;
import org.apache.catalina.core.ApplicationHttpRequest
import java.net.URL;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartHttpServletRequest
import grails.converters.JSON
//import static grails.util.Holders.config as grailsConfig
import org.springframework.http.HttpStatus
import uk.co.desirableobjects.ajaxuploader.exception.FileUploadException
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.commons.CommonsMultipartFile
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletRequest
import org.springframework.web.servlet.ModelAndView
import uk.co.desirableobjects.ajaxuploader.AjaxUploaderService
import uk.co.desirableobjects.ajaxuploader.AjaxUploadController
import grails.util.GrailsNameUtils
import org.codehaus.groovy.grails.web.context.ServletContextHolder
class AnalyserController {
static allowedMethods = [save: "POST", update: "POST"]
// def scaffold=true;
def utilsService
def springSecurityService;
def grailsApplication
def messageSource
def scaffold=true;
AjaxUploadController ajaxUploadController
AjaxUploaderService ajaxUploaderService
static defaultAction="home"
def index()
{

}
def home()
{

}
def current()
{
}
def upload()
{
File root=new File("/home/kavitha/project/files");
        Date date = new Date();
         String d =date.getTime().toString();
File f=new File(root,d)
f.mkdir();
File f1=new File(f,params.qqfile)
f1.createNewFile();
def path=f.getAbsolutePath();
System.out.println(f1.getAbsolutePath());
InputStream inputStream = selectInputStream(request)
ajaxUploaderService.upload(inputStream,f1)
def filePath=f1.getAbsolutePath();
}
def analyse()
{

//def storagePath= servletContext.getRealPath("/");
//System.out.println(path);
//def value=params.mygroup;
///System.out.println(value);
def name1=params.Filepath;
//def name2=params.qqfile;
Verify l= new Verify();
File mainFolder = new File(name1);
       def hm4=l.properList(mainFolder,name1);
      // def fileName=l.getAllLogFiles(mainFolder);
       Integer h=hm4.size();
for(Integer z=0;z<h;z+=4)
{
String key1=hm4.get(z);
Integer value2=hm4.get(z+1);
String stack1=(String)hm4.get(z+2);
String occurence=(String)hm4.get(z+3);
def file1=params.qqfile;
System.out.println(file1);
def analyser=new Analyser(line: key1,frequency: value2,stack: stack1,file: name1,occurence : occurence)
analyser.save()
}
def a1 = Analyser.findAllByFile(name1,[sort: "frequency", order: "desc"])

return new ModelAndView("/analyser/analyse",[ smallList : a1])
}
def frames()
{
redirect(action : "list")
}
def display()
{
}
def submit()
{
def a1 = Analyser.findAllByFile(name1);
return new ModelAndView("/analyser/current",[ smallList : a1])
}
def list()
{
def a = Analyser.list(sort: "frequency", order: "desc")
return new ModelAndView("/analyser/display",[ resultList : a])
}
def show(Long id) {
        def analyseInstance = Analyser.get(id)
System.out.println(analyseInstance);
return new ModelAndView("/analyser/single",[showPage : analyseInstance])
    }
private InputStream selectInputStream(HttpServletRequest request) {
        if (request instanceof MultipartHttpServletRequest) {
            MultipartFile uploadedFile = ((MultipartHttpServletRequest) request).getFile('qqfile')
        def fileName=uploadedFile.getOriginalFilename();
          System.out.println(fileName);

             return uploadedFile.inputStream

        }
        return request.inputStream
    }

private String createTemporaryFile() {
        File root=new File("/home/kavitha/new/files");
        Date date = new Date();
         String d =date.getTime().toString();
File f=new File(root,d)
f.mkdir();
File f1=new File(f,params.qqfile)
f1.createNewFile();
String path=f.getAbsolutePath().toString();
System.out.println(f1.getAbsolutePath());
return path;
    }    
def test()
{
try
{
File root=new File("/home/kavitha/project/files");
       Date date = new Date();
         String d =date.getTime().toString();
File f=new File(root,d)
f.mkdir();
File f1=new File(f,params.qqfile)
f1.createNewFile();
//def path=f1.getAbsolutePath();
//println  "======================"+path;
InputStream inputStream = selectInputStream(request)
//println "=================="+inputStream;
ajaxUploaderService.upload(inputStream,f1)
//String relPath=f1.absolutePath
String path=f.getAbsolutePath();
return render(text: [success:true, filePath:path] as JSON, contentType:'text/html')
}
catch (FileUploadException e) {
log.error("Failed to upload file.", e)
return render(text: [success:false] as JSON, contentType:'text/html')
}
}
}
