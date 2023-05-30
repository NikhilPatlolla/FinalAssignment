package com.nikhil.abstractionClass;

//since abstract class can only be extended by a child class, all the methods that are abstract need to be implemented by the child class
public abstract class AnAbstractclass {

	private String instanceVariable;

	public AnAbstractclass(String instanceVariable) {
		this.instanceVariable = instanceVariable;
	}

	// classes extending the
	public abstract void abstractMethod();

	public void abstractDefinedMethod() {
		System.out.println("ChildClass: This method can be used by the classes that extend this abstract class");
		System.out.println(
				"This class for instance can have constructors and can have instance variables " + instanceVariable);
	}
}
