package telran.util;

import java.util.List;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackInt {

	LinkedList<Integer> list = new LinkedList<Integer>();
	Integer max = null;

	// complexity of all methods [1]
	public void push(int num) {
		if (!list.isEmpty() && max < num || list.isEmpty()) {
			max = num;
		}
		list.addFirst(num);
	}

	public int pop() {
		// return a number from a top of stack or throw noSuchELementException
		// if stack is empty
		if (list.isEmpty())
			throw new NoSuchElementException();
		int res = list.removeFirst();
		if (!list.isEmpty() && res == max) {
			max = list.getFirst();
		}
		return res;
	}

	public boolean isEmpty() {
		// returns true if the stack is empty, otherwise false
		return list.isEmpty();
	}

	public int getMax() throws Exception {
		// return maximal value of the stack or throw noSuchELementException
		// if stack is empty
		if (list.isEmpty())
			throw new NoSuchElementException();
		return max;
	}
}
