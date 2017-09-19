package com.stack;

public class Stack {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackX theStack = new StackX(10);
	}

}

class StackX{
	
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public StackX(int s){
		this.maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	
	public void push(long j){
		stackArray[++top] = j;
	}
	
	public long pop(){
		return stackArray[top--];
	}
	
	public long peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top==-1);
	}
	
	public boolean isFull(){
		return (top==maxSize);
	}
}