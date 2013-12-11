package mergesort;

public class MergeSort {
	private int[] in;
	private int[] out;
	private int n;
	
	public static void main(String[] args){
		int [] input = {3, 7, 4, 9, 5, 2, 6, 1};
		MergeSort sorter = new MergeSort(input.length - 1, input);
		
		for(int i : input){
			System.out.print(i + " ");
		}
		System.out.println();
		
		sorter.bottomUpSort();
		for(int i : input){
			System.out.print(i + " ");
		}
		
	}
	
	public MergeSort(int n, int[] in){
		this.n = n;
		this.in = in;
		this.out = new int[this.in.length];
	}
	
	public void topDownMergeSort(){
		this.topDownSplitMerge(0, this.n);
	}
	
	private void swap(int begin, int end){
		int temp = this.in[end];
		this.in[end] = this.in[begin];
		this.in[begin] = temp;
	}
	
	private void topDownSplitMerge(int begin, int end){
		if(end - begin < 2){
			if(this.in[end] < this.in[begin]){
				this.swap(begin, end);
			}
			return ;
		}
		
		int middle = (begin + end) / 2;
		
		this.topDownSplitMerge(begin, middle);
		
		this.topDownSplitMerge(middle, end);
		
		this.topDownMerge(begin, middle, end);
		
		this.copyArray(begin, end);
	}
	
	private void topDownMerge(int begin, int middle, int end){
		int i0 = begin, i1 = middle;
		
		for(int i = begin ; i <= end ; i++){
			if(i0 < middle && (i1 >= end || this.in[i0] < this.in[i1])){
				this.out[i] = this.in[i0++];
			}else{
				this.out[i] = this.in[i1++];
			}
		}
	}
	
	private void copyArray(int begin, int end){
		for(int i = begin ; i < end ; i++){
			this.in[i] = this.out[i];
		}
	}
	
	public void bottomUpSort(){
		for(int width = 1 ; width < this.n ; width *= 2){
			for(int i = 0 ; i < this.n ; i = i + 2 * width){
				this.bottomUpMerge(i, this.min(i + width, this.n), this.min(i + 2 * width, this.n));
			}
			this.copayArray();
		}
	}
	
	private void copayArray(){
		int i = 0;
		for(int r : this.out){
			this.in[i++] = r;
		}
	}
	
	private int min(int a, int b){
		if(a == this.in.length){
			return a;
		}
		if(a > b){
			return b;
		} else {
			return a;
		}
	}
	
	private void bottomUpMerge(int left, int right, int end){
		int i0 = left;
		int i1 = right;
		
		for(int i = left ; i < end ; i++){
			if(i0 < right &&(i1 >= end || this.in[i0] <= this.in[i1])){
				this.out[i] = this.in[i0++];
			} else {
				this.out[i] = this.in[i1++];
			}
		}
	}

}
