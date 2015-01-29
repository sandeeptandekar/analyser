package com
import java.util.ArrayList;
import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib

class ExceptionRef {

	String key
        String category
	String description
	String resolution
	String caseId
	static belongsTo = [product:Product]
	
    static constraints = {
		//key(blank:false, unique:['key','product'])
               
		category(blank:false)
		description(nullable: true)
		resolution(nullable: true)
    }
	
	static mapping = {
		version false;
		description type:'text';
		resolution type:'text';
                category type:'text';
                key type:'text';
                key index:'exception_ref_product_id_key_key';
               

	}
public static fetchAllCategory(){
               String black="BLACK"
               String red="red"
               String green="green"
           ArrayList<String> ar=new ArrayList<String>();
                  ar.add(black)
                  ar.add(red)
                  ar.add(green)
                  return ar
		//return Product.list().collect { it.name + "-" + it.productVersion}
	}

}
