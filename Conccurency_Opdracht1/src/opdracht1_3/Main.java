package opdracht1_3;

public class Main {
	public static void main(String[] args) {

		Main op = new Main();
		op.execute(100);
		op.execute(50000);
		op.execute(100000);
		op.execute(200000);
		op.execute(400000);
		op.execute(800000);
	}

	private void execute(int nGetallen) {
		System.out.println("Meetresultaten voor een lijst met de grootte: " + nGetallen);
		
		long total = 0;
		
		for(int x = 0; x < 10; x++){
			long startTime = System.currentTimeMillis();
			RandomListGenerator rg = new RandomListGenerator();
			int[] integers = rg.randomList(nGetallen);
			
			ThreadTree tree = new ThreadTree();
			tree.build(integers);
			
			long endTime = System.currentTimeMillis();
			long duration = endTime - startTime;
			total = total + duration;
			System.out.print(duration + " ms, ");
			
		}
		System.out.println();
		System.out.println("Gemiddeld: " + (total/10) + " ms");
		System.out.println("-------------------------------------------------------------");
	}
}
