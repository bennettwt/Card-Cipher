/**
 * @author Trey Bennett, Jonathan Prichett
 * CS 241
 * 4/20/20
 */

package test;

import java.io.IOException;

import cipher.ULEmptyStackException;
import cipher.ULStack;

public class Test {
	
	public static void main(String[] args) {
		try {
			ULStack<String> stack = new ULStack<String>();
			stack.top();
		}
		catch(ULEmptyStackException e) {
			System.out.println("Stack Exception Works");
		
		}
		
		try {
			ULStack<String> stack = new ULStack<String>();
			stack.push("One");
			System.out.println(stack.top() == stack.pop());
			stack.pop();
		}
		catch(ULEmptyStackException e) {
			System.out.println("Stack Exception Works");
		
		}
		
		ULStack<String> stack = new ULStack<String>();
		System.out.println(stack.empty());
		System.out.println(stack.size() == 0);
		stack.push("One");
		System.out.println(stack.size() == 1);
		stack.push("Two");
		System.out.println(stack.size() == 2);
		stack.push("Three");
		System.out.println(!stack.empty());
		System.out.println(stack.size() == 3);
		ULStack<String> stackClone = stack.clone();
		
		System.out.println(stack.pop() == stackClone.pop());
		stack.clear();
		System.out.println(stack.empty());
		System.out.println(stack.size() == 0);
		System.out.println(stackClone.size() == 2);
		System.out.println("Two" == stackClone.pop());
		System.out.println("One" == stackClone.pop());
		System.out.println(stackClone.empty());
	}
	

}
