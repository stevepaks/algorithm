package heapsort;

public class HeapSort {
	private int[] input;
	private int count;
	
	public HeapSort(int[] input){
		this.input = input;
		this.count = input.length;
	}
	public void heapSort(){
		this.heapify();
		int end = this.count - 1;
		
		while(end > 0){
			swap(end, 0);
			end--;
			this.siftDown(0, end);
		}
	}
	
	private void swap(int end, int zero){
		int temp = this.input[end];
		this.input[end] = this.input[zero];
		this.input[zero] = temp;
	}
	
	private void heapify(){
		int start = 0;
		start = (this.count - 2) / 2;		
		
		while(start >= 0){
			this.siftDown(start, this.count - 1);
			start--;
		}
	}
	
	private void siftDown(int start, int end){
		int root = start;
		
		while(root * 2 + 1 <= end){
			int child = root * 2 + 1;
			int swap = root;
			
			if(this.input[swap] < this.input[child]){
				swap = child;
			}
			
			if(child + 1 <= end && this.input[swap] < this.input[child + 1]){
				swap = child + 1;				
			}
			
			if(swap != root){
				this.swap(root, swap);
				root = swap;
				continue;
			}
			return;
		}
	}
	
	public static void main(String[] args){
		int [] input = { 6, 5, 3, 1, 8, 7, 2, 4 } ;
		
		for(int i : input){
			System.out.print(i + " ");
		}
		System.out.println();
		
		HeapSort sorter = new HeapSort(input);
		
		sorter.heapSort();
		
		for(int i : input){
			System.out.print(i + " ");
		}
	}

}
