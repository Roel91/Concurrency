package opdracht1_2;

public class MyThread implements Runnable {
	private int[] integers;
	private static int[] sortedIntegers;
	
	public MyThread(int[] integers) {
		this.integers = integers;
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		ListSorter sorter = new ListSorter();

		sorter.insertionSort(integers);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime + " ms, ");
	}

	public int[] getSortedIntegers() {
		return sortedIntegers;
	}

	public static void setSortedIntegers(int[] list) {
		MyThread.sortedIntegers = list;
	}
	
	
}
