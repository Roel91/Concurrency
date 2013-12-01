package opdracht1_3;

import opdracht1_3.RandomListGenerator;

public class Main {
	public static void main(String[] args) {

		Main op = new Main();
		op.execute(25000);
		op.execute(50000);
		op.execute(100000);
		op.execute(200000);
		op.execute(400000);
		op.execute(800000);
		op.execute(1600000);
		op.execute(3200000);
	}

	private void execute(int nGetallen) {
		System.out.println("Meetresultaten voor een lijst met de grootte: " + nGetallen);
		
		//random list maken
		RandomListGenerator rg = new RandomListGenerator();
	
		long total = 0;
		long smallest = Long.MAX_VALUE;
		long largest = 0;
		
		for (int x = 0; x < 12; x++) {
			long startTime = System.currentTimeMillis();

			int[] integers = rg.randomList(nGetallen);	
			ThreadTree tree = new ThreadTree();
			tree.build(integers);
			
			
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
		System.out.println("--------------------------------------------------------------------------------");
	}
}
