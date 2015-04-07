import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class Gale {

	public static void main(String[] args) throws IOException {
		new Gale().run(args[0]);
	}

	public void run(String fileName) throws IOException {
		String[] womenNames = null;
		String[] menNames = null;

		Scanner sc = new Scanner(new FileInputStream(fileName));
		int numberOfPairs = 0;
		while (sc.hasNext()) {
			String currentString = sc.nextLine();
			if (!currentString.contains("#")) {

				if (currentString.contains("=")) {
					String[] numberOfPairsTemp = currentString.split("=");
					numberOfPairs = Integer.parseInt(numberOfPairsTemp[1]);
					break;
				}

			}

		}
		womenNames = new String[numberOfPairs];
		menNames = new String[numberOfPairs];

		int womenCount = 0;
		int menCount = 0;
		for (int n = 0; n < numberOfPairs * 2; n++) {
			if (n % 2 != 0) {
				String[] wTemp = sc.nextLine().split(" ");
				// System.out.println(wTemp[0]);
				womenNames[womenCount] = wTemp[1];
				womenCount++;
			} else {
				String[] mTemp = sc.nextLine().split(" ");
				// System.out.println(mTemp[0]);
				menNames[menCount] = mTemp[1];
				menCount++;
			}
		}

		int[][] ranking = new int[numberOfPairs][numberOfPairs];
		int[][] menPref = new int[numberOfPairs][numberOfPairs];
		sc.nextLine();
		womenCount = 0;
		menCount = 0;
		for (int n = 0; n < numberOfPairs * 2; n++) {
			if (n % 2 != 0) {
				String[] wTemp = sc.nextLine().split(" ");
				int[] wTempSorted = normalizeArray(wTemp, numberOfPairs);
				for (int i = 0; i < wTemp.length - 1; i++) {
					ranking[womenCount][wTempSorted[i]] = i;
				}

				womenCount++;
			} else {
				String[] mTemp = sc.nextLine().split(" ");
				int[] mTempSorted = normalizeArray(mTemp, numberOfPairs);
				for (int i = 0; i < mTemp.length - 1; i++) {
					menPref[menCount][i] = mTempSorted[i];
//					System.out.println(menPref[menCount][i - 1]);

				}
				menCount++;
			}
		}
		System.out.println(ranking[1][1]);
		System.out.println(ranking[0][0]);
		 System.out.println(menPref[1][1]);
		 System.out.println(menPref[2][0]);

	}

	int[] normalizeArray(String[] temp, int n) {
		int[] normArray = new int[n];
		int maxIndex = 1;
		while (n > 0) {
			for (int i = 2; i < temp.length; i++) {
				int newNumber = Integer.parseInt(temp[i]);
//				System.out.println(newNumber + " " + Integer.parseInt(temp[maxIndex]));
				if (newNumber > Integer.parseInt(temp[maxIndex])) {
					maxIndex = i;
//					System.out.println(maxIndex + " maxindex");
				}

			}
			normArray[maxIndex - 1] = n - 1;
			n--;
			temp[maxIndex] = "0";
			maxIndex = 1;
		}
		for (int i = 0; i < normArray.length; i++) {

//			System.out.println(normArray[i]);
//			System.out.println(normArray.length + "size");

		}
		return normArray;
	}
}