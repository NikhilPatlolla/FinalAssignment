package com.nikhil.InterfaceClass;

public interface IclassInterface {
	// by default all the methods in interface are public and abstract
	// can have variables, by default they are final and static, since they are
	// static they can be accessed using the Interface's reference
	int value = 8;

	void aPrintMethod();

	int anotherMethodAdd(int x, int y);

}
