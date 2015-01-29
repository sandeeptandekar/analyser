package com

class LogCases {


	String ticketUrl
	Date dateCreated
	Date lastUpdated
	String uploadedFilePath
        static belongsTo = [product:Product]
    static constraints = {
ticketUrl(nullable: true)
    }
static mapping = {
		version false
	}
}
