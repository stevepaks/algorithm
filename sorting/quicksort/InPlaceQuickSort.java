package quicksort;

public class InPlaceQuickSort {
	
	private int[] array;
	
	public static void main(String[] args){
		int[] input = {3, 7, 8, 5, 2, 1, 9, 5, 4};
		
		for(int i : input){
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		InPlaceQuickSort sorter = new InPlaceQuickSort(input);
		sorter.quickSort(0, input.length-1);
		
		for(int i : input){
			System.out.print(i + " ");
		}
	}
	
	public InPlaceQuickSort(int[] array){
		this.array = array;
	}
	
	public void quickSort(int left, int right){
		if( left < right){
			int pivotIndex = (left + right) / 2;
			int pivotNewIndex = this.partition(left, right, pivotIndex);
			quickSort(left, pivotNewIndex - 1);
			
			quickSort(pivotNewIndex + 1, right);
		}		
	}
	
	private int partition(int left, int right, int pivotIndex){
		int pivotValue = this.array[pivotIndex];
		this.swap(pivotIndex, right);
		int storeIndex = left;
		for( int i = left  ; i < right ; i++){
			if(this.array[i] < pivotValue){
				this.swap(i, storeIndex++);
			}
		}
		this.swap(storeIndex, right);
		return storeIndex;
	}
	
	private void swap(int pivotIndex, int right){
		int temp = this.array[pivotIndex];
		this.array[pivotIndex] = this.array[right];
		this.array[right] = temp;
	}

}

