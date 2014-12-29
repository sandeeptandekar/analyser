package com

class Product {
	
	String name
	String productVersion
	
    static constraints = {
    }
	
	public static fetchAllProduct(){
		return Product.list().collect { it.name + "-" + it.productVersion}
	}
	
	public String toString(){
		return name + "-" + productVersion
	}
}
