package dfs;

import java.text.SimpleDateFormat;


public class NQueen {
	private int[] route;
	private int size;
	private int depth;
	private int avail;
	private int stackPointer;
	
	public NQueen(int size){
		this.size = size;
		this.depth = 0;
		this.avail = 0;
		this.stackPointer = 0;
		this.route = new int[this.size];
		for(int i = 0 ; i < this.route.length ; i++){
			this.route[i] = Integer.MAX_VALUE;
		}
	}
	
	public void nQueen(){
		for(int i = 0 ; i < this.size ; i++){
			if(!this.containsRoute(i)){
				this.depth++;
				if(this.size == this.depth){
					this.avail++;
					this.pushRoute(i);
					this.printQueenPos();
					System.out.println();
					this.popRoute();
					this.depth--;
					return;
				}
				this.pushRoute(i);
				this.nQueen();
				this.popRoute();
				this.depth--;
			}
		}
	}
	
	private void printQueenPos(){
		int i = 0;
		for(int r : this.route){
			System.out.println(i++ + " " + r);
		}
	}
	
	private void pushRoute(int i){
		this.route[this.stackPointer++] = i;
	}
	
	private void popRoute(){
		this.route[--this.stackPointer] = Integer.MAX_VALUE;
	}
	
	private boolean containsRoute(int i){
		if(this.depth == 0){
			return false;
		}
		for(int k = 0 ; k < this.route.length ; k++){
			int r = this.route[k];
			if(i == r){
				return true;
			}
			if(this.depth - k == i - r ){
				return true;
			}
			if(this.depth - k == r - i){
				return true;
			}
//			if(i == r + 1 && this.depth - k == 1){
//				return true;
//			}
//			if(r != 0 && i == r - 1 && this.depth - k == 1){
//				return true;
//			}
		}
		return false;
	}
	
	public int getAvail(){
		return this.avail;
	}
	
	public static void main(String[] args){
		NQueen counter = new NQueen(6);
		
		counter.nQueen();
		
		System.out.println();
		System.out.println(counter.getAvail());
	}
	

}
