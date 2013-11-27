package opdracht1_2;

import java.util.ArrayList;
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
		ArrayList<Integer> list = new ArrayList<>();
		/*Loops trough all integers in the array.*/
		for(int index = 0; index < integers.length; index++) {
			
			/*The first Integer is added to the list.*/
			if(list.isEmpty()) {
				list.add(integers[index]);
				
			}
			
			/*The list remains sorted if the the Integer is larger then its neighbor.*/
			else if(integers[index] >= list.get(index-1)) {
				list.add(integers[index]);
			}
			
			/*If it's smaller then its neighbor it will have to go n more neighbors back
			 * until that neighbor is smaller*/
			else {
				int n = 0;
				while(integers[index] < list.get(index-1-n)) {
					n++;
					if(index-1-n < 0) break;
				}	
				list.add(index-n, integers[index]);
			}
			
		}
		System.out.println(list);
	}
}