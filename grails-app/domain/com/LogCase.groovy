package com

class LogCase {
	
	String ticketUrl
	Date dateCreated
	Date lastUpdated
	String uploadedFilePath

	
	static hasMany = [expContainer:ExpContainer]
	static belongsTo = [product:Product]
	
    static constraints = {
    }
}
