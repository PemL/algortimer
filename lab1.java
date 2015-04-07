import java.util.Arrays;
import java.util.LinkedList;

public class lab1 {

	public static void main(String[] args) {
		LinkedList<Integer> freeMen = new LinkedList<Integer>();
		freeMen.add(0);
		freeMen.add(1);
		freeMen.add(2);
		String[] menNames = new String[] { "Ross", "Chandler", "Joey" };
		String[] womenNames = new String[] { "Monica", "Phoebe", "Rachel" };
		int[][] menPref = new int[][] { { 2, 1, 0 }, { 0, 2, 1 }, { 2, 1, 0 } };
		int[][] womenPref = new int[][] { { 1, 2, 0 }, { 2, 0, 1 },
				{ 0, 2, 1 } };

		int[][] ranking = new int[][] { { 2, 0, 1 }, { 1, 2, 0 }, { 0, 1, 2 } };

		int[] current = new int[3];
		int[] next = new int[3];
		Arrays.fill(current, -1);
		while (freeMen.size() > 0) {
			System.out.println(freeMen.size());
			int freeMan = freeMen.getFirst();
			int woman = menPref[freeMan][next[freeMan]];
			next[freeMan] =+ 1;
			if (current[woman] < 0) {
				current[woman] = freeMan;
				int test = freeMen.removeFirst();
				System.out.println(test + "removed");
				System.out.println(freeMan + "removedCheck");


			} else {
				int oldMan = current[woman];
				if (ranking[woman][oldMan] > ranking[woman][freeMan]) {
					current[woman] = freeMan;
					freeMen.removeFirst();
					freeMen.add(oldMan);
				}
			}
		}
		for (int i = 0; i < current.length; i++) {
			System.out.println(menNames[current[i]] + " -- " + womenNames[i]);
		}
		System.out.println(2/3);

	}
}