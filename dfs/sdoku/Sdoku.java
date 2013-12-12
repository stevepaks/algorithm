package dfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sdoku {
	
	int[][] sdoku;
	int row;
	
	public Sdoku(){
		this.sdoku = new int[9][9];
		this.row = 9;
	}
	
	public void initSdoku(Scanner in){
		for(int i = 0 ; i < this.row ; i++){
			for(int j = 0 ; j < this.row ; j++){
				this.sdoku[i][j] = in.nextInt();
			}
		}
	}
	
	public void makeSdoku(int row){
		for(int candidate : this.getCandidates(row)){
			int vacancyCol = this.getVacancyCol(row);
			if(this.isDuplicate(row, vacancyCol, candidate)){
				continue;
			}
			this.sdoku[row][vacancyCol] = candidate;
			if(this.getVacancyCol(row) == -1){
				break;
			}
		}
		if(row == this.row - 1){
			return;
		}
		this.makeSdoku(++row);
		if(this.getVacancyCol(row) != -1){
			this.makeSdoku(row);
		}		
	}
	
	private int getVacancyCol(int row){
		int col = 0;
		for(int element : this.sdoku[row]){
			if(element == 0){
				return col;
			}
			col++;
		}
		return -1;
	}
	
	private boolean isDuplicate(int row, int col, int val){
		int[] tempRowNLimit = this.getTempValNLimit(row);
		int[] tempColNLimit = this.getTempValNLimit(col);
		
		for(int i = tempRowNLimit[0] ; i < tempRowNLimit[1] ; i++){
			for(int j = tempColNLimit[0] ; j < tempColNLimit[1] ; j++){
				if(sdoku[i][j] == val){
					return true;
				}
			}
		}
		
		for(int i = 0 ; i < this.row ; i++){
			if(sdoku[i][col] == val){
				return true;
			}
		}
		
		for(int i = 0 ; i < this.row ; i++){
			if(sdoku[row][i] == val){
				return true;
			}
		}
		
		return false;
	}
	
	private int[] getTempValNLimit(int val){
		int[] tempValNLimit = new int[2];
		
		if(val % 3 == 0){
			tempValNLimit[0] = val;
			tempValNLimit[1] = val + 3;
		}else if(val % 3 == 1){
			tempValNLimit[0] = val - 1;
			tempValNLimit[1] = val + 2;
		}else{
			tempValNLimit[0] = val - 2;
			tempValNLimit[1] = val + 1;
		}
		
		return tempValNLimit;
	}
	
	private int[] getCandidates(int row){
		int numOfCandidates = 0;
		
		for(int i = 0 ; i < this.row ; i++){
			if(this.sdoku[row][i] == 0){
				numOfCandidates++;
			}
		}
		
		int candidates[] = new int[numOfCandidates];
		
		int idx = 0;
		for(int i = 1 ; i <= this.row ; i++){
			for(int j = 0 ; j < this.row ; j++){
				if(this.sdoku[row][j] == i){
					break;
				}
				if(j == (this.row - 1)){
					candidates[idx++] = i;
				}
			}
		}
		return candidates;
	}
	
	public void printSdoku(){
		for(int i = 0 ; i < this.row ; i++){
			for(int j = 0 ; j < this.row ; j++){
				System.out.print(sdoku[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		Sdoku sdoku = new Sdoku();
		
		try {
			Scanner in = new Scanner(new File("input.txt"));
			sdoku.initSdoku(in);
			sdoku.makeSdoku(0);
			sdoku.printSdoku();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
