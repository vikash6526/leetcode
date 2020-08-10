package leetcode.project;

import java.util.HashMap;

public class ContiguousArray {

	public static int findMaxLength1(int[] nums) {
		int result = 0;
		int b1 = 0;
		int b2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0 && b1 == 0) {
				while (i < nums.length && nums[i] == 0) {
					b1++;
					i++;
					if (b1 == b2) {
						result = Math.max(result, b1 + 2);
						b1 = 0;
						b2 = 0;
					}
				}
			}
			if (nums[i] == 1 && b2 == 0) {
				while (i < nums.length && nums[i] == 1) {
					b2++;
					i++;
					if (b1 == b2) {
						result = Math.max(result, b2 + b1);
						b1 = 0;
						b2 = 0;
					}
				}
			}
		}
		return result;
	}
	
	public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sum = new HashMap<>();
        int s = 0;
        int longest = 0;
        sum.put(0, -1); // put 0 to the left
        for(int i = 0;i < nums.length;++i) {
            if(nums[i] == 0) {
                s += -1;
            } else {
                s += 1;
            }           
            if(sum.containsKey(s)) {
                longest = Math.max(longest, i - sum.get(s));       
            } else {
                sum.put(s, i);
            }
        }        
        return longest;
    }

	public static void main(String[] args) {
		System.out.println(findMaxLength(new int[] { 0,1,0,1,0,1,0,0,1}));
	}

}
