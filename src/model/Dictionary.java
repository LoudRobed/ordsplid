package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Locale;

import android.content.Context;
import android.content.res.AssetManager;

/**
 * Sample class to show how a dictionary can be utilized.
 * @author Simen
 *
 */
public class Dictionary implements IDictionary {
	
	private static Dictionary instance = null;
	private static boolean isCreated = false;
	
	
	//HashSet for constant time when using contains().
	HashSet<String> dictionary;
	
	private Dictionary() {}
	
	public void create(Context context) {
		if (isCreated) return;
		try {

			AssetManager am = context.getAssets();
			InputStream is = am.open("dictionary-webster-english");
			
			dictionary = new HashSet<String>();		
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			String word;
			while ((word = reader.readLine()) != null) {
				dictionary.add(word.toLowerCase(Locale.US));
			}
			reader.close();

			isCreated = true;

			
		} catch (IOException e) {
			System.out.println("FAILFAILFAIL");
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
		if (word.length() <= 1) return false;
		boolean result = dictionary.contains(word);
		//System.out.println(result);
		return result;
		
	}
}