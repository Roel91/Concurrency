package opdracht1_3;

public class MyRunnable implements Runnable {
	private int[] integers;
	private static int[] sortedIntegers;
	
	public MyRunnable(int[] integers) {
		this.integers = integers;
	}

	@Override
	public void run() {
		ListSorter sorter = new ListSorter();

		sorter.insertionSort(integers);
	}

	public int[] getSortedIntegers() {
		return sortedIntegers;
	}

	public static void setSortedIntegers(int[] list) {
		MyRunnable.sortedIntegers = list;
	}
	
	
}
