package leetcode.project;

public class RemoveElement {

	public static int removeElement(int[] nums, int val) {
        int length=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]==val){
                int j=i;
                while(j<nums.length){
                    if(nums[j]==val){
                        j++;
                    }
                    else {
                    	int temp=nums[j];
                        nums[j]=nums[i];
                        nums[i]=temp;
                        length++;
                        break;
                    }
                }
                
            }
            else
            	length++;
        }
        return length;
    }
	
	public static void main(String[] args) {
		removeElement(new int[] {0,1,2,2,3,0,4,2},2);

	}

}
