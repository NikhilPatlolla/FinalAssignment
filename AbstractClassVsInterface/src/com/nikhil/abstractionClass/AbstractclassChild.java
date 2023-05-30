package com.nikhil.abstractionClass;

public class AbstractclassChild extends AnAbstractclass{

	public AbstractclassChild(String instanceVariable) {
		super(instanceVariable);
	}

	@Override
	public void abstractMethod() {
		System.out.println("AbstractClass: The implemenatation of the abstact method from the parent's abstract class");
	}
	
	
}
