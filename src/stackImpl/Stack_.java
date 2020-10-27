package stackImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Stack_ {
	
	static int size = 30;
	int[] t = new int[size];

	int[] start = new int[] { -1, -1, -1 };
	int[] end = new int[] { -1, -1, -1 };

	public Stack_() {
		Arrays.fill(t, -1);
		int n = size / 3;
		start[0] = 1;
		end[0] = n;

		start[1] = end[0] + 1;
		end[1] = start[1] + n - 1;

		start[2] = end[1] + 1;
		end[2] = start[2] + n - 1;
	}

	public void push(int x, int stack_number) throws Exception {
		if (start[stack_number] <= end[stack_number]) {
			t[start[stack_number]] = x;
			start[stack_number]++;
		} else {
			throw new StackOverflowError();
		}
	}

	public void pop(int stack_number) throws Exception {

		int e = start[stack_number]-1;
		
		if (e > 0) {
			switch (stack_number) {
			case 0:
				if (e > 0) {
					t[start[stack_number]-1] = -1;
					start[stack_number] = e - 1;
				} else {
					throw new StackOverflowError();
				}
				break;
			case 1:
				if (e > end[0]) {
					t[start[stack_number]-1] = -1;
					start[stack_number] = e - 1;
				} else {
					throw new StackOverflowError();
				}
				break;
			case 2:
				if (e > end[1]) {
					t[start[stack_number]-1] = -1;
					start[stack_number] = e - 1;
				} else {
					throw new StackOverflowError();
				}
				break;
			}
		}
	}

	public static void main(String args[]) {
		Stack_ stk1 = new Stack_();
		try {
			stk1.push(100, 0);
			stk1.push(101, 1);
			stk1.push(102, 2);
			stk1.pop(1);
			stk1.pop(1);
			stk1.pop(2);
			System.out.println(Arrays.toString(stk1.t));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
