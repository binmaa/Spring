package com.binmma.prac;

public class ExtendsStatic extends B{
	{
		System.out.println("A");
	}
	static {
		System.out.println("static A");
	}
	public ExtendsStatic() {
		System.out.println("ExtendsStatic A");
	}
	public static void main(String[] args) {
		B b = new ExtendsStatic();
	}
	
	
}
class B {
	{
		System.out.println("B");
	}
	static {
		System.out.println("static B");
	}
	public B() {
		System.out.println("B B");
	}
	
}

