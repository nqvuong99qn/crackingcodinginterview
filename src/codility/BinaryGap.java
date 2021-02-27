package codility;

public class BinaryGap {

	int BinaryGap(int N) {

		String binary = Integer.toBinaryString(N);
		int longest = 0;
		int current = -1;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) - '0' == 1) {
				if (current > longest) {
					longest = current;
					if (longest > binary.length() - i) {
						break;
					}
				}
				current = 0;
			} else {
				current++;
			}
		}
		return longest;
	}

}
