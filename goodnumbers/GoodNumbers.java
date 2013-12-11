package dfs;

public class GoodNumbers {
	private int[] numbers;
	private int length;
	private volatile int pointer;
	
	public static void main(String[] args){
		GoodNumbers goodNumbers = new GoodNumbers(7);
		goodNumbers.findGoodNumbers();
	}
	
	public GoodNumbers(int length){
		this.numbers = new int[length];
		for(int i = 0 ; i < length ; i++){
			this.numbers[i] = Integer.MAX_VALUE;
		}
		this.length = length;
		this.pointer = 0;
	}
	
	public void findGoodNumbers(){
		int number = 1;
		
		if(this.length == this.pointer){
			if(!this.isBadNumbers()){
				this.printNumbers();
				System.out.println();
			}
			return;	//last insertion
		}
		while(true){
			if(number > 3) return;			
			this.push(number++);
			this.findGoodNumbers();
			this.pop();
		}
	}
	
	private void printNumbers(){
		for(int number : this.numbers){
			System.out.print(number);
		}
	}
	
	private boolean isBadNumbers(){
		for(int size = 2 ; size <= this.length ; size += 2){
			if(this.hasDuplicateSubNumbers(size)){
				return true;
			}
		}
		return false;
	}
	
	private boolean hasDuplicateSubNumbers(int size){		
		int[] post = new int[size/2];
		int[] pre = new int[size/2];
		
		int i = this.length;
		while(i >= size){
			int k = --i;
			int count = 0;
			for(int j = 0 ; j < size / 2 ; j++){
				post[j] = this.numbers[k--];
			}
			for(int j = 0 ; j < size / 2 ; j++){
				pre[j] = this.numbers[k--];
			}
			for(int j = 0 ; j < size / 2 ; j++){
				if(post[j] == pre[j]){
					count++;
				}
			}
			if(count == size / 2){
				return true;
			}
		}
		return false;
	}
	
	private void push(int number){
		this.numbers[this.pointer++] = number;
	}
	
	private void pop(){
		this.numbers[--this.pointer] = Integer.MAX_VALUE;
	}

}
