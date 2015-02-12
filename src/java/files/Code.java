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
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
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
	static String traceBack="TraceBack";
	static String filePy="File";
	static String engine="engine";
	static String awt="awt";
	//This method is to list all files with .log extension
	public void getUnZipFiles(String path,String path2) throws IOException,
	NullPointerException {
		ArrayList<String> data = new ArrayList<String>();
		//An object for filter class is created.
		FileFilter fileFilter = new FileFilter(fileExtension);
		File parentDir = new File(path);
		// Put the names of all files ending with .zip in a String array
		String[] listOfZipFiles = parentDir.list(fileFilter);
		// System.out.println(listOfZipFiles);
		//	if (listOfZipFiles.length == 0) {
		System.out.println("There are no zip files in this direcotry!");

		//	}
		byte[] buffer = new byte[1024];

		try{

			//create output directory is not exists
			//	File folder = new File(OUTPUT_FOLDER);
			//	if(!folder.exists()){
			//		folder.mkdir();
			//	}

			//get the zip file content
			ZipInputStream zis = 
					new ZipInputStream(new FileInputStream(path));
			//get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();

			while(ze!=null){
				//String path2="/home/kavitha/testing7";
				String fileName = ze.getName();
				File newFile = new File(path2 + File.separator + fileName);

				System.out.println("file unzip : "+ newFile.getAbsoluteFile());
				if (ze.isDirectory()){
					newFile.mkdirs();
				}else{
					new File(newFile.getParent()).mkdirs();
					//newFile.createNewFile();
					//create all non exists folders
					//else you will hit FileNotFoundException for compressed folder
					//new File(newFile.getParent()).mkdirs();
					newFile.createNewFile();
					FileOutputStream fos = new FileOutputStream(newFile);             

					int len;
					while ((len = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}

					fos.close();
				}   
				ze = zis.getNextEntry();
			}

			zis.closeEntry();
			zis.close();

			System.out.println("Done");

		}catch(IOException ex){
			ex.printStackTrace(); 
		}

		//This loop unzip's the file
		/*	for (String file : listOfZipFiles) {
                       System.out.println(file);
			// construct the absolute file paths..
                        //File new1=new File(path,file);
                        //File new2=new File(path,"new");
			String absoluteFilePath = new StringBuffer(path).append(File.separator).append(file).toString();
                        // String absoluteFilePath=new1.getAbsolutePath().toString();
                        System.out.println("-------+++++" + absoluteFilePath);
			//String destDir = "/home/kavitha/project/files";
			java.util.jar.JarFile jar = new java.util.jar.JarFile(absoluteFilePath);
			java.util.Enumeration enumEntries = jar.entries();
                       // System.out.println(enumEntries);
			while (enumEntries.hasMoreElements()) {
				java.util.jar.JarEntry file1 = (java.util.jar.JarEntry) enumEntries
						.nextElement();
                               // String df=file1.getAbsoluteFilePath();
                               // File new1=new File(df);
                               // File ne=new File(new1,"new");
                                 System.out.println("++++++" +file1);
				java.io.File f = new java.io.File(path
						+ java.io.File.separator + file1.getName());
  //File f12=new File(path,"log");
            //f12.mkdir();
				if (file1.isDirectory()) { // if its a directory, create it
					 if (f.exists()) {
                //logger.log(Level.WARNING, "Directory {0} already exists!", entryFile);
                  //f.mkdir();
            } else {
                f.mkdir();
                continue;
            }

				}
                                System.out.println(f);
				java.io.InputStream is = jar.getInputStream(file1); // get the input stream
					System.out.println(is);															java.io.FileOutputStream fos = new java.io.FileOutputStream(f);
                                          System.out.println(fos);
				while (is.available() > 0) { // write contents of 'is' to 'fos'
					fos.write(is.read());
				}
				fos.close();
				is.close();
			}
		}*/
	}


	//It gives the file ending with .log extension
	public HashMap<String,String> getAllLogFiles(File mainFolder,String path,String path2) throws IOException,NullPointerException
	{
		ArrayList<String> data = new ArrayList<String>();
		File parentDir = new File(path);
		HashMap<String,String> hm15=new HashMap<String,String>();
		System.out.println("first" + path);
		//String path2="/home/kavitha/testing7/2015_01_26_15_41_20.zip";
		getUnZipFiles(path2,path);

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
						//System.out.println(absoluteFilePath5);
					}		}
				else
				{
					//data.addAll(getAllLogFiles(file,path));

				}
			}
			//inputChannel.close();
			//outputChannel.close();
		}	

		//System.out.println(data);

		System.out.println("summary ==================");
		for (String entry : hm15.keySet()) {
			System.out.println("Key = " + entry + ", Value = "
					+ hm15.get(entry));}

		return hm15;
	}
	//This method returns a ArrayList of hashmap
	public List<Object> parseLogFiles(File mainFolder,String path)
			throws IOException {
		//ArrayList<String> logFiles=path;//".log" files are stored in arraylist
		List<Object> hmArray=new ArrayList<Object>();

		//for (String filePath : logFiles) {
		List<Object> hm2 = parseSingleLogFile(path);
		hmArray.addAll(hm2);//list of hashmaps are stored in Arraylist
		//}
		//System.out.println(hmArray);
		return hmArray;
	}
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
				int index17=line.indexOf(awt);
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
						stackTrace=stackTrace+line+"\n";
						st=0;
					}
					if(((index7 != -1) && ((index3 != -1)&&(index6 != -1)) || ((index4 !=-1) && ((index5 != -1) && ((index10 !=-1) && (index8 != -1)) )) ||((index14 !=-1)&&(index5 !=-1) && (index10 !=-1))) || (((index5 !=-1) &&(index10 != -1) && (index8 != -1)) && (index4 !=-1)) ||((index4 != -1) && ((index17 != -1) && (index5 !=-1) && (index10 != -1))))
					{
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

						System.out.println(stackTrace);
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
					stackTrace="";
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
		//System.out.println(hm7);
		/*System.out.println("summary ==================");
                        for (Object entry : hm7.keySet()) {
                                System.out.println("Key = " + entry + ", Value = "
                                               + hm7.get(entry));
}*/
		/*HashMap<Object,Object> hm9=new HashMap<Object,Object>();
String stackTrace1="";
for(int j=0;j<h2;j+=3)
{
Object b1=l7.get(j);
String b2=(String)l7.get(j+2);
//String stackTrace1="";
//Integer c1=(Integer)hm7.get(b1);
int u=1;
if(l7.contains(b1))
{
if(hm9.containsKey(b1))
{
//Integer c1=(Integer)hm7.get(b1);
//c1=c1-1;
//if(c1>u)

//Integer c1=(Integer)hm7.get(b1);
//System.out.println(stackTrace1);
//hm9.put(b1,stackTrace1);
Object o2=hm9.get(b1);
String b9=(String)o2;

b9=b9+"\n"+ b2 +"\n";
hm9.put(b1,b9);
//c1--;
//u++;
}


else
{
//Object o2=hm9.get(b1);
//String b2=(String)o2;
stackTrace1=b2;
hm9.put(b1,b2);
}
}

}*/


		/*System.out.println("summary ==================");
                        for (Object entry : hm9.keySet()) {
                                System.out.println("Key = " + entry + ", Value = "
                                               + hm9.get(entry));
}*/
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

		/*System.out.println("summary ==================");
                        for (Object entry : hm11.keySet()) {
                                System.out.println("Key = " + entry + ", Value = "
                                               + hm11.get(entry));
}*/

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
		//System.out.println(l6);
		return l6;

	}

	public static void main(String[] args) throws IOException,
	NullPointerException,FileNotFoundException {
		Code l = new Code();
		String path2= "/home/kavitha/testing4/folder2.zip";
		String path="/home/kavitha/testing4";
		File mainFolder=new File(path);
		//l.analyseLog(mainFolder);
		HashMap<String,String> hm21=l.getAllLogFiles(mainFolder,path,path2);
		//l.parseLogFiles(mainFolder,path);
		System.out.println("summary ==================");
		for (String entry : hm21.keySet()) {
			System.out.println("Key = " + entry + ", Value = "
					+ hm21.get(entry));}
		for(String entry5:hm21.keySet())
		{
			String path3=hm21.get(entry5);
			System.out.println(path2);
			l.properList(mainFolder,path3);
		}
		//l.parseSingleLogFile(path1);
		//l.properList(mainFolder,path1);
		//l.correctList(path1);
		//l.parseLogFiles(mainFolder,path);}
		//l.getAllLogFiles(mainFolder,path);
	}
}
