package Greedy;

public class Min {
	private int[] weights;
	private int count;
	private int max;
	
	public Min(int noOfWeight){
		this.weights = new int[noOfWeight];
		count = 0;
		max = 0;
	}
	
	public int[] getWeights(){
		return this.weights;
	}
	
	public void addWeight(int weight){
		this.weights[count++] = weight;
	}
	
	public int getNoOfWeight(){
		return this.weights.length;
	}
	
	public void setMax(){
		for(int weight : this.weights){
			this.max += weight;
		}
	}
	
	private int getMax(){
		return max;
	}
	
	public void sort(){
		for(int i = 0 ; i < weights.length ; i++){
			for(int j = i + 1 ; j < weights.length ; j++){
				if(this.compare(i, j)){
					this.swap(i, j);
				}
			}
		}
	}
	
	private void swap(int pre, int post){
		int temp = this.weights[pre];
		this.weights[pre] = this.weights[post];
		this.weights[post] = temp;
	}
	
	private boolean compare(int pre, int post){
		if(this.weights[pre] < this.weights[post]){
			return true;
		}else{
			return false;
		}
	}
	
	public int getMin(){
		for(int min = 1 ; min < this.getMax() ; min++){
			int temp = 0;
			for(int weight : this.weights){
				if(weight <= min){
					if(min < (temp + weight)){
						continue;
					}
					temp += weight;
					if(temp < min){
						continue;
					}
					break;
				}
			}
			if(min > temp){
				return min;
			}
		}
		return 0;
	}

}
