package com.nikhil.main;

import com.nikhil.InterfaceClass.IclassInterface;
import com.nikhil.InterfaceClass.IclassInterfaceImpl;
import com.nikhil.abstractionClass.AbstractclassChild;
import com.nikhil.abstractionClass.AnAbstractclass;

public class AbstractVsInterface {
	public static void main(String[] args) {
		// the reference can be of the abstract type as it is the parent of the child
		// class that implemented the abstract class
		AnAbstractclass abstChild = new AbstractclassChild("hello");
		abstChild.abstractDefinedMethod();
		abstChild.abstractMethod();
		
		
		IclassInterface interfaceImpl = new IclassInterfaceImpl();
		int value = interfaceImpl.anotherMethodAdd(3, 5);
		System.out.println(value);
		
		interfaceImpl.aPrintMethod();
		
		System.out.println("Since our interface has a filed, we can access it from the interface directly "+ IclassInterface.value);
	}
}
