package model;

import android.graphics.Color;

/**
 * Letter class. Contains information about each letter
 * @author Simen
 *
 */
public class Letter implements Comparable<Letter> {
	private int points, totalPieces;
	private Character letter;
	
	private static int count = 0;
	
	private Letter(char letter, int totalPieces, int points) {
		this.letter = letter;
		this.totalPieces = totalPieces;
		this.points = points;
	}
	
	/**
	 * Creates a new letter. Will only create a certain amount of letters, specified in Constants.
	 * @param letter
	 * @param probability
	 * @param points
	 * @return new Letter object
	 */
	public static Letter createLetter(char letter, int probability, int points) {
		if (count >= Constants.NUMBER_OF_DISTINCT_LETTERS) {
			System.err.println("You are not allowed to create new letters");
		}
		count++;
		return new Letter(letter,probability,points);
	}
	
	public int getTotalPieces() {
		return totalPieces;
	}
	
	public int compareTo(Letter another) {
		return this.letter.compareTo(another.letter);
	}
	
	public String toString() {
		return letter + " - Total pieces: " + totalPieces + " - Points: " + points;
	}
	
	public Character getLetter() {
		return letter;
	}
	
	public int getPoints() {
		return points;
	}
}