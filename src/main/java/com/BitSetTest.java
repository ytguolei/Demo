package com;

import java.util.BitSet;

public class BitSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long beforeMemory = Runtime.getRuntime().totalMemory();  
		int[] array = new int[] {1,2,3,22,4,3,23};
		BitSet bitSet = new BitSet(7);
		// 将数组内容组bitmap
		for (int i = 0; i < array.length; i++) {
			bitSet.set(array[i], true);
		}
		long afterMemory  = Runtime.getRuntime().totalMemory();
		System.out.println("总共内存使用:" + (afterMemory - beforeMemory));
		System.out.println("总共内存使用:" + (afterMemory - beforeMemory) / 1024 / 1024 + "MB");
		for (int i = 0; i < bitSet.length(); i++) {
			System.out.println(i+"====="+bitSet.get(i));
		}
		System.out.println(bitSet.length());
		System.out.println(bitSet.size());
		System.out.println(bitSet.get(3));
	}

}
