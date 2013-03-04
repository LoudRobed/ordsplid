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
		dictionary = new HashSet<String>();
		
		//Read entire dictionary from file into hash.
		File file = new File("dictionary-webster-english");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String word;
		while ((word = reader.readLine()) != null) {
			dictionary.add(word.toLowerCase());
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