package leetcode.project;

public class FrogsCroaking {
	
	public static int minNumberOfFrogs1(String croakOfFrogs) {
	    int cnt[] = new int[5];
	    int frogs = 0, max_frogs = 0;
	    for (int i = 0; i < croakOfFrogs.length(); ++i) {
	        char ch = croakOfFrogs.charAt(i);
	        int n = "croak".indexOf(ch);
	        ++cnt[n];
	        if (n == 0)
	            max_frogs = Math.max(max_frogs, ++frogs);
	        else if (--cnt[n - 1] < 0)
	            return -1;
	        else if (n == 4)
	            --frogs;
	    }
	    return frogs == 0 ? max_frogs : -1;    
	}

	public static int minNumberOfFrogs(String croakOfFrogs) {
		int length = croakOfFrogs.length();

		int cCount = 0;
		int rCount = 0;
		int oCount = 0;
		int aCount = 0;
		int kCount = 0;

		int count = 0;
		int noOfFrogs = 0;

		for (int i = 0; i < length; i++) {

			char c = croakOfFrogs.charAt(i);
			if (c == 'c')
				cCount++;
			else if (c == 'r' && cCount>rCount)
				rCount++;
			else if (c == 'o' && cCount>oCount)
				oCount++;
			else if (c == 'a' && cCount>aCount)
				aCount++;
			else if (c == 'k' && cCount>kCount)
				kCount++;

			if (cCount != 0 && ((cCount == rCount) && (cCount == oCount) && (cCount == aCount) && (cCount == kCount)))
				count++;
		}
		if (cCount != 0 && ((cCount != rCount) || (cCount != oCount) || (cCount != aCount) || (cCount != kCount)))
			return -1;
		if (count > 1)
			return 1;
		if (count == 1)
			return cCount;
		if (count == 0)
			return -1;
		return noOfFrogs;
	}

	public static void main(String[] args) {
		System.out.println(minNumberOfFrogs1("crocakcroraoakk"));
	}

}
