package leetcode.project;

public class RomanToInt {
	
    public static int romanToInt(String s) {
        
        int length = s.length();
        int sum=0;
        for(int i=0; i<length;i++){
           char c=s.charAt(i);
            int data=0;
           if(i<length-1 && c=='I' && (s.charAt(i+1)=='V' || s.charAt(i+1)=='x')){
               data=convertToInt(s.charAt(i+1))-1;
               i++;
           }
           else if(i<length-1 && c=='X' && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C')){
               data=convertToInt(s.charAt(i+1))-10;
               i++;
           }
            else if(i<length-1 && c=='C' && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M')){
               data=convertToInt(s.charAt(i+1))-100;
               i++;
           }
            else {
            	data=data+convertToInt(c);
            }
           sum=sum+data;   
        }
        return sum;
    }
    
    public static int convertToInt(char c){
        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

	public static void main(String[] args) {
         System.out.println(romanToInt("IV"));
	}

}
