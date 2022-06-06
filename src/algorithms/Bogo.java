package algorithms;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Bogo {

	public static void BogoSort(int amt, int max) {
		ArrayList<Integer> dataToSort = utils.Utils.genTestingData(amt, max);
		
		long unixTimeStart = System.currentTimeMillis();
		
		while(!utils.Utils.testData(dataToSort)) {
			int ranSpot1 = ThreadLocalRandom.current().nextInt(0, dataToSort.size());
			int ranSpot2 = ThreadLocalRandom.current().nextInt(0, dataToSort.size());
			
			int val1 = dataToSort.get(ranSpot1);
			int val2 = dataToSort.get(ranSpot2);
			
			dataToSort.set(ranSpot1, val2);
			dataToSort.set(ranSpot2, val1);
			
			System.out.println(dataToSort);
		}
		
		long unixTimeEnd = System.currentTimeMillis();
		long difference = unixTimeEnd - unixTimeStart;

		System.out.println("Time Taken: " + (difference > 1000 ? (difference/1000) + "s" : difference + "ms"));
	}

}
