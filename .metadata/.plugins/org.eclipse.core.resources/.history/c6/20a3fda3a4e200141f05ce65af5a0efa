import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Lab2 {
	LinkedList<Integer>[] adj;
	Graph graph;
	BFS bfs;
	int firstWord;
	int secondWord;
	int nbrOfSteps;
	
	String[] word;
	Stack<String> wordToCompare;
	
	HashMap<String, Integer> map;

	public static void main(String arg[]) {
		new Lab2().start();
	}

	
	
	public void run() {
		//read input and create array /hashmap of words
		//read first-last word input and insert to an array and hashmap
	}
	public void start() {
		graph = new Graph();
		bfs = new BFS();
		adj = graph.run();

		while (wordInput()) {
			firstWord = getNextWord();
			secondWord = getNextWord();
//			nbrOfSteps = bfs.run(adj, firstWord, secondWord, word.length);
			nbrOfSteps = bfs.run(adj, 9, 6, 10);
			System.out.println(nbrOfSteps);
		}
	}

	public boolean wordInput() {
		return true; //check if wordToCompare is not empty ()
	}

	public int getNextWord() {
		 //if mod%2 get wordToCompare[count++]
		// convert word/string to number(id) with hashmap
		return 0;
	}

}
