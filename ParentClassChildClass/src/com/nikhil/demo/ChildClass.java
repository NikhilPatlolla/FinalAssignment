package com.nikhil.demo;

public class ChildClass extends ParentClass {
	
	public ChildClass(){
		// to invoke the parent class constructor we need to make use of the parent class' constructor, which can be accessed through super()
		super();
		System.out.println("This is a child class constructor");
		//super(); causes Compile time error. Should be the first line in the child class' constructor
	}
}

