package opdracht1_2;

public class MyThread implements Runnable {
	private int[] integers;
	
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
}
