package ocpjp;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueBasics {

	public static void main(String[] args) {
		Queue<String> list = new PriorityQueue<String>();
		list.add("RockInExams");
		list.add("Java");
		// Queue poll() method pull elements,Retrieves and removes the head of this queue, or returns null if this queue is empty.
		System.out.println(list.poll() + "::" + list.poll() + " " + list.poll()); // Output: Java::RockInExams null
	}
}
/*
poll(): retrieves and removes the head of this queue, or null if this queue is empty.

peek(): retrieves, but does not remove, the head of this queue, returning null if this queue is empty.

offer(): inserts the specified element into this priority queue.
*/