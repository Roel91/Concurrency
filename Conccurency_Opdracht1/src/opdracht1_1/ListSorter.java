package opdracht1_1;

/**
 * Class voor het sorteren van een ongesorteerde lijst
 */
public class ListSorter {

	/**
	 * Deze methode stuurt een gesorteerde ArrayList terug volgens het Insertion Sort principe.
	 * @param integers
	 * @return ArrayList<Integer> sorted
	 */
	public void insertionSort (int[] integers) {
		for (int i = 1; i < integers.length; i++) {
			int j = i;
			int temp = integers[i];
			
			while ((j > 0) && (integers[j-1] > temp)) {
				integers[j] = integers[j-1];
				j--;
			}
			integers[j] = temp;
		}
	}
}