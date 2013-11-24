package main;

public class Opdracht1_1 {
	public static void main(String[] args) {

		Opdracht1_1 op = new Opdracht1_1();
		op.execute(25000);
		op.execute(50000);
		op.execute(100000);
		op.execute(200000);
		op.execute(400000);
		op.execute(800000);
	}

	private void execute(int n) {
		System.out.println("Meetresultaten voor " + n + ":");
		RandomListGenerator rg = new RandomListGenerator();
		int[] integers = rg.randomList(n);

		ListSorter sorter = new ListSorter();
		long total = 0, smallest = Long.MAX_VALUE, largest = 0;
		for (int x = 0; x < 12; x++) {
			long startTime = System.currentTimeMillis();

			sorter.insertionSort(integers);

			long duration = System.currentTimeMillis() - startTime;

			total = total + duration;
			if(duration > largest) {
				largest = duration;
			}
			else if(duration < smallest) {
				smallest = duration;
			}
			
			System.out.print(duration + " ms, ");
		}
		System.out.println();
		System.out.println("gemiddeld " + ((total - largest - smallest)  / 10) + " ms (kleinste en grootste niet meegerekend)");
		System.out.println("-------------------------------------------------------------------------");
	}
}
