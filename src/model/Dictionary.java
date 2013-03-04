package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/*
 * Sample class to show how dictionary could work
 */
public class Dictionary implements IDictionary {
	//HashSet for constant time when using contains().
	HashSet<String> dictionary;
	
	public Dictionary() throws IOException {
		HashSet<String> list = new HashSet<String>();
		
		//Read entire dictionary from file into hash.
		File dictionary = new File("dictionary-webster-english");
		BufferedReader reader = new BufferedReader(new FileReader(dictionary));
		
		String word;
		while ((word = reader.readLine()) != null) {
			list.add(word.toLowerCase());
		}
		reader.close();
	}
	
	@Override
	public boolean inDictionary(String word) {
		boolean result = dictionary.contains(word);
		//System.out.println(result);
		return result;
		
	}
}