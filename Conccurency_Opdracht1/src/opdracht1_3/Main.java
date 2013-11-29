package opdracht1_3;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		Main op = new Main();
		op.execute(16, 4);
		// op.execute(50000);
		// op.execute(100000);
		// op.execute(200000);
		// op.execute(400000);
		// op.execute(800000);
	}

	private void execute(int nGetallen, int nThreads) {
		System.out.println("Meetresultaten voor een lijst met de grootte: " + nGetallen);
		
		// random list maken
		RandomListGenerator rg = new RandomListGenerator();
		int[] integers = rg.randomList(nGetallen);

		for(int x = 0; x < 10; x++){
			
		ArrayList<Thread> threads = new ArrayList<>();
		ArrayList<int[]> parts = new ArrayList<>();
		int start = 0;

		for (int t = 0; t < nThreads; t++) {
			int [] part = new int[nGetallen / nThreads];
			parts.add(part);

			System.arraycopy(integers, start, part, 0, part.length);
			start += part.length;

			Thread thread = new Thread(new MyRunnable(part));
			
			threads.add(thread);
		}

			long startTime = System.currentTimeMillis();

			for (Thread thread : threads) {
				thread.start();
			}
		
			try {
			
				for (Thread thread : threads) {
					thread.join();
				}
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			int[] mergeint = merge(parts);

			for (int i = 0; i < mergeint.length; i++) {
				System.out.print("[" + mergeint[i] + "], ");
			}
			long endTime = System.currentTimeMillis();
			System.out.println((endTime - startTime) + " ms,");
			System.out.println("-------------------------------------------------------------");
		}
	}
	
	public static int[] merge(ArrayList<int[]> parts) {

		int totalLenght = 0;
		for(int[] part: parts) {
			totalLenght += part.length;
			
			for(int i : part) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}
		
	    int[] answer = new int[totalLenght]; 
	    
	    
	    return answer;
	}
}
