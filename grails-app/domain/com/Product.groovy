package com

class Product {
	
	String name
	String productVersion
	
    static constraints = {
		name(blank:false, unique:['productVersion', 'name'])
		productVersion(blank:false)
    }
	
	static mapping = {
		version false
	}
	
	public static fetchAllProduct(){
		return Product.list().collect { it.name + "-" + it.productVersion}
	}
	
	public String toString(){
		return name + "-" + productVersion
	}
}
