package opdracht1_2;

/**
 * Class for sorting unsorted lists.
 */
public class ListSorter {

	/**
	 * This method returns a sorted ArrayList of integers by sorting the list with the Insertion Sort principle.
	 * @param integers
	 * @return ArrayList<Integer> sorted
	 */
	public void insertionSort(int[] integers) {
		for (int i = 1; i < integers.length; i++) {
			int j = i;
			int temp = integers[i];
			
			while ((j > 0) && (integers[j-1] > temp)){
				integers[j] = integers[j-1];
				j--;
			}
			integers[j] = temp;
		}
	}
	
}