package leetcode.project;

public class MultipleOf3or5 {
	static int sum=0;
	
	public static int sumOfMultiples() {
		for(int i=1;i<1000;i++) {
			if(i%3==0 || i%5==0) {
				sum=sum+i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(sumOfMultiples());

	}

}
