package com.binmma.jvm;

import org.junit.Test;

public class Jvm {
	@Test
	public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Object object = new Object();
		String string = new String();
		System.out.println(string.getClass().getClassLoader());
		System.out.println(object.getClass().getClassLoader());
		Class<?> forName = Class.forName("sun.security.ec.SunEC");
		Object object2 = forName.newInstance();
		System.out.println(forName.getClassLoader());
		Jvm jvm = new Jvm();
		System.out.println(jvm.getClass().getClassLoader());
		
		String string2 = new String();
	}

}
