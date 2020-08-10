package leetcode.project;

public class OneBitTwoBitCharacters {
	public static boolean isOneBitCharacter(int[] bits) {
		int i = 0;
		while (i < bits.length - 1) {
			i += bits[i] + 1;
		}
		return i == bits.length - 1;
	}

	public static boolean isOneBitCharacter1(int[] bits) {
		int i = bits.length - 2;
		while (i >= 0 && bits[i] > 0)
			i--;
		return (bits.length - i) % 2 == 0;
	}

	public static void main(String[] args) {
		System.out.println(isOneBitCharacter(new int[] { 1, 1, 1, 0 }));

	}

}
