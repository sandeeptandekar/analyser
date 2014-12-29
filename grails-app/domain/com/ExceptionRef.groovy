package com

class ExceptionRef {

	String key
	String category
	String description
	String resolution
	
	static belongsTo = [product:Product]
	
    static constraints = {
    }
}
