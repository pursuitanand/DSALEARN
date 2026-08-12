/**
 * 
 */
package com.anand.ds.stack;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Stack;

/**
 * @author mishra
 *
 */
public class SortStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	     /* MyStack theStack = new MyStack(10); 
	      theStack.push(10);
	      theStack.push(20);
	      theStack.push(30);
	      theStack.push(40);
	      theStack.push(50);
	      
	      while (!theStack.isEmpty()) {
	         long value = theStack.pop();
	         System.out.print(value);
	         System.out.print(" ");
	      }
	      System.out.println("");*/
		
		Deque<Integer> stackWithArrayDeque = new ArrayDeque<Integer>();
		stackWithArrayDeque.push(-10);
		stackWithArrayDeque.push(20);
		stackWithArrayDeque.push(40);
		stackWithArrayDeque.push(5);
		System.out.println(stackWithArrayDeque);
		System.out.println(sortMyStack(stackWithArrayDeque));
		//Stack<Integer> someStack = new Stack<Integer>();
		 
		
	   }
	private static Deque<Integer> sortMyStack(Deque<Integer> original){
		
		if(original.size() < 1) return null;
		if(original.size() < 2) return original;
		Deque<Integer> stackForSort = new ArrayDeque<Integer>();
		while(!original.isEmpty()){
			int s1 = (int)original.pop();
			while(!stackForSort.isEmpty() && (stackForSort.peek() < s1)){
				original.push(stackForSort.pop());
			}
			stackForSort.push(s1);
		}
		return stackForSort;
	}
	
	
	
	
}
