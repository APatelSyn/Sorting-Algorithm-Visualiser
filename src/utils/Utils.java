package utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

	public static ArrayList<Integer> genTestingData(int amt, int max) {
		ArrayList<Integer> data = new ArrayList<Integer>();
		for(int i = 0; i<amt; i++) {
			data.add(ThreadLocalRandom.current().nextInt(1, max + 1));
		}
		return data;
	}
	
	public static ArrayList<Integer> genFlatTestingData(int amt) {
		ArrayList<Integer> data = new ArrayList<Integer>();
		for(int i = 0; i<amt; i++) {
			data.add(i);
		}
		Collections.shuffle(data);
		return data;
	}
	
	public static boolean testData(ArrayList<Integer> dataToTest) {
		for(int i=0; i<dataToTest.size(); i++) {
			if((i+1) < dataToTest.size()) {
				int dot = dataToTest.get(i);
				int dot1 = dataToTest.get(i + 1);
				
				if(dot > dot1) {
					return false;
				}
			}
		}
		return true;
	}
}
