/**
 * ABBREVIATOIN OF NUMERICAL STACK (stack used for numbers)
 */

package edu.collamar.christian;

public class NumStack {

	private int top;
	private double[] stackArray;

	public NumStack() {
		top = -1;
		stackArray = new double[100];
	}

	public void push(double num) {
		stackArray[++top] = num;
	}

	public double pop() {
		return stackArray[top--];
	}

	public double peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top <= 0);
	}
}
