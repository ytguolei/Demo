package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combination {
	
	static int size;
	static int count;
	static char[] arrChar = new char[100];

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.print("Enter a word: "); // get word
		String input = getString();
		size = input.length(); // find its size
		count = 0;
		for (int j = 0; j < size; j++) // put it in array
			arrChar[j] = input.charAt(j);
	}
	
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

}
