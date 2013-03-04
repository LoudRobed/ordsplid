package model;

/**
 * Stores the current letter matrix and contains methods for manipulating
 * the content.
 * @author Andreas
 *
 */
public interface IMatrix {

	/**
	 * Returns the current matrix
	 * @return A char[][] containing the letter matrix 
	 */
	public char[][] getMatrix();
	
	/**
	 * Sets the current letter matrix
	 * @param char[][]
	 */
	public void setMatrix(char[][] m);
	
	/**
	 * Sets the content of the matrix at index (x,y) to c
	 * @param x
	 * @param y
	 * @param c
	 */
	public void setCharAtIndex(int x, int y, char c);
	
	/**
	 * Method for finding the number of instances of a given letter
	 * in the matrix. Useful when deciding which letters to add.
	 * @param c
	 * @return int Number of occurrences of char in Matrix
	 */
	public int occurencesInMatrix(char c);
	
}
