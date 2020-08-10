package leetcode.project;

public class StringShift {

	public static String stringShift(String s, int[][] shift) {
		int length = shift.length;
        for(int i=0; i<length; i++){
            if(shift[i][0]==0){
                int amount=shift[i][1];
                s=s.substring(amount)+s.substring(0,amount);
            }
            else{
                int amount=s.length()-shift[i][1];                 
                s=s.substring(amount)+s.substring(0,amount);            
            }
        }
        return s;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 1 } };
		String s = "Vikash";
		System.out.println(stringShift(s, arr));
	}
}
