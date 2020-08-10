package leetcode.project;

import java.util.HashSet;

public class LongestSubstring {
	
	public static int lengthOfLongestSubstring(String s) {
        if(s==null)
            return 0;
	boolean[] flag = new boolean[256];
 
	int result = 0;
	int start = 0;
	char[] arr = s.toCharArray();
 
	for (int i = 0; i < arr.length; i++) {
		char current = arr[i];
		if (flag[current]) {
			result = Math.max(result, i - start);
			// the loop update the new start point
			// and reset flag array
			// for example, abccabcd, when it comes to 2nd c,
			// it update start from 0 to 3, reset flag for a,b
			for (int k = start; k < i; k++) {
				if (arr[k] == current) {
					start = k + 1; 
					break;
				}
				flag[arr[k]] = false;
			}
		} else {
			flag[current] = true;
		}
	}
 
	result = Math.max(arr.length - start, result);
 
	return result;
}
	public static int longestSubString(String s) {
		
		HashSet<Character> subString = new HashSet<Character>();
        int index=0;
        int stringLength=s.length();
        for(int i=0; i<stringLength; i++){
            char c=s.charAt(i);
            if(!subString.contains(c)) {
            	subString.add(c);
            }
            else{
            	while(index<i) {
            		if(s.charAt(index)==c) {
            			index++;
            			break;
            		}
            		subString.remove(s.charAt(index));
            		index++;
            	}
            }
        } 
        
        return subString.size();
	}
	
	public static int lengthOfLongestSubstring1(String s) {
	    if(s==null||s.length()==0){
	        return 0;
	    }
	 
	    HashSet<Character> set = new HashSet<>();
	    int result = 1;
	    int i=0; 
	    for(int j=0; j<s.length(); j++){
	        char c = s.charAt(j);
	        if(!set.contains(c)){
	            set.add(c);
	            result = Math.max(result, set.size());
	        }else{
	            while(i<j){
	                if(s.charAt(i)==c){
	                    i++;
	                    break;
	                }
	 
	                set.remove(s.charAt(i));
	                i++;
	            }
	        }    
	    }
	 
	    return result;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring1("abcb"));

	}

}
