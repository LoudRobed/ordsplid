package model;

import java.io.BufferedReader;
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
public class Dictionary {
	//HashSet for constant time when using contains().
	HashSet<String> dictionary;
	
	public Dictionary(Context context) {
		create(context);
	}
	
	private void create(Context context) {
		try {

			AssetManager am = context.getAssets();
			InputStream is = am.open("dictionary");
			
			dictionary = new HashSet<String>();		
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			String word;
			while ((word = reader.readLine()) != null) {
				dictionary.add(word.toLowerCase(Locale.US));
			}
			reader.close();			
		} catch (IOException e) {
			System.out.println("FAILFAILFAIL");
		}
		
	}
	
	public boolean inDictionary(String word) {
		if (word.length() <= 1) return false;
		boolean result = dictionary.contains(word);
		return result;
		
	}
}