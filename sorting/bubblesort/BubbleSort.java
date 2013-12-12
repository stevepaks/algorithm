package bubblesort;

public class BubbleSort {
	private int[] input;

	public static void main(String[] args) {
		int[] input = { 5, 1, 4, 2, 8 };

		BubbleSort sorter = new BubbleSort(input);

		for (int i : input) {
			System.out.print(i);
		}
		System.out.println();

		sorter.bubbleSort();

		for (int i : input) {
			System.out.print(i);
		}
		System.out.println();
	}

	public BubbleSort(int[] input) {
		this.input = input;
	}

	public void bubbleSort() {
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 1; i < this.input.length; i++) {
				if (this.input[i - 1] > this.input[i]) {
					this.swap(i - 1, i);
					swapped = true;
				}
			}
		}
	}

	private void swap(int left, int right) {
		int temp = this.input[left];
		this.input[left] = this.input[right];
		this.input[right] = temp;
	}

}
