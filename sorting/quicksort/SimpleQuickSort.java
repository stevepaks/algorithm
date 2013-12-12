package quicksort;

public class SimpleQuickSort {
	
	public static void main(String[] args){
		SimpleQuickSort sorter = new SimpleQuickSort();
		int [] input = {3, 7, 4, 9, 5, 2, 6, 1};
		
		for(int i : input){
			System.out.print(i + " ");
		}
		int [] result = sorter.quickSort(input);
		System.out.println();
		
		for(int r : result){
			System.out.print(r + " ");
		}
	}
	
	public int[] quickSort(int[] elements){
		if(elements.length <= 1){
			return elements;
		}
		
		//select a pivot element from 'array'  
		int pivot = elements.length/2;
		int pivotValue = elements[pivot];
		
		//remove a pivot element from 'array'  
		int[] adjustedElements = new int[elements.length-1];
		for(int i = 0, j = 0 ; i < elements.length ; i++){
			if(i == pivot){
				continue;
			}
			adjustedElements[j++] = elements[i];
		}
		
		//create empty lists less and greater
		int lSize = 0;
		int rSize = 0;
		for(int element : adjustedElements){
			if(element <= pivotValue){
				lSize++;
			}else{
				rSize++;
			}
		}
		int[] less = new int[lSize];
		int[] greater = new int[rSize];
		
		
		for(int i = 0, j = 0, k = 0 ; i < adjustedElements.length ; i++){
			//if x ¡Â pivot then append x to less
			if(adjustedElements[i] <= pivotValue){
				less[j++] = adjustedElements[i];
			}else{ //else append x to greater
				greater[k++] = adjustedElements[i];
			}
			
		}
		// two recursive calls
		return this.concatenate(this.quickSort(less), pivotValue, this.quickSort(greater));
	}
	
	private int[] concatenate(int[] left, int pivot, int[] right){
		int[] result = new int[left.length + right.length + 1];
		int i = 0;
		for(int l : left){
			result[i++] = l;
		}
		result[i++] = pivot;
		for(int r : right){
			result[i++] = r;
		}
		return result;
	}

}
