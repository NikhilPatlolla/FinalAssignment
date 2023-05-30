package com.nikhil.InterfaceClass;

public class IclassInterfaceImpl implements IclassInterface {

	@Override
	public void aPrintMethod() {
		System.out.println("A method implementation given by the class that implemented the interface");

	}

	@Override
	public int anotherMethodAdd(int x, int y) {
		System.out.println(
				"sometimes interface's abstract methods tells us what to do, the how to do part can be implemented by the 3rd party classes that implement these interfaces");
		return x + y;
	}

}
