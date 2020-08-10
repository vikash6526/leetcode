package leetcode.project;

public class SumOfEvenFibonacci {
	
	public static int add() {
		int sum=0;
		int evensum=0;
		int d1=1,d2=1;
		while(d1<=4000000) {
			if(d1%2==0) {
				evensum=evensum+d1;
			}
			sum=d1+d2;
			d1=d2;
			d2=sum;
		}
		return evensum;
	}

	public static void main(String[] args) {
		System.out.println(add());

	}

}
