package model;
//not in use
public class Matrix implements IMatrix{
	private static Matrix instance = null;
	private char[][] m;
	
	private Matrix(){
		
	}
	
	public static Matrix instance() {
		if (instance == null) instance = new Matrix();
		return instance;
	}
	
	@Override
	public char[][] getMatrix() {
		return m;
	}

	@Override
	public void setMatrix(char[][] m) {
		this.m = m;
	}

	@Override
	public void setCharAtIndex(int x, int y, char c) {
		m[x][y] = c;
		
	}

	@Override
	public int occurencesInMatrix(char c) {
		for(char[] ch: m){
			if(ch.equals(c)){
				return 1;
			}
		}
		return 0;
	}

}
