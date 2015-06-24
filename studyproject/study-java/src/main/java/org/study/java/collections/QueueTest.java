package org.study.java.collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.add("snail");
		
		queue.offer("Merry");
		queue.offer(null);
		System.out.println("Queue: "+queue);
	}
}
