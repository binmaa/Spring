package com.binmma.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.junit.Test;

public class MyList {
	static class BadStr{
		static String str = new String(new char[100000000]);
		public static String getStr(int begin,int end){
			return new String(str.substring(begin, end));
		}
	}
	@Test
	public void equals(){
		MyObject myObject = new MyObject(1);
		MyObject myObject2 = new MyObject(2);
		System.out.println(myObject==myObject2);
		
	}
	@Test
	public void string(){
		long start = System.currentTimeMillis();
//		StringBuffer buffer = new StringBuffer();
		String str = null;
		for(int i=0;i<10000;i++){
//			buffer.append(i).append(";");
			str=str+i+";";
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	@Test
	public void ddq(){
		ArrayList<String> arrayList = new ArrayList<String>();
		
		for (int i = 0; i < 1000000; i++) {
			arrayList.add(BadStr.getStr(1, 5));
		}
		
		
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		HashMap<MyObject, MyObject> hashMap = new HashMap<MyObject,MyObject>();
//		MyObject myObject = new MyObject(1);
//		MyObject myObject2 = new MyObject(2);
//		hashMap.put(myObject, new MyObject(1));
//		hashMap.put(myObject2, new MyObject(2));
//		hashMap.put(new MyObject(3), new MyObject(3));
		HashMap<Object, Object> hashMapI = new HashMap<Object, Object>();
		for(int i = 0 ; i<99;i++){
			hashMapI.put(new String(String.valueOf(i)), 1);
		}
		for (MyObject myObjectvalue : hashMap.keySet()) {
			
		}
		Iterator<Entry<MyObject, MyObject>> iterator2 = hashMap.entrySet().iterator();
		
//		MyObject myObject3 = hashMap.get(myObject);
//		MyObject myObject22 = hashMap.get(myObject2);
//		MyObject myObject1 = hashMap.get(new MyObject(1));
		HashMap<String, String> hashMap2 = new HashMap<>();
		hashMap2.put("1", "1");
		hashMap2.put("2", "2");
		System.out.println();
		LinkedList<Object> list = new LinkedList<>();
//		ArrayList<Object> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator<Object> iterator = list.iterator();
		while(iterator.hasNext()){
			Object next = iterator.next();
			System.out.println(next);
		}
	}

}
