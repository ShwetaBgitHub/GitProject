package com.velocity.collections;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList();
		list.add("maths");
		list.add("english");
		
		list.add("biology");
		
		list.add("physics");
		
		System.out.println("list of subjects "+list);
		
	}

}
