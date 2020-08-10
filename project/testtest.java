package leetcode.project;

import java.util.TreeSet;

public class testtest {
	public static int thirdMax(int[] nums) {
		TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);
		for (Integer data : nums)
			set.add(data);
		int count = 0;
		if(set.size()<3)
			return set.first();
		for (Integer data : set) {
			count++;
			if (count == 3)
				return data;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { -2147483648,1, 1 };
		System.out.println(thirdMax(arr));
	}

}
