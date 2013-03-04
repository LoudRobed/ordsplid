package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Dictionary {

	public static void make() throws IOException, FileNotFoundException {
		File dictionary = new File("dictionary-webster-english");
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(dictionary));
		
		//HashSet for constant time when using contains().
		HashSet<String> list = new HashSet<String>();
		String test = "zymotic", word;
		while ((word = reader.readLine()) != null) {
			list.add(word.toLowerCase());
		}
		System.out.println(list.size());
		System.out.println(list.contains(test));
		System.out.println("finished");
		reader.close();
	}
}