package com
import grails.converters.JSON
import files.Code
import files.FileFilter
import java.util.Date;
import java.util.regex.Pattern
import java.util.regex.Matcher
//import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
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
import static grails.util.Holders.config as grailsConfig
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
import com.UtilService
import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib
@Transactional
class LogCaseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    UtilService utilservice
    def scaffold=true
    static defaultAction="create"
    AjaxUploaderService ajaxUploaderService
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LogCase.list(params), model:[logCaseInstanceCount: LogCase.count()]
//System.out.println(name);
    }


    def show(LogCase logCaseInstance) {

        respond logCaseInstance
    }

    def create() {
        respond new LogCase(params)
     //System.out.println(params.product.id);
    }

    @Transactional
    def save(LogCase logCaseInstance) {
//println params.product.id
        if (logCaseInstance == null) {
            notFound()
            return
        }

        if (logCaseInstance.hasErrors()) {
            respond logCaseInstance.errors, view:'create'
            return
        }

        logCaseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'logCase.label', default: 'LogCase'), logCaseInstance.id])
                redirect logCaseInstance
            }

            '*' { respond logCaseInstance, [status: CREATED] }
        }
    }

    def edit(LogCase logCaseInstance) {
        respond logCaseInstance
    }

    @Transactional
    def update(LogCase logCaseInstance) {
        if (logCaseInstance == null) {
            notFound()
            return
        }

        if (logCaseInstance.hasErrors()) {
            respond logCaseInstance.errors, view:'edit'
            return
        }

        logCaseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LogCase.label', default: 'LogCase'), logCaseInstance.id])
                redirect logCaseInstance
            }
            '*'{ respond logCaseInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LogCase logCaseInstance) {

        if (logCaseInstance == null) {
            notFound()
            return
        }

        logCaseInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LogCase.label', default: 'LogCase'), logCaseInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
def test()
{
try
{
       File root=new File("/home/kavitha/project/files");
       def find=root.getAbsolutePath();
      
       Date date = new Date();
      
       String d =date.getTime().toString();
       
       File f=new File(root,d)
       
       f.mkdir();
        //FileUtils.forceMkdir(f);
       String path2=f.getAbsolutePath();
       
       File f1=new File(f,params.qqfile)
      
        def p=params.qqfile
       println p
       f1.createNewFile();
       String path1=f1.getAbsolutePath();
       println path1
       InputStream inputStream = selectInputStream(request)
      
       ajaxUploaderService.upload(inputStream,f1)
      
       String path=f.getAbsolutePath();
       
       return render(text: [success:true, filePath:path] as JSON, contentType:'text/html')
}
catch (FileUploadException e) {
       log.error("Failed to upload file.", e)
       return render(text: [success:false] as JSON, contentType:'text/html')
}
}
//This action collect the uploaded file path from the form and use it in java function to analyse it.
 
def analyse()
{
    def productId=params.product.id
    def filePath=params.Filepath
    def ticket=params.ticketUrl
    def uploadedPath=params.uploadedFilePath
    File mainFolder = new File(uploadedPath)
    HashMap<String,HashMap<String,HashMap<Integer,String>>> out=new HashMap<String,HashMap<String,HashMap<Integer,String>>>();
    HashMap<String,Integer> hm=new HashMap<String,Integer>();
    HashMap<String,HashMap<Integer,String>> hm4=new HashMap<String,HashMap<Integer,String>>();
    HashMap<Integer,String> hm1=new HashMap<Integer,String>();
    HashMap<Integer,String> hm22=new HashMap<Integer,String>();
    HashMap<Integer,String> hm33=new HashMap<Integer,String>();



    ArrayList<Object> arrayList=new ArrayList<Object>();
    ArrayList<Object> arrayList2=new ArrayList<Object>();
    ArrayList<Object> arrayList3=new ArrayList<Object>();
   String red="red"
   String green="green"
   hm.put(green,0)
   hm.put(red,0)
   hm.put("BLACK",0)
   def product=Product.findById(productId)
 //Insert the values in LogCase table.
   def log=new LogCase(ticketUrl:ticket,uploadedFilePath:uploadedPath,product:product)
     if (!log.save(flush:true)) {
           log.errors.each {
        println it
    }
}
   def logId=LogCase.findByUploadedFilePath(uploadedPath)
   def tick=logId.ticketUrl
   println tick
   def id=logId.id
   //Here object for the java file is created.
   Code l=new Code();
   //A method that returns the list of files in uploaded zip file
   def hm2=l.getAllLogFiles(mainFolder,uploadedPath);
    System.out.println("summary ==================");
                        for (String entry : hm2.keySet()) {
                                System.out.println("Key = " + entry + ", Value = "
                                               + hm2.get(entry));}
                   for(String entry1:hm2.keySet())
 {
           String fd=entry1;
           String path=hm2.get(entry1);

           File fdName=new File(fd);
           String folder=fdName.getName();
           //here the folder name,casee id is stored in Expcontainer table.
           def expContainer=new ExpContainer(title:folder,logCase:logId)
           if (!expContainer.save(flush:true)) {
    expContainer.errors.each {
        println it
    }
   }
          System.out.println(path);
               //This method returns the list that has key,frequency and file path.
                def list= l.properList(mainFolder,path);
                for(int i=0;i<list.size();i+=3)
     {
          def key1=list.get(i);
          Integer frequency=list.get(i+1);
          String logFilePath=list.get(i+2);
          String description="description";
          String resolution="resolution";
          String category="BLACK";
           //String expRef="";
          println key1
          println product
          def key2=key1.trim();
         //For each time it comes into this loop it stores the key,product,caseId,category,description,resolution if it is occuring for the first time.If it is already present in the table it is rejected. 
          def expRef1=ExceptionRef.findByKeyAndProduct(key2,product)
          println "----" + expRef1
          if(expRef1 == null)
     {
        expRef1=new ExceptionRef(key:key2,category:category,description:description,resolution:resolution,product:product,caseId:id)
        if (!expRef1.save(flush:true)) {
   expRef1.errors.each {
        println it
       }
     }

     }

         println  "-----------" + expRef1;
         //If the particular key is stored in ExcptionRef table then its frequency,filepath,expContainer Id and expRefId are stored in this table.
         def logException=new LogException(frequency:frequency,logFilePath:logFilePath,expContainer:expContainer,expRef:expRef1)
         if (!logException.save(flush:true)) {
            logException.errors.each {
        println it
    }
    }
   }
}
//The below code takes the particular caseId and finds the folders in that particular zip file and gives a hashMap that has a summary of how many exceptions are in category black,red,green.

          def hm3=l.getAllLogFiles(mainFolder,uploadedPath);
          for(String entry: hm3.keySet())
          {
            String df=entry;
            File df1=new File(df)
            String df2=df1.getName() 
            def container=ExpContainer.findByTitle(df2)
            def container1=container.logCase

            def logExp=LogException.findAllByExpContainer(container)
            println logExp
            int count1=0;
            int count3=0;
            int v=0;
            int v1=0;
            String color="BLACK"
            String color4="BLACK"
            def black=logExp.expRefId
            def containerId=container.id
            hm1.put("key",id)
            hm4.put(color,hm1)
            out.put("0",hm4)
            hm4=new HashMap<String,HashMap<Integer,String>>();
            hm1=new HashMap<Integer,String>();

            hm1.put("key1",ticket)
            hm4.put(color4,hm1)
            out.put("1",hm4)
            hm4=new HashMap<String,HashMap<Integer,String>>();
            hm1=new HashMap<Integer,String>();


            println(black)
            println(container)

                    for(int j=0;j<black.size();j++)
                        {
                            String value=black.get(j);
                            def ref=ExceptionRef.findById(value)
                            def color1=ref.category
                            if(hm.containsKey(color1))
                              {
                                   count1=hm.get(color1)
                                   count1++;
                                   hm.put(color1,count1)
                              }
                            else
                              {
                                    hm.put(color1,1)
                              }
                          }

                              if(!hm4.containsKey(color))
                               {
                                    count3=hm.get(color)

                                    arrayList.add(count3)

                                    def link=g.createLink(controller : "logCase",action : "black" , params : [id : containerId,case1 : id])
                                    hm1.put(count3,link)
                                    arrayList.add(link)

                                    hm4.put(color,hm1)
                               }
                             if(!hm4.containsKey(green))
                               {
                                   v=hm.get(green)
                                   arrayList2.add(v)
                                   def link=g.createLink(controller : "logCase",action : "green" , params : [id : containerId,case1 : id])
                                   hm22.put(v,link)
                                   arrayList2.add(link)
                                   hm4.put(green,hm22)
                               }
                             if(!hm4.containsKey(red))
                               {
                                    v1=hm.get(red)
                                    arrayList3.add(v1)
                                    def link=g.createLink(controller : "logCase",action : "red" , params : [id : containerId,case1 : id])
                                    hm33.put(v1,link)
                                    arrayList3.add(link)

                                    hm4.put(red,hm33)
                                }
                                    out.put(df2,hm4)
                                    hm= new HashMap<String,Integer>();
                                    hm4=new HashMap<String,Integer>();
                                    hm1=new HashMap<Integer,String>();
                                    hm22=new HashMap<Integer,String>();
                                    hm33=new HashMap<Integer,String>();

                                   arrayList=new ArrayList<Object>();
                                   arrayList2=new ArrayList<Object>();
                                   arrayList3=new ArrayList<Object>();
                                   hm.put(green,0)
                                   hm.put(red,0)
                                   hm.put("BLACK",0)
}
System.out.println("summary ==================");
                        for (String entry : out.keySet()) {
                                System.out.println("Key = " + entry + ", Value = "
                                               + out.get(entry));}



System.out.println("summary ==================");
                        for (String entry : hm.keySet()) {
                                System.out.println("Key = " + entry + ", Value = "
                                               + hm.get(entry));}


Map<String, Float> map = new TreeMap<String, Float>(out);
return new ModelAndView("/logCase/display",[ result : map])

}


def display()
{

}
def display3(Integer exp)
{
def value1=ExceptionRef.findById(exp)
[value:value1]
}
def category1()
{
def black="BLACK"
def a=ExceptionRef.findAllByCategory(black)
HashMap<String,Object> hm=new HashMap<String,Object>();
for(int i=0;i<a.size();i++)
{
def value=a.get(i)
def key=value.key
def id1=value.id
 def link=g.createLink(controller : "logCase",action : "edit6", params : [ category : black,keyId : id1])

hm.put(key,link)
}
[black:hm]
}
def category2()
{
def red="red"
def a=ExceptionRef.findAllByCategory(red)
HashMap<String,Object> hm=new HashMap<String,Object>();
for(int i=0;i<a.size();i++)
{
def value=a.get(i)
def key=value.key
def id1=value.id
def link=g.createLink(controller : "logCase",action : "edit7", params : [ category : red,keyId : id1])

hm.put(key,link)
}
[black:hm]
}
def category3()
{
def green="green"
def a=ExceptionRef.findAllByCategory(green)
HashMap<String,Object> hm=new HashMap<String,Object>();
for(int i=0;i<a.size();i++)
{
def value=a.get(i)
def key=value.key
def id1=value.id
def link=g.createLink(controller : "logCase",action : "edit8", params : [ category : green,keyId : id1])

hm.put(key,link)
}
[black:hm]
}


def specific()
{
def a=params.caseno
println a
def a1=LogCase.findById(a)
def link=g.createLink(controller : "logCase",action : "show", params : [ logCaseInstance : a1])

[result:a1]
}
def page()
{
    //This action gets the case id from the home page in view case link and gives the summary of exceptions in each category according to folders in theuploaded zip file.
    def a=params.id
    def a1=params.caseno
    def a3=a1
    def logCaseInstance=LogCase.findById(a3)
    def ticket=logCaseInstance.ticketUrl
    def logCaseInstance1= logCaseInstance.product
    def logCaseInstance2= logCaseInstance.uploadedFilePath
    HashMap<String,HashMap<String,HashMap<Integer,String>>> out=new HashMap<String,HashMap<String,HashMap<Integer,String>>>();
    HashMap<String,Integer> hm=new HashMap<String,Integer>();
    HashMap<String,HashMap<Integer,String>> hm4=new HashMap<String,HashMap<Integer,String>>();
    HashMap<Integer,String> hm1=new HashMap<Integer,String>();
    HashMap<Integer,String> hm22=new HashMap<Integer,String>();
    HashMap<Integer,String> hm33=new HashMap<Integer,String>();

    ArrayList<Object> arrayList=new ArrayList<Object>();
    ArrayList<Object> arrayList2=new ArrayList<Object>();
    ArrayList<Object> arrayList3=new ArrayList<Object>();
    String color="BLACK"
    String red="red"
    String green="green"
    int count3=0;
    int count4=0;
    int count5=0;
    hm.put("green",0)
    hm.put("red",0)
    hm.put("BLACK",0)
    def path=ExpContainer.findAllByLogCase(logCaseInstance)
    println "-------------" + path

    hm1.put("key",a1)
    hm4.put(color,hm1)
    out.put("0",hm4)
    hm4=new HashMap<String,HashMap<Integer,String>>();
    hm1=new HashMap<Integer,String>();
    hm1.put("key1",ticket)
    hm4.put(red,hm1)
    out.put("1",hm4)
    hm4=new HashMap<String,HashMap<Integer,String>>();
    hm1=new HashMap<Integer,String>();
    for(int k=0;k<path.size();k++)
      {
         def b=path.get(k)
         println b
         def c=b.title
         def c2=b.id
         def b1=LogException.findAllByExpContainer(b)
         println "------------" + b1
         for(int j=0;j<b1.size();j++)
              {
                 def value=b1.get(j)
                 def b4=value.expRef
                 def b6=b4.category
                 println "............" + b6
                 if(hm.containsKey(b6))

                     {
                         Integer i2=hm.get(b6)
                         i2++
                         hm.put(b6,i2)
                     }
                 else
                     {
                         hm.put(b6,1)
                     }
              } 
         println hm
                 if(!hm4.containsKey(color))
                     {
                         count3=hm.get(color)

                         arrayList.add(count3)
                         def link=g.createLink(controller : "logCase",action : "black" , params : [id : c2, case1 : a1])
                         hm1.put(count3,link)
                         arrayList.add(link)

                         hm4.put(color,hm1)
                     }
                 if(!hm4.containsKey(green))
                     {
                         count4= hm.get(green)

                         arrayList2.add(count4)
                         def link=g.createLink(controller : "logCase",action : "green" , params : [id : c2, case1 : a1])
                         arrayList2.add(link)
                         hm22.put(count4,link)
                         hm4.put(green,hm22)
                    }
                if(!hm4.containsKey(red))
                    {
                         count5=hm.get(red)
                         arrayList3.add(count5)
                         def link=g.createLink(controller : "logCase",action : "red" , params : [id : c2, case1 : a1])
                         arrayList3.add(link)
                         hm33.put(count5,link)
                         hm4.put(red,hm33)
                    }

                         println arrayList

                         out.put(c,hm4)
                         hm=new HashMap<String,Integer>();
                         hm4=new HashMap<String,Integer>();
                         hm1=new HashMap<Integer,String>();
                         hm22=new HashMap<Integer,String>();
                         hm33=new HashMap<Integer,String>();

                         arrayList=new ArrayList<Object>();
                         arrayList2=new ArrayList<Object>();
                         arrayList3=new ArrayList<Object>();
                         hm.put(green,0)
                         hm.put(red,0)
                         hm.put("BLACK",0)
}
println out
                         Map<String, Float> map = new TreeMap<String, Float>(out);
                         [result:map]

}
def page1(LogCase logCaseInstance)
{
     def a=params.id
     def logCaseInstance3=logCaseInstance.id
     def a1=logCaseInstance3
     def ticket=logCaseInstance.ticketUrl
     def logCaseInstance1= logCaseInstance.product
     def logCaseInstance2= logCaseInstance.uploadedFilePath
     HashMap<String,HashMap<String,HashMap<Integer,String>>> out=new HashMap<String,HashMap<String,HashMap<Integer,String>>>();
     HashMap<String,Integer> hm=new HashMap<String,Integer>();
     HashMap<String,HashMap<Integer,String>> hm4=new HashMap<String,HashMap<Integer,String>>();
     HashMap<Integer,String> hm1=new HashMap<Integer,String>();
     HashMap<Integer,String> hm22=new HashMap<Integer,String>();
     HashMap<Integer,String> hm33=new HashMap<Integer,String>();

     ArrayList<Object> arrayList=new ArrayList<Object>();
     ArrayList<Object> arrayList2=new ArrayList<Object>();
     ArrayList<Object> arrayList3=new ArrayList<Object>();
     String color="BLACK"
     String red="red"
     String green="green"
     int count3=0;
     int count4=0;
     int count5=0;
     hm.put("green",0)
     hm.put("red",0)
     hm.put("BLACK",0)

     def path=ExpContainer.findAllByLogCase(logCaseInstance)
     println "-------------" + path

     hm1.put("key",logCaseInstance3)
     hm4.put(color,hm1)
     out.put("0",hm4)
     hm4=new HashMap<String,HashMap<Integer,String>>();
     hm1=new HashMap<Integer,String>();
     hm1.put("key1",ticket)
     hm4.put(red,hm1)
     out.put("1",hm4)
     hm4=new HashMap<String,HashMap<Integer,String>>();
     hm1=new HashMap<Integer,String>();
          for(int k=0;k<path.size();k++)
              {
                  def b=path.get(k)
                  println b
                  def c=b.title
                  def c2=b.id
                  def b1=LogException.findAllByExpContainer(b)
                  println "------------" + b1
                  for(int j=0;j<b1.size();j++)
                     {
                          def value=b1.get(j)
                          def b4=value.expRef
                          def b6=b4.category
                          println "............" + b6
                          if(hm.containsKey(b6))

                             {
                                  Integer i2=hm.get(b6)
                                  i2++
                                  hm.put(b6,i2)
                             }
                           else
                             {
                                   hm.put(b6,1)
                             }
                      }
      println hm
                           if(!hm4.containsKey(color))
                             {
                               count3=hm.get(color)

                               arrayList.add(count3)

//def link=g.createLink(controller : "logCase",action : "black", params : [ containerId : containerId, category : color])
                               def link=g.createLink(controller : "logCase",action : "black" , params : [id : c2, case1 : a1])
                               hm1.put(count3,link)
                               arrayList.add(link)

                               hm4.put(color,hm1)
                            }
                          if(!hm4.containsKey(green))
                            {
                               count4= hm.get(green)

                               arrayList2.add(count4)
                               def link=g.createLink(controller : "logCase",action : "green" , params : [id : c2, case1 : a1])
                               arrayList2.add(link)
                               hm22.put(count4,link)
                               hm4.put(green,hm22)
                            }
                         if(!hm4.containsKey(red))
                            {
                               count5=hm.get(red)
                               arrayList3.add(count5)
                               def link=g.createLink(controller : "logCase",action : "red" , params : [id : c2, case1 : a1])
                               arrayList3.add(link)
                               hm33.put(count5,link)
                               hm4.put(red,hm33)
                            }

                               println arrayList

                               out.put(c,hm4)
                               hm=new HashMap<String,Integer>();
                               hm4=new HashMap<String,Integer>();
                               hm1=new HashMap<Integer,String>();
                               hm22=new HashMap<Integer,String>();
                               hm33=new HashMap<Integer,String>();

                               arrayList=new ArrayList<Object>();
                               arrayList2=new ArrayList<Object>();
                               arrayList3=new ArrayList<Object>();
                               hm.put(green,0)
                               hm.put(red,0)
                               hm.put("BLACK",0)
}
println out
Map<String, Float> map = new TreeMap<String, Float>(out);
[result:map]
//return new ModelAndView("/logCase/get",[logCase :a])
}
//This action is called after you edit the content for particular Key by clicking the back button.It takes CaseId from the HashMap of Update2.gsp page.
def summary(Integer id)
{
       def a=params.id
       def a1=params.caseno
//def a3=case1
       def logCaseInstance=LogCase.findById(id)
       def ticket=logCaseInstance.ticketUrl
       def log=logCaseInstance.id
       def logCaseInstance1= logCaseInstance.product
       def logCaseInstance2= logCaseInstance.uploadedFilePath
       HashMap<String,HashMap<String,HashMap<Integer,String>>> out=new HashMap<String,HashMap<String,HashMap<Integer,String>>>();
       HashMap<String,Integer> hm=new HashMap<String,Integer>();
       HashMap<String,HashMap<Integer,String>> hm4=new HashMap<String,HashMap<Integer,String>>();
       HashMap<Integer,String> hm1=new HashMap<Integer,String>();
       HashMap<Integer,String> hm22=new HashMap<Integer,String>();
       HashMap<Integer,String> hm33=new HashMap<Integer,String>();

       ArrayList<Object> arrayList=new ArrayList<Object>();
       ArrayList<Object> arrayList2=new ArrayList<Object>();
       ArrayList<Object> arrayList3=new ArrayList<Object>();
       String color="BLACK"
       String red="red"
       String green="green"
       int count3=0;
       int count4=0;
       int count5=0;
       hm.put("green",0)
       hm.put("red",0)
       hm.put("BLACK",0)
       def path=ExpContainer.findAllByLogCase(logCaseInstance)
       println "-------------" + path
//arrayList.add(logCaseInstance1)
//arrayList.add(a1)
//hm4.put(logCaseInstance1,arrayList)

       hm1.put("key",log)
       hm4.put(color,hm1)
       out.put("0",hm4)
       hm4=new HashMap<String,HashMap<Integer,String>>();
       hm1=new HashMap<Integer,String>();
       hm1.put("key1",ticket)
       hm4.put(red,hm1)
       out.put("1",hm4)
       hm4=new HashMap<String,HashMap<Integer,String>>();
       hm1=new HashMap<Integer,String>();
       for(int k=0;k<path.size();k++)
              {
                   def b=path.get(k)
                   println b
                   def c=b.title
                   def c2=b.id
                   def b1=LogException.findAllByExpContainer(b)
                   println "------------" + b1
                   for(int j=0;j<b1.size();j++)
                      {
                         def value=b1.get(j)
                         def b4=value.expRef

                         def b6=b4.category
                         println "............" + b6
                         if(hm.containsKey(b6))

                           {
                                Integer i2=hm.get(b6)
                                i2++
                                hm.put(b6,i2)
                           }
                         else
                           {
                                hm.put(b6,1)
                           }
                        }
                      println hm
                         if(!hm4.containsKey(color))
                           {
                              count3=hm.get(color)

                              arrayList.add(count3)


                              def link=g.createLink(controller : "logCase",action : "black" , params : [id : c2, case1 : id])
                              hm1.put(count3,link)
                              arrayList.add(link)

                              hm4.put(color,hm1)
                           }
                         if(!hm4.containsKey(green))
                           {
                              count4= hm.get(green)

                              arrayList2.add(count4)
                              def link=g.createLink(controller : "logCase",action : "green" , params : [id : c2,case1 :id])
                              arrayList2.add(link)
                              hm22.put(count4,link)
                              hm4.put(green,hm22)
                           }
                         if(!hm4.containsKey(red))
                           {
                              count5=hm.get(red)
                              arrayList3.add(count5)
                              def link=g.createLink(controller : "logCase",action : "red" , params : [id : c2,case1 :id])
                              arrayList3.add(link)
                              hm33.put(count5,link)
                              hm4.put(red,hm33)
                           }

println arrayList

                              out.put(c,hm4)
                              hm=new HashMap<String,Integer>();
                              hm4=new HashMap<String,Integer>();
                              hm1=new HashMap<Integer,String>();
                              hm22=new HashMap<Integer,String>();
                              hm33=new HashMap<Integer,String>();

                              arrayList=new ArrayList<Object>();
                              arrayList2=new ArrayList<Object>();
                              arrayList3=new ArrayList<Object>();
                              hm.put(green,0)
                              hm.put(red,0)
                              hm.put("BLACK",0)
}
println out
Map<String, Float> map = new TreeMap<String, Float>(out);
[result:map]

}
//this action is for displaying the exceptions with category black for particular case id and folder.
def black(Integer id,Integer case1)
{
     String category="BLACK"
     def black1=ExpContainer.findById(id)
     System.out.println(black1)
     def case2=LogCase.findById(case1)
     def ticket=case2.ticketUrl
     def black2=black1.logException.expRefId
     HashMap<String,Object> hm=new HashMap<String,Object>();
     ArrayList<String> ar=new ArrayList<String>();
     System.out.println(black2)
     def link1=g.createLink(controller : "logCase",action : "summary", params : [ id : case1])

     hm.put("1",link1)
     hm.put("ticket",ticket)
     for(int k=0;k<black2.size();k++)
        {
            def value=black2.get(k)
            def value2=ExceptionRef.findById(value)
            println value2
            def value3=value2.id
            def value1=value2.category
            if(value1 == category)
              {
                   def black3=LogException.findByExpRef(value2)
                   println black3
                   def u=black3.id
                   def u1=black3.expRef.key
                   def u2=black3.expRef
                   def link=g.createLink(controller : "logCase",action : "edit1", params : [ id : u,container:id,caseId :case1])
                   hm.put(u1,link);
                   
                   ar.add(u)
              }
        }
Map<String, Float> map = new TreeMap<String, Float>(hm);

[black:map]

}
//this action is for displaying the exceptions with category green for particular case id and folder.
def green(Integer id,Integer case1)
{
     String category="green"
     def black1=ExpContainer.findById(id)
     System.out.println(black1)
     def black2=black1.logException.expRefId
     def case2=LogCase.findById(case1)
     def ticket=case2.ticketUrl

     HashMap<String,Object> hm=new HashMap<String,Object>();

     System.out.println(black2)
     def link1=g.createLink(controller : "logCase",action : "summary", params : [ id : case1])
     hm.put("1",link1)
     hm.put("ticket",ticket)
     for(int k=0;k<black2.size();k++)
        {
           def value=black2.get(k)
           def value2=ExceptionRef.findById(value)
           println value2
           def value3=value2.id
           def value1=value2.category
           if(value1 == category)
             {
                 def black3=LogException.findByExpRef(value2)
                 def u=black3.id
                 def u1=black3.expRef.key
                 println black3
                 def link=g.createLink(controller : "logCase",action : "edit4", params : [ id : u,container: id,caseId : case1])
                 hm.put(u1,link);
             }
        }
Map<String, Float> map = new TreeMap<String, Float>(hm);

[black:hm]
}
//this action is for displaying the exceptions with category red for particular case id and folder.
def red(int id,Integer case1)
{
     String category="red"
     def black1=ExpContainer.findById(id)
     System.out.println(black1)
     def black2=black1.logException.expRefId
     def case2=LogCase.findById(case1)
     def ticket=case2.ticketUrl

     HashMap<String,Object> hm=new HashMap<String,Object>();

     System.out.println(black2)
     def link1=g.createLink(controller : "logCase",action : "summary", params : [ id : case1])
     hm.put("1",link1)
     hm.put("ticket",ticket)

     for(int k=0;k<black2.size();k++)
        {
             def value=black2.get(k)
             def value2=ExceptionRef.findById(value)
             println value2
             def value3=value2.id
             def value1=value2.category
             if(value1 == category)
               {
                    def black3=LogException.findByExpRef(value2)
                    println black3
                    def u=black3.id
                    def u1=black3.expRef.key
                    def link=g.createLink(controller : "logCase",action : "edit3", params : [ id : u,container :id,caseId :case1])
                    hm.put(u1,link);
               }
       } 
Map<String, Float> map = new TreeMap<String, Float>(hm);
[black:hm]
}

def get()
{
def a=params.caseno
println a
def logCaseInstance=LogCase.findById(a)
println logCaseInstance
respond logCaseInstance
}
//This page gives the detailed description of particular key in black category and gives you the link to edit some parameter of that key.
def edit1(int id,int container,int caseId)
{
     HashMap<Object,Object> hm=new HashMap<String,Object>()
     def case2=LogCase.findById(caseId)
     def ticket=case2.ticketUrl

     def findKey=LogException.findById(id)
     println findKey
     def key=findKey.expRef
     println key
     def id1=key.id
     def kid=key.key
     println kid
     def frequency=findKey.frequency
     println frequency
     def folder=findKey.expContainer
     println folder
     def name=folder.title
     def case1=folder.logCase.id
     println name
     def key1=kid.trim()
     def a=ExceptionRef.findByKey(key1)
     def a1=a.category
println a1
     def a2=a.description
     def a3=a.resolution
     def a4=a.product
     def currentFolder=ExpContainer.findById(container)
     def currentFolder1=currentFolder.title
     def link=g.createLink(controller : "logCase",action : "update1", params : [ id : id1,caseId : caseId])
     def link1=g.createLink(controller : "logCase",action : "black", params : [ id : container,case1 : caseId ])
     hm.put("1",link1)
     hm.put("ticket",ticket)
     hm.put("key",key1)
     hm.put("frequency",frequency)
     hm.put("Folder name",currentFolder1)
     hm.put("Case id",a1)
     hm.put("category",caseId)
     hm.put("description",a2)
     hm.put("resolution",a3)
     hm.put("product",link)
     hm.put("pproduct",a4)
     println hm
     [hm:hm]

}
//This page allows you to change the category ,resolution and description.
def update1(int id,int caseId)
{
    def ref=ExceptionRef.findById(id)
    def key=ref.key
    def product=ref.product
    def description=ref.description
    def category=ref.category
    def resolution=ref.resolution
    def case2=LogCase.findById(caseId)
    def ticket=case2.ticketUrl

    HashMap<String,Object> hm=new HashMap<String,Object>();
    hm.put("ticket",ticket)
    hm.put("1",key)
    hm.put("2",product)
    hm.put("3",category)
    hm.put("4",description)
    hm.put("5",resolution)
    hm.put("6",caseId)
    hm.put("7",id)
    println hm
    Map<String, Float> map = new TreeMap<String, Float>(hm);
    [black:hm]
}
//this page displays the updated details of the changed key.
def update2()
{
    def category=params.category
    def description=params.description
    def resolution=params.resolution
    def caseId=params.caseId
    def id=params.ref
    println "+++++++++++" + caseId
    println "__________" + id

    def ref1=ExceptionRef.findById(id)
    def product2=ref1.product

     def key=ref1.key
     ref1.category=category;
     ref1.description=description;
     ref1.product=product2;
     ref1.resolution=resolution;
     ref1.save()
     def ref2=ExceptionRef.findById(id)
     def category1=ref2.category
     def description1=ref2.description
     def resolution1=ref2.resolution
     def link=g.createLink(controller : "logCase",action : "summary", params : [ id : caseId])
     HashMap<String,Object> hm =new HashMap<String,Object>();
     hm.put("0",link)
     hm.put("1",key)
     hm.put("2",category1)
     hm.put("3",description1)
     hm.put("4",resolution1)
     hm.put("5",product2)
     println "======" + category1
     Map<String, Float> map = new TreeMap<String, Float>(hm);
     [black:hm]

}
//This page gives the detailed description of particular key in green category and gives you the link to edit some parameter of that key.

def edit4(int id,int container,int caseId)
{
     HashMap<Object,Object> hm=new HashMap<String,Object>()
     def case2=LogCase.findById(caseId)
     def ticket=case2.ticketUrl

     def findKey=LogException.findById(id)
     println findKey
     def key=findKey.expRef
     println key
     def id1=key.id
     def kid=key.key
     println kid
     def frequency=findKey.frequency
     println frequency
     def folder=findKey.expContainer
     println folder
     def name=folder.title
     def case1=folder.logCase.id
     println name
     def key1=kid.trim()
     def a=ExceptionRef.findByKey(key1)
     def a1=a.category
     println a1
     def currentFolder=ExpContainer.findById(container)
     def currentFolder1=currentFolder.title

     def a2=a.description
     def a3=a.resolution
     def a4=a.product
     def link=g.createLink(controller : "logCase",action : "update1", params : [ id : id1,caseId : caseId])
     def link1=g.createLink(controller : "logCase",action : "green", params : [ id : container,case1 : caseId ])
     hm.put("ticket",ticket)
     hm.put("1",link1)
     hm.put("key",key1)
     hm.put("frequency",frequency)
     hm.put("Folder name",currentFolder1)
     hm.put("Case id",a1)
     hm.put("category",caseId)
     hm.put("description",a2)
     hm.put("resolution",a3)
     hm.put("product",link)
     hm.put("pproduct",a4)
     println hm
     [hm:hm]

}
//This page gives the detailed description of particular key in red category and gives you the link to edit some parameter of that key.
def edit3(int id,int container,int caseId)
{
     HashMap<Object,Object> hm=new HashMap<String,Object>()
     def case2=LogCase.findById(caseId)
     def ticket=case2.ticketUrl

     def findKey=LogException.findById(id)
     println findKey
     def key=findKey.expRef
     println key
     def id1=key.id
     def kid=key.key
     println kid
     def frequency=findKey.frequency
     println frequency
     def folder=findKey.expContainer
     println folder
     def name=folder.title
     def case1=folder.logCase.id
     println name
     def key1=kid.trim()
     def a=ExceptionRef.findByKey(key1)
     def a1=a.category
     println a1
     def a2=a.description
     def a3=a.resolution
     def a4=a.product
     def currentFolder=ExpContainer.findById(container)
     def currentFolder1=currentFolder.title

     def link=g.createLink(controller : "logCase",action : "update1", params : [ id : id1,caseId : caseId])
//hm.put("ledit",link)
     def link1=g.createLink(controller : "logCase",action : "red", params : [ id : container,case1 : caseId ])
     hm.put("ticket",ticket)
     hm.put("1",link1)
     hm.put("key",key1)
     hm.put("frequency",frequency)
     hm.put("Folder name",currentFolder1)
     hm.put("Case id",a1)
     hm.put("category",caseId)
     hm.put("description",a2)
     hm.put("resolution",a3)
     hm.put("product",link)
     hm.put("pproduct",a4)
     println hm
//def link=g.createLink(controller : "ExceptionRef",action : "edit", params : [ id : id1])
//hm.put("ledit",link)
     [hm:hm]

}
def edit6(int keyId)
{
    def ref=ExceptionRef.findById(keyId)
    def key=ref.key
    def product=ref.product
    def description=ref.description
    def category=ref.category
    def resolution=ref.resolution
    //def case2=LogCase.findById(caseId)
    //def ticket=case2.ticketUrl
 def link1=g.createLink(controller : "logCase",action : "category1", params : [ black : "BLACK" ])

    HashMap<String,Object> hm=new HashMap<String,Object>();
    //hm.put("ticket",ticket)
    hm.put("1",key)
    hm.put("2",product)
    hm.put("3",category)
    hm.put("4",description)
    hm.put("5",resolution)
    hm.put("6",keyId)
    hm.put("back",link1)
    //hm.put("7",id)
    println hm
    Map<String, Float> map = new TreeMap<String, Float>(hm);
    [black:hm]
}
def edit7(int keyId)
{
    def ref=ExceptionRef.findById(keyId)
    def key=ref.key
    def product=ref.product
    def description=ref.description
    def category=ref.category
    def resolution=ref.resolution
    //def case2=LogCase.findById(caseId)
    //def ticket=case2.ticketUrl
 def link1=g.createLink(controller : "logCase",action : "category2", params : [ black : "red" ])

    HashMap<String,Object> hm=new HashMap<String,Object>();
    //hm.put("ticket",ticket)
    hm.put("1",key)
    hm.put("2",product)
    hm.put("3",category)
    hm.put("4",description)
    hm.put("5",resolution)
    hm.put("6",keyId)
    hm.put("back",link1)
    //hm.put("7",id)
    println hm
    Map<String, Float> map = new TreeMap<String, Float>(hm);
    [black:hm]
}
def edit8(int keyId)
{
    def ref=ExceptionRef.findById(keyId)
    def key=ref.key
    def product=ref.product
    def description=ref.description
    def category=ref.category
    def resolution=ref.resolution
    //def case2=LogCase.findById(caseId)
    //def ticket=case2.ticketUrl
 def link1=g.createLink(controller : "logCase",action : "category3", params : [ green : "green" ])

    HashMap<String,Object> hm=new HashMap<String,Object>();
    //hm.put("ticket",ticket)
    hm.put("1",key)
    hm.put("2",product)
    hm.put("3",category)
    hm.put("4",description)
    hm.put("5",resolution)
    hm.put("6",keyId)
    hm.put("back",link1)
    //hm.put("7",id)
    println hm
    Map<String, Float> map = new TreeMap<String, Float>(hm);
    [black:hm]
}

def show2()
{
    def category=params.category
    def description=params.description
    def resolution=params.resolution
   def keyId=params.caseId
    //def id=params.ref
    println "+++++++++++" + keyId
   // println "__________" + id

    def ref1=ExceptionRef.findById(keyId)
    def product2=ref1.product

     def key=ref1.key
     ref1.category=category;
     ref1.description=description;
     ref1.product=product2;
     ref1.resolution=resolution;
     ref1.save()
     def ref2=ExceptionRef.findById(keyId)
     def category1=ref2.category
     def description1=ref2.description
     def resolution1=ref2.resolution
     //def link=g.createLink(controller : "logCase",action : "summary", params : [ id : caseId])
     HashMap<String,Object> hm =new HashMap<String,Object>();
     def link1=g.createLink(controller : "logCase",action : "category1", params : [ black : "BLACK" ])

    // hm.put("0",link)
     hm.put("1",key)
     hm.put("2",category1)
     hm.put("3",description1)
     hm.put("4",resolution1)
     hm.put("5",product2)
     hm.put("back",link1)
     println "======" + category1
     Map<String, Float> map = new TreeMap<String, Float>(hm);
     [black:hm]

}
def show4()
{
    def category=params.category
    def description=params.description
    def resolution=params.resolution
   def keyId=params.caseId
    //def id=params.ref
    println "+++++++++++" + keyId
   // println "__________" + id

    def ref1=ExceptionRef.findById(keyId)
    def product2=ref1.product

     def key=ref1.key
     ref1.category=category;
     ref1.description=description;
     ref1.product=product2;
     ref1.resolution=resolution;
     ref1.save()
     def ref2=ExceptionRef.findById(keyId)
     def category1=ref2.category
     def description1=ref2.description
     def resolution1=ref2.resolution
     //def link=g.createLink(controller : "logCase",action : "summary", params : [ id : caseId])
     HashMap<String,Object> hm =new HashMap<String,Object>();
     def link1=g.createLink(controller : "logCase",action : "category3", params : [ green : "green" ])

    // hm.put("0",link)
     hm.put("1",key)
     hm.put("2",category1)
     hm.put("3",description1)
     hm.put("4",resolution1)
     hm.put("5",product2)
     hm.put("back",link1)
     println "======" + category1
     Map<String, Float> map = new TreeMap<String, Float>(hm);
     [black:hm]

}


def show3()
{
    def category=params.category
    def description=params.description
    def resolution=params.resolution
   def keyId=params.caseId
    //def id=params.ref
    println "+++++++++++" + keyId
   // println "__________" + id

    def ref1=ExceptionRef.findById(keyId)
    def product2=ref1.product

     def key=ref1.key
     ref1.category=category;
     ref1.description=description;
     ref1.product=product2;
     ref1.resolution=resolution;
     ref1.save()
     def ref2=ExceptionRef.findById(keyId)
     def category1=ref2.category
     def description1=ref2.description
     def resolution1=ref2.resolution
     //def link=g.createLink(controller : "logCase",action : "summary", params : [ id : caseId])
     HashMap<String,Object> hm =new HashMap<String,Object>();
     def link1=g.createLink(controller : "logCase",action : "category2", params : [ red : "red" ])

    // hm.put("0",link)
     hm.put("1",key)
     hm.put("2",category1)
     hm.put("3",description1)
     hm.put("4",resolution1)
     hm.put("5",product2)
     hm.put("back",link1)
     println "======" + category1
     Map<String, Float> map = new TreeMap<String, Float>(hm);
     [black:hm]

}

def edit2()
{
def pro=params.product
println pro
respond hm
} 
 protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'logCase.label', default: 'LogCase'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
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

}
