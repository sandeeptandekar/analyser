package com

class SingleLog {
ExceptionRef expRef
	int frequency
	String logFilePath
	
	static belongsTo = [expContainer:ExpContainer]
    static constraints = {
    }

static mapping = {
		version false
	}
}
