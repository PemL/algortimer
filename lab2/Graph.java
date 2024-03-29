import java.util.LinkedList;

public class Graph {


	LinkedList<Integer>[] adj;

	public LinkedList[] run(String[] word) {

		adj = new LinkedList[word.length];

		int letterExists = 0;
		int checkForMultiples = 0;
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < word.length; i++) {
			for (int k = 0; k < word.length; k++) {
				int[] positionIndex = new int[] { 0, 0, 0, 0, 0 };
				int count = 0;
				letterExists = 0;
				checkForMultiples = 0;
				if (k != i)
					for (int n = 0; n < 4; n++) {
						letterExists = word[k].indexOf(word[i].charAt(n + 1));
						if (letterExists != -1) {
							checkForMultiples = word[k].indexOf(
									word[i].charAt(n + 1),
									positionIndex[letterExists]);
							if (checkForMultiples != -1) {
								count++;
								positionIndex[letterExists] = checkForMultiples + 1;
//								System.out
//								.println(checkForMultiples + " i = "
//										+ i + " k = " + k + " count = "
//										+ count);
							}
						}
					}
				if (count == 4) {
					adj[i].addLast(k);
				}

			}

		}
//		for (int i = 0; i < adj.length; i++) {
//			System.out.println(i + " " + word[i]);
//			for (int k = 0; k < adj[i].size(); k++) {
//				System.out.println(i + " " + word[adj[i].get(k)]);
//			}
//		}
		return adj;
	}

}