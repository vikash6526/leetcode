package leetcode.project;

public class PlaywithChips {
	public int minCostToMoveChips(int[] chips) {
		int even = 0, odd = 0;
		for (int i = 0; i < chips.length; i++) {
			if (chips[i] % 2 == 1)
				odd++;
			else
				even++;
		}
		return Math.min(odd, even);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
