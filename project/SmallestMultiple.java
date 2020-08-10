package leetcode.project;

public class SmallestMultiple {
	
	public static int smallestPositiveMultiple(int n1, int n2) {
		int highestMultiple=1;		
		int diff=(n2-n1)+1;
		for(int i=n1; i<=n2;i++) {
			highestMultiple=highestMultiple*i;
			int count=0;
			int a=n1;
			while(a!=n2 && highestMultiple%a==0) {				
					count++;
					a++;
			}
			if(count==diff)
				break;
		}
		return highestMultiple;
	}

	public static void main(String[] args) {
	   System.out.println(smallestPositiveMultiple(1,10));

	}

}
