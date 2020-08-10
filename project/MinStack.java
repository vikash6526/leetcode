package leetcode.project;


class MinStack {

	public final int MAX = 1000;

	int a[] = new int[MAX];
	
	public int topOfStack;

	public MinStack() {
		topOfStack = -1;
	}

	public void push(int x) {
		if (topOfStack < (MAX - 1)) {
			a[++topOfStack] = x;
		}
	}

	public void pop() {
		if (topOfStack >= 0) {
			topOfStack--;
		}
	}

	public int top() {
		return a[topOfStack];
	}

	public int getMin() {
		int top = topOfStack;
		int min = Integer.MAX_VALUE;
		while (top >= 0) {
			min = Math.min(min, a[top]);
			top--;
		}
		return min;
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(2147483646);
		System.out.println(stack.getMin());
		stack.pop();
		stack.push(2147483647);
		System.out.println(stack.getMin());
	}

}
