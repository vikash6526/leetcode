package leetcode.project;

import java.util.Stack;

public class StockPlanner {
	Stack<Integer> prices, weights;

	public StockPlanner() {
		prices = new Stack();
		weights = new Stack();
	}

	public int next(int price) {
		int w = 1;
		while (!prices.isEmpty() && prices.peek() <= price) {
			prices.pop();
			w += weights.pop();
		}

		prices.push(price);
		weights.push(w);
		return w;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
