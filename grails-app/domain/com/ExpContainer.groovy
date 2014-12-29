package com

class ExpContainer {

	String title
	
	static belongsTo = [logCase:LogCase]
	
	static hasMany = [logException:LogException]
    static constraints = {
    }
}
