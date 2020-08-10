package leetcode.project;

public class NegativeNumberInSortedMatrix {

	public static int countNegatives(int[][] grid) {
		int row=grid.length;
		int col = grid[0].length;
		int count=0;
		for(int i=row-1;i>=0;i--) {
			for(int j=col-1 ; j>=0; j--) {
				if(grid[i][j]<0)
					count++;
				else
					break;
			}
		}
		
		for (int[] vec : grid) {
			for (int element : vec) {
				if (element < 0) {
					count++;
					continue;
				}
			}
		}
        
        return count;
    }
	public static void main(String[] args) {
		int[][] arr = new int[][] {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		System.out.println(countNegatives(arr));

	}

}
