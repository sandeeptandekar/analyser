package com

class ExceptionRef {

	String key
	String category = "BLACK"
	String description
	String resolution
	
	static belongsTo = [product:Product]
	
    static constraints = {
		key(blank:false, unique:['key','product'])
		category(blank:false)
		description(nullable: true)
		resolution(nullable: true)
    }
	
	static mapping = {
		version false;
		description type:'text';
		resolution type:'text';
	}
}
