package leetcode.project;

import java.util.Arrays;

public class CountingElement {
	
    public static int countElements(int[] arr) {
        Arrays.sort(arr);
        int count=0;
        for(int i=0; i<arr.length-1; i++){
            int same=0;
            if((arr[i]+1)==arr[i+1]){
                count++;
            }
            else if(arr[i]==arr[i+1]){
               same=1;
                while(i<arr.length-1){
                    if(arr[i]==arr[i+1]){
                    i++;
                    same++;
                    }
                    else if(arr[i]+1==arr[i+1] && same!=arr.length) {
                    	count=count+same;
                    	break;
                    }
                    else
                    	break;
                }
            }
        }
       return count; 
    }

	public static void main(String[] args) {
		System.out.println(countElements(new int[] {1,1,2,2}));
	}

}
