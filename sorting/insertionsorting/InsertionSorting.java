package insertionsorting;

public class InsertionSorting {
	public static void main(String[] args){
		int[] input = {3, 7, 4, 9, 5, 2, 6, 1};
		for(int element : input){
			System.out.print(element + " ");
		}
		for(int i = 1 ; i < input.length ; i++){
			int valueToInsert = input[i];
			
			int holePos = i;
			
			while(holePos > 0 && valueToInsert < input[holePos-1]){
				input[holePos] = input[holePos-1];
				holePos--;
			}
			
			input[holePos] = valueToInsert;
		}
		System.out.println();
		
		for(int element : input){
			System.out.print(element + " ");
		}
//		int[] input = {3, 7, 4, 9, 5, 2, 6, 1, 10, 8, 19, 15};
//		int temp;
//		
//		for(int i=0 ; i<input.length - 1 ; i++) {
//			for(int j=i+1 ; j<input.length ; j++) {
//				if(input[i] > input[j]) {
//					temp = input[i];
//					input[i] = input[j];
//					input[j] = temp;
//				}
//			}
//		}
//		
//		for(int i=0 ; i<input.length ; i++) {
//			System.out.print(input[i] + " ");
//		}
		
//		int input[] = {3,21,45,1,48,98,30,12,77,62};
//		int temp;
//		
//		
//		for(int num : input){
//			System.out.print(num + " ");
//		}
//		
//		for(int i=1;i<input.length;i++ ){
//			
//			temp = input[i];
//			
//			while(i>0 && input[i-1] > temp){
//				input[i] = input[i-1];
//				input[i-1] = temp;
//				i--;
//			}
//			
//		}
//		
//		System.out.println();
//		
//		for(int num : input){
//			System.out.print(num + " ");
//		}
	}

}
