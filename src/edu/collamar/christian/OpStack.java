/**
 * ABBREVIATOIN OF OPERATION STACK (stack used for operations)
 */

package edu.collamar.christian;

public class OpStack {

	public int top;
	private char[] stackArray;
	
	public OpStack(char input) {
		top = -1;
		stackArray = new char[100];
		this.push(input);
	}
	
	public void push(char operation) {
		stackArray[++top] = operation;
	}

	public char pop() {
		return stackArray[top--];
	}
	
	public char peek() {
		return stackArray[top];
	}

	public boolean topHasMorePriorityThan(char test) {
		return (stackArray[top] != '(' &&
				(stackArray[top] == 'q' || stackArray[top] == 's' || stackArray[top] == 'c' || stackArray[top] == 't') ||
				(stackArray[top] == test) || (stackArray[top] == '^') || 
				((stackArray[top] != test) && ((stackArray[top] == '*' || stackArray[top] == '/') && (test == '+' || test == '-'))));
	}

}