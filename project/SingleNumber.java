package leetcode.project;

import java.util.Arrays;

public class SingleNumber {
	
	public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int data=nums[i];
            int count=0;
            while(i<nums.length){
                if(data==nums[i]){
                    count++;
                    i++;
                }
                else {
                	i--;
                    break;
                }
            }
            if(count==1)
                return data;
        }
        return 0;
    }

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {4,1,2,1,2}));

	}

}
