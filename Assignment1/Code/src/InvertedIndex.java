
public class InvertedIndex {

/*	public static void main(String[] args) {

		// key = word, value = set of filenames containing that word
		ST<String, SET<String>> st = new ST<String, SET<String>>();

		// create inverted index of all files
		for (String filename : args) {
			// StdOut.println(filename);
			In in = new In(filename);
			while (!in.isEmpty()) {
				String word = in.readString();
				if (!st.contains(word))
					st.put(word, new SET<String>());
				SET<String> set = st.get(word);
				set.add(filename);
			}
		}

		// read queries from standard input, one per line
		while (!StdIn.isEmpty()) {
			String query = StdIn.readString();
			if (!st.contains(query))
				StdOut.println("NOT FOUND");
			else {
				SET<String> set = st.get(query);
				for (String filename : set) {
					StdOut.print(filename + " ");
				}
				StdOut.println();
			}
			StdOut.println();
		}

	}*/

}
