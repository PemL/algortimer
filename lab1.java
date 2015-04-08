import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class Lab1 {

	String[] menNames;
	String[] womenNames;
	int[][] menPref;
	int[][] ranking;

	public void algorithm(String[] womenNames, String[] menNames,
			int[][] ranking, int[][] menPref, int numberOfPairs, String fileName) {
		LinkedList<Integer> freeMen = new LinkedList<Integer>();
		for (int i = 0; i < numberOfPairs; i++) {
			freeMen.add(i);
		}

		int[] currentW = new int[numberOfPairs];
		int[] currentM = new int[numberOfPairs];

		int[] next = new int[numberOfPairs];
		Arrays.fill(currentW, -1);
		while (freeMen.size() > 0) {
			int freeMan = freeMen.getFirst();
			int woman = menPref[freeMan][next[freeMan]];
			next[freeMan]++;
			if (currentW[woman] < 0) {
				currentW[woman] = freeMan;
				currentM[freeMan] = woman;
				freeMen.removeFirst();

			} else {
				int oldMan = currentW[woman];
				if (ranking[woman][oldMan] > ranking[woman][freeMan]) {
					currentW[woman] = freeMan;
					currentM[freeMan] = woman;
					freeMen.removeFirst();
					freeMen.add(oldMan);
				}
			}
		}
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName + ".out", "UTF-8");
		} catch (IOException ex) {
		}

		for (int i = 0; i < currentW.length; i++) {

			writer.println(menNames[i] + " -- " + womenNames[currentM[i]]);
		}
		writer.close();

	}
}