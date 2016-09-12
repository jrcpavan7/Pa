

import java.util.*; // Provides TreeMap, Iterator, Scanner
import java.io.*; // Provides FileReader, FileNotFoundException

public class Run {
	public static void main(String[] args) {
		// **THIS CREATES A TREE MAP**
		TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>();

		readWordFile(frequencyData);
		printAllCounts(frequencyData);
	}

	public static int getCount(String word, TreeMap<String, Integer> frequencyData) {
		if (frequencyData.containsKey(word)) { // The word has occurred before,
												// so get its count from the map
			return frequencyData.get(word); // Auto-unboxed
		} else { // No occurrences of this word
			return 0;
		}
	}

	public static void printAllCounts(TreeMap<String, Integer> frequencyData) {
		System.out.println("-----------------------------------------------");
		System.out.println("    Occurrences    Word");

		for (String word : frequencyData.keySet()) {
			System.out.printf("%15d    %s\n", frequencyData.get(word), word);
		}

		System.out.println("-----------------------------------------------");
	}

	public static void readWordFile(TreeMap<String, Integer> frequencyData) {
		Scanner wordFile;
		String word; // A word read from the file
		Integer count; // The number of occurrences of the word

		// **FOR LOOP TO READ THE DOCUMENTS**
		for (int x = 0; x < Docs.length; x++) { // start of for loop [*

			try {
				wordFile = new Scanner(new FileReader(Docs[x]));
			} catch (FileNotFoundException e) {
				System.err.println(e);
				return;
			}

			while (wordFile.hasNext()) {
				// Read the next word and get rid of the end-of-line marker if
				// needed:
				word = wordFile.next();

				// This makes the Word lower case.
				word = word.toLowerCase();

				// Get the current count of this word, add one, and then store
				// the new count:
				count = getCount(word, frequencyData) + 1;
				frequencyData.put(word, count);
			}

		} // End of for loop *]
	}

	// Array of documents
	static String Docs[] = { "words.txt", "words2.txt", "words3.txt", "words4.txt", "words5.txt", "words6.txt",
			"words7.txt", "words8.txt", "words9.txt", "words10.txt", };
}
