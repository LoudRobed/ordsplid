package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;

/**
 * Sample class to show how a dictionary can be utilized.
 * @author Simen
 *
 */
public class Dictionary implements IDictionary {
	
	private static Dictionary instance = null;
	
	//HashSet for constant time when using contains().
	HashSet<String> dictionary;
	
	/**
	 * Constructor reads the dictionary file to memory.
	 * @throws IOException
	 */
	private Dictionary() {
		try {
			dictionary = new HashSet<String>();		
			File file = new File("dictionary-webster-english");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String word;
			while ((word = reader.readLine()) != null) {
				dictionary.add(word.toLowerCase(Locale.US));
			}
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Will return the singleton object, if no such object exists, one will be created.
	 * @return
	 */
	static public Dictionary instance() {
		if (instance == null) instance = new Dictionary();
		return instance;
	}
	
	@Override
	public boolean inDictionary(String word) {
		boolean result = dictionary.contains(word);
		//System.out.println(result);
		return result;
		
	}
}