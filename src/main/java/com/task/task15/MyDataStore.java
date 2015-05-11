package com.task.task15;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * My structure of storing values
 * 
 * @author Sergey
 */
class MyDataStore {

	private TreeSet<Double> numbers;
	private double closestValue;
	private int closestIndex;

	public MyDataStore() {
		numbers = new TreeSet<Double>();
	}

	public boolean isEmpty() {
		return numbers.isEmpty();
	}

	public boolean add(Double num) {
		return numbers.add(num);
	}

	public boolean remove(Double num) {
		return numbers.remove(num);
	}

	public Double pollFirst() {
		return numbers.pollFirst();
	}

	public Double pollLast() {
		return numbers.pollLast();
	}

	public Double searchForClosestNumberValue(Double num) {
		closestNumber(num);

		double numToReturn = 0.0;
		if (closestIndex >= 0) {
			numToReturn = closestValue;
			closestValue = 0.0;
		}

		return numToReturn;
	}

	public int searchForClosestNumberIndex(Double num) {
		closestNumber(num);

		int indexToReturn = -1;
		if (closestIndex >= 0) {
			indexToReturn = closestIndex;
			closestIndex = -1;
		}

		return indexToReturn;
	}

	@Override
	public String toString() {
		return numbers.toString();
	}

	/**
	 * It's a simple algorythm which searches through tree for a closest number.
	 * But I've added some optimization: when we get first 'fasle' in
	 * comparison, we break the loop, because next values will have larger
	 * difference (that's because of order of treemap).
	 * 
	 * @param num
	 *            value to search closest for
	 */
	private void closestNumber(Double num) {
		double minDifference = numbers.last();
		Iterator iterator = numbers.iterator();
		int i = 0;

		while (iterator.hasNext()) {
			double temp = (Double) iterator.next();

			if (Math.abs(temp - num) < minDifference) {
				minDifference = Math.abs(temp - num);
				closestValue = temp;
				closestIndex = i;
			} else {
				break;
			}

			++i;
		}
	}
}
