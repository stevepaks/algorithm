package selectionsorting;

public class SelectionSorting {
	public static void main(String[] args){
		int[] input = {3, 7, 4, 9, 5, 2, 6, 1};
		
		for(int out : input){
			System.out.println(out);
		}
		
		for(int i = 0 ; i < input.length ; i++){
			for(int j = i + 1 ; j < input.length ; j++){
				if(input[i] > input[j]){
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		System.out.println();
		
		for(int out : input){
			System.out.println(out);
		}
	}

}
