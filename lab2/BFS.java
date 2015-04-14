import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	int amountOfWords;
	int secondWord;
	int firstWord;
	LinkedList<Integer>[] adj;
	LinkedList<Integer> temp;
	Queue<Integer>[] levelList;
	boolean[] discovered;

	Queue<Integer> currentLevelList;

	public int run(LinkedList<Integer>[] adj, int firstWord, int secondWord,
			int amountOfWords) {
		int distance = -1;
		int countLevel = 0;
		levelList = new LinkedList[10];
		discovered = new boolean[amountOfWords];
		levelList[0] = new LinkedList<Integer>();
		levelList[0].offer(firstWord);
		while (!levelList[countLevel].isEmpty()) {
			levelList[countLevel + 1] = new LinkedList<Integer>();
			int currentNode = levelList[countLevel].poll();
			LinkedList<Integer> nodeList = adj[currentNode];
			for (Integer newNode : nodeList) {
				if (!discovered[newNode]) {

					if (newNode == secondWord) {
						distance = countLevel + 1;
//						System.out.println(distance+" distance");
					}
					discovered[newNode] = true;
					levelList[countLevel + 1].offer(newNode);
				}
			}
//			System.out.println(countLevel+" testing");

			countLevel++;
		}
		return distance;
	}
}
