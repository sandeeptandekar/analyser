package files;
import java.io.IOException;

import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.util.*;
import java.io.*;
import java.util.Map.Entry;
//import java.util.comparator;

public class Code {
	public static String parentDirectory = "/home/kavitha/project/files";
	public static String fileExtension = ".zip";
	public static String condition = ".log";
	static String upperCase = "Exception";
	static String lowerCase = "exception";
	static String atCom = "at com";
	static String atJava = "at java";
        static String stack="Thread";
        static String stack2="PipeTransporter"; 
        static String at="at";
        static String lang="lang";
        static String run="run(";
        static String atOrg="at org";
        static String atScript="at script";
        static String atSun="at sun";
        static String atJavax="at javax";
//This method is to list all files with .log extension
	public void getUnZipFiles(String path) throws IOException,
			NullPointerException {
		ArrayList<String> data = new ArrayList<String>();
//An object for filter class is created.
		FileFilter fileFilter = new FileFilter(fileExtension);
File parentDir = new File(path);
		// Put the names of all files ending with .zip in a String array
		String[] listOfZipFiles = parentDir.list(fileFilter);
		if (listOfZipFiles.length == 0) {
			System.out.println("There are no zip files in this direcotry!");
			
		}

	//This loop unzip's the file
		for (String file : listOfZipFiles) {

			// construct the absolute file paths..
			String absoluteFilePath = new StringBuffer(path).append(File.separator).append(file).toString();
			//String destDir = "/home/kavitha/project/files";
			java.util.jar.JarFile jar = new java.util.jar.JarFile(absoluteFilePath);
			java.util.Enumeration enumEntries = jar.entries();
			while (enumEntries.hasMoreElements()) {
				java.util.jar.JarEntry file1 = (java.util.jar.JarEntry) enumEntries
						.nextElement();
				java.io.File f = new java.io.File(path
						+ java.io.File.separator + file1.getName());
				if (file1.isDirectory()) { // if its a directory, create it
					f.mkdir();
					continue;
				}
				java.io.InputStream is = jar.getInputStream(file1); // get the input stream
																				java.io.FileOutputStream fos = new java.io.FileOutputStream(f);
				while (is.available() > 0) { // write contents of 'is' to 'fos'
					fos.write(is.read());
				}
				fos.close();
				is.close();
			}
		}
}
//This method returns a hashMap that as key as file path of the folders and value as the new file created for that folder with all thelog files content.For each folder a new file will be created and that file is stored as value for that folder.
public HashMap<String,String> getAllLogFiles(File mainFolder,String path) throws IOException,NullPointerException
{
ArrayList<String> data = new ArrayList<String>();
File parentDir = new File(path);
HashMap<String,String> hm15=new HashMap<String,String>();
	getUnZipFiles(path);
	File files[];
		FileFilter fileFilter1 = new FileFilter(condition);
	String absolutePath2="";
String absoluteFilePath="";
String absoluteFilePath1="";
String name="";
		String[] listOfLogFiles = parentDir.list(fileFilter1);
		for (File file : mainFolder.listFiles() ) {
                           if(file.isDirectory())
{
 absoluteFilePath1 = (file.getAbsolutePath()).toString();
                        data.add(absoluteFilePath1);

//File[] f2=file.listFiles();
           for(File file2 : file.listFiles())
{
                      if(file2.isDirectory())
{
			absoluteFilePath1 = (file2.getAbsolutePath()).toString();
                        data.add(absoluteFilePath1);
                        
		
}
}

}
}
System.out.println(data);
FileChannel inputChannel = null;
 FileChannel outputChannel = null;
for( String new1: data)
{
File new2=new File(new1);
File[] file2 = new2.listFiles();
Arrays.sort(file2, new Comparator<File>() { 
    public int compare(File f1, File f2) {
        return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
    }
});

for(File file:file2)
{
System.out.println(file);
System.out.println(file.getName()+"\t"+new Date(file.lastModified()));  
                           if(!file.isDirectory())
{
if(file.getName().endsWith(".log"))
{
			String absoluteFilePath5 = (file.getAbsolutePath()).toString();
			//data.add(absoluteFilePath1);//".log" files are stored in ArrayList
                         System.out.println(absoluteFilePath5);
 inputChannel = new FileInputStream(absoluteFilePath5).getChannel();
                         //BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath5));
                         File root=new File(new1);
                         String d="new";
                         File f1=new File(root,d);
                         f1.createNewFile();
                         absoluteFilePath=(f1.getAbsolutePath()).toString();
                         //FileWriter out=new FileWriter(absoluteFilePath);
                           outputChannel = new FileOutputStream(absoluteFilePath,true).getChannel();
                        
                outputChannel.position( outputChannel.size() );
inputChannel.transferTo(0, inputChannel.size(), outputChannel);
inputChannel.close();
outputChannel.close();

                hm15.put(new1,absoluteFilePath);
                       
}		}
else
{
//data.addAll(getAllLogFiles(file,path));
  
}
}

}	
		
//System.out.println(data);

/*System.out.println("summary ==================");
                        for (String entry : hm15.keySet()) {
                                System.out.println("Key = " + entry + ", Value = "
                                               + hm15.get(entry));}*/

		return hm15;
	}
//This method returns a list of lists of each folder.
	public List<Object> parseLogFiles(File mainFolder,String path)
			throws IOException {
                        List<Object> hmArray=new ArrayList<Object>();
                        List<Object> hm2 = parseSingleLogFile(path);
			hmArray.addAll(hm2);
return hmArray;
	}
//This method analyse the single file that as content of all the log files in that particular folder.
public List<Object> parseSingleLogFile(String src)  throws IOException
 {
//To read a file line by line
BufferedReader br = new BufferedReader(new FileReader(src));
String line = br.readLine();
int lineNumber = 0;
int count=0;
String extractedText="";
String stackTrace="";
String exceptionLineNo="";
int exceptionLine=0;
String occurence="";
boolean start=false;
int stackLine=0;
int check=0;
int equate=0;
int limit=7;
int st=0;
HashMap<String,Integer> hm=new HashMap<String,Integer>();
HashMap<String,Integer> hm1=new HashMap<String,Integer>();
List<Object> l=new ArrayList<Object>();
try
{
while(line != null)
{
lineNumber++;
            int index1 =line.indexOf(upperCase);
            int index2=line.indexOf(lowerCase);
            int index3=line.indexOf(atCom);
            int index4=line.indexOf(atJava);
            int index5=line.indexOf(stack);
            int index6=line.indexOf(stack2);
            int index7=line.indexOf(at);
            int index8=line.indexOf(lang);
            int index10=line.indexOf(run);
            int index11=line.indexOf(atOrg);
            int index12=line.indexOf(atSun);
            int index13=line.indexOf(atScript);
            int index14=line.indexOf(atJavax);
//check++;
if((index1 !=-1) || (index2 !=-1))
{
start=true;
//System.out.println(upperCase + " found in line " + lineNumber );
//The line which has the keyword "Exception" or "exception" is assigned to a variable
extractedText = line;
exceptionLine=lineNumber;
 exceptionLineNo=Integer.toString(lineNumber);
//THe whole line is printed
if(hm1.containsKey(extractedText))
{
count=(Integer)hm1.get(extractedText);
count++;
hm1.put(extractedText,count);
}
else
{
//line is added to the hashmap
hm1.put(extractedText,1);
}

occurence=exceptionLineNo+"------"+src;
//System.out.println(extractedText);
check=0;
equate=check;
//System.out.println(st);
st=0;
//System.out.println(st);
}
equate++;
st++;
if((start ==true))
{
//System.out.println(st);
stackLine=lineNumber;
//if((stackLine-lineNumber) <3)
//{
if((index3 != -1) || (index4 != -1) || (index11 !=-1) || (index12 !=-1))
{
stackTrace=stackTrace+"\n"+line+"\n";
st=0;
}
if(((index7 != -1) && ((index3 != -1)&&(index6 != -1)) || ((index4 !=-1) && ((index5 != -1) && ((index10 !=-1) && (index8 != -1)) )) ||((index14 !=-1)&&(index5 !=-1) && (index10 !=-1))) || (((index5 !=-1) &&(index10 != -1) && (index8 != -1)) && (index4 !=-1)))
{
//The key is taken as both the line and stackTrace.
stackTrace=extractedText+stackTrace;
if(hm.containsKey(stackTrace))
{
count=(Integer)hm.get(stackTrace);
//The count value of the line is incremented
count++;
hm.put(stackTrace,count);
//check=0;
}
else
{
//line is added to the hashmap
hm.put(stackTrace,1);
}

//System.out.println(stackTrace);
count=(Integer)hm.get(stackTrace);
//System.out.println(count);
occurence=exceptionLineNo +"--------" + src;
//System.out.println(occurence);
Integer g =0;
Integer g6=0;
start = false;
if(hm.containsKey(stackTrace))
{
g=hm.get(stackTrace);
l.add(stackTrace);
l.add(g);
//l.add(stackTrace);
l.add(occurence);
exceptionLine=0;
stackLine=0;
stackTrace="";
//count=0;
check=0;
equate=check;
//st=0;
}
}
}

if((st==limit) && (start == true))
{
//System.out.println(st);
Integer g=hm1.get(extractedText);
occurence=exceptionLineNo +"--------" + src;
l.add(extractedText);
l.add(g);
l.add(occurence);
start=false;
st=0;
}

//}

line=br.readLine();
}
br.close();
}

catch(IOException e)
{
System.out.println("Error" + e);
}
/*System.out.println("summary ==================");
                        for (String entry : hm.keySet()) {
                                System.out.println("Key = " + entry + ", Value = "
                                               + hm.get(entry));}
System.out.println("summary ==================");
                        for (String entry : hm1.keySet()) {
                                System.out.println("Key = " + entry + ", Value = "
                                               + hm1.get(entry));}*/

//System.out.println(l);
return l;
}
//This method returns a hashMap that holds all the exception as key and its index value as value .
public HashMap<Object,Object> properHash(File mainFolder,String path)throws IOException
{
List<Object> l5=parseLogFiles(mainFolder,path);
HashMap<Object,Object> hm5=new HashMap<Object,Object>();
for(int k=0;k<l5.size();k+=3)
{
Object a1=l5.get(k);
//System.out.println(a1);
Object a2=l5.indexOf(a1);
//System.out.println(a2);
if(!hm5.containsKey(a1))
{
hm5.put(a1,a2);
}
else
{
hm5.put(a1,a2);
}
}

/*System.out.println("summary ==================");
                        for (Object entry : hm5.keySet()) {
                                System.out.println("Key = " + entry + ", Value = "
                                               + hm5.get(entry));
}*/
return hm5;
}
//This method returns a list that has correct count of each exception and its file path.
public List<Object> properList(File mainFolder,String path)throws IOException
{
List<Object> l7=parseLogFiles(mainFolder,path);
HashMap<Object,Object> hm6=properHash(mainFolder,path);
HashMap<Object,Object> hm7=new HashMap<Object,Object>();

List<Object> l6=new ArrayList();
//int j=0;
Integer h2=(Integer)l7.size();
//System.out.println(h2);
for(int j=0;j<h2;j+=3)
{
Object a1=l7.get(j);
//System.out.println(a1);
Object a2=l7.indexOf(a1);
Integer a3=0;
if(l7.contains(a1))
{
if(hm7.containsKey(a1))
{
Integer a9=(Integer)hm7.get(a1);
a9++;
Object a10=(Object)a9;
hm7.put(a1,a10);
}
else
{
hm7.put(a1,1);
}
}
}

HashMap<Object,Object> hm11=new HashMap<Object,Object>();
for(int u=0;u<h2;u+=3)
{
String u5="";
Object u1=l7.get(u);
String u2=(String)l7.get(u+2);
if(l7.contains(u1))
{
if(hm11.containsKey(u1))
{
Object u3=hm11.get(u1);
String u4=(String)u3;
u4=u4+"||"+u2;
hm11.put(u1,u4);
}
else
{
 u5=u2;
hm11.put(u1,u5);
}
}
}


for(int y=0;y<h2;y+=3)
{
Object f1=l7.get(y);

if(hm7.containsKey(f1))
{
//if(hm9.containsKey(f1))
//{
if(hm11.containsKey(f1))
{
Object f2=hm7.get(f1);
//Object f3=hm9.get(f1);
Object f6=hm11.get(f1);
if(!l6.contains(f1))
{
l6.add(f1);
l6.add(f2);
//l6.add(f3);
l6.add(f6);
}
}
}
}
//}
System.out.println(l6);
return l6;

}
 
public static void main(String[] args) throws IOException,
			NullPointerException {
		Code l = new Code();
		String path= "/home/kavitha/testing2";
                String path1="/home/kavitha/testing/hello/new";
                File mainFolder=new File(path);
		//l.analyseLog(mainFolder);
               HashMap<String,String> hm21=l.getAllLogFiles(mainFolder,path);
               //l.parseLogFiles(mainFolder,path);
System.out.println("summary ==================");
                      /*  for (String entry : hm21.keySet()) {
                                System.out.println("Key = " + entry + ", Value = "
                                               + hm21.get(entry));}
                  for(String entry5:hm21.keySet())
{
String path2=hm21.get(entry5);
System.out.println(path2);
                   l.properList(mainFolder,path2);
}*/
//l.parseSingleLogFile(path1);
//l.properList(mainFolder,path1);
//l.correctList(path1);
                	//l.parseLogFiles(mainFolder,path);}
//l.getAllLogFiles(mainFolder,path);
}
}
