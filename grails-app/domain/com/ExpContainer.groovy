package com

class ExpContainer {

	String title
	
	static belongsTo = [logCase:LogCase]
	
	static hasMany = [logException:LogException]
	
    static constraints = {
		title(blank:false)
    }
	static mapping = {
		version false
	}
}
