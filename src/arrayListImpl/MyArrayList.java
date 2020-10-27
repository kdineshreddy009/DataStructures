package arrayListImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Collection;

public class MyArrayList<T> {
	static int capacity = 10;
	transient Object[] elements;
	static int index = 0;

	public <T> MyArrayList() {
		/*
		 * Using Object - read first 5lines of
		 * https://www.techiedelight.com/creating-generic-array-java/
		 */
		this.elements = new Object[capacity];
	}

	public <T> MyArrayList(int customCapacity) {
		if (customCapacity > 0) {
			this.elements = new Object[customCapacity];
		} else if (customCapacity == 0) {
			this.elements = new Object[] {};
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + customCapacity);
		}
	}

	public MyArrayList(Collection<? extends T> c) {
		elements = c.toArray();
		if ((capacity = elements.length) != 0) {
			// c.toArray might (incorrectly) not return Object[] (see 6260652)
			if (elements.getClass() != Object[].class)
				elements = Arrays.copyOf(elements, capacity, Object[].class);
		} else {
			// replace with empty array.
			this.elements = elements;
		}
	}

	public void addElement(Object x) {
		if (index + 1 == capacity) {
			capacity = 2 * capacity;
			elements = Arrays.copyOf(elements, capacity);
		}
		elements[index++] = x;
	}

	public void remove(int removeAtIndex) throws IndexOutOfBoundsException {
		if (removeAtIndex > index) {
			throw new IndexOutOfBoundsException();
		}
		int i = 0;
		for (i = removeAtIndex; i + 1 <= index; i++) {
			elements[i] = elements[i + 1];
		}
		elements[i] = null;
		index--;

		reSizeList();

	}

	private void reSizeList() {
		if (index < ((1 * capacity) / 4)) {
			capacity = capacity / 2;
			System.out.println("cap is " + capacity);
			elements = Arrays.copyOf(elements, capacity);
		}
	}

	public int getSize() {
		return index;
	}

	@Override
	public String toString() {
		String s = "[";
		for (int i = 0; i < index; i++) {
			s = (i == 0) ? (s + elements[i]) : (s + "," + elements[i]);
		}
		s = s + "]";
		return s;
	}

	public static void main(String[] args) {
		MyArrayList<Integer> al = new MyArrayList<>();
		al.addElement(1);
		al.addElement(2);
		al.addElement(3);
		al.addElement(4);
		al.addElement(5);
		al.addElement(6);
		al.addElement(7);
		al.addElement(8);
		al.addElement(9);
		al.addElement(10);
		System.out.println(al.getSize());
		System.out.println(al);
		al.remove(1);
		System.out.println(al.getSize());
		System.out.println(al);
		al.addElement(11);
		System.out.println(al.getSize());
		System.out.println(al);
		al.addElement(12);
		System.out.println(al.getSize());
		System.out.println(al);
		System.out.println(capacity);
		al.remove(10);
		al.remove(1);
		al.remove(1);
		al.remove(1);
		al.remove(1);
		al.remove(1);
		al.remove(1);
		al.remove(1);
		al.remove(1);
		System.out.println(al.getSize());
		System.out.println(al);
		System.out.println(capacity);

	}
}