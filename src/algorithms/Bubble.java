package algorithms;

import java.util.ArrayList;

public class Bubble {

	public static void BubbleSort(int amt, int max) {
		ArrayList<Integer> dataToSort = utils.Utils.genTestingData(amt, max);

		long unixTimeStart = System.currentTimeMillis();

		while (!utils.Utils.testData(dataToSort)) {
			for (int i = 0; i < dataToSort.size(); i++) {
				if ((i + 1) < dataToSort.size()) {
					int dot = dataToSort.get(i);
					int dot1 = dataToSort.get(i + 1);

					if (dot > dot1) {
						dataToSort.set(i, dot1);
						dataToSort.set(i + 1, dot);
					}
				}
			}
		}

		long unixTimeEnd = System.currentTimeMillis();
		long difference = unixTimeEnd - unixTimeStart;

		System.out.println("Time Taken: " + difference + "ms");
	}

}
