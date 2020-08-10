package leetcode.project;

public class ProductExceptSelf {
	
    public static int[] productExceptSelf(int[] nums) {
        int product=1;
        int j=0;
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0)
                product=product*nums[i];
            else{
                j=i;
                count++;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(count>1)
               nums[i]=0;
            else if(count==1){
                if(nums[i]==0)
                    nums[i]=product;
                else
                    nums[i]=0;
            }
            else{
                nums[i]=product/nums[i];
            }
        }
        return nums;
    }

	public static void main(String[] args) {
		productExceptSelf(new int[] {1,0});

	}

}
