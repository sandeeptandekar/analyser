package com

class LogException {
	
	ExceptionRef expRef
	int frequency
	String logFilePath
	
	static belongsTo = [expContainer:ExpContainer]
	
    static constraints = {
    }
	
	static mapping = {
		version false
                logFilePath type:'text';
                
	}
}
