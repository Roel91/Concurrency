package opdracht1_2;


public class Main {
	public static void main(String[] args) {

		Main op = new Main();
		op.execute(10);
//		op.execute(50000);
//		op.execute(100000);
//		op.execute(200000);
//		op.execute(400000);
//		op.execute(800000);
	}

	private void execute(int n) {
		System.out.println("Meetresultaten voor " + n + ":");

		//random list maken
		RandomListGenerator rg = new RandomListGenerator();
		int[] integers = rg.randomList(n);

		int[] part1 = new int[n/2];
		int[] part2 = new int[n/2];

		System.arraycopy(integers, 0, part1, 0, part1.length);
		System.arraycopy(integers, part1.length, part2, 0, part2.length);
		
		for (int x = 0; x < 10; x++) {
			
			
			Thread thread1 = new Thread(new MyThread(part1));			
			Thread thread2 = new Thread(new MyThread(part2));
				thread1.start(); 
				thread2.start();
		}
	}
}
