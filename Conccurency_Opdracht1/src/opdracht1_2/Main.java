package opdracht1_2;


/**
 * 
 * Class voor het uitvoeren van de tests waarin de benodigde tijd wordt berekend.
 *
 */
public class Main {
	/**
	 * Deze methode voert de verschillend test uit.
	 * @param args
	 */
	public static void main(String[] args) {

		Main op = new Main();
		op.execute(10);
		op.execute(50000);
		op.execute(100000);
		op.execute(200000);
		op.execute(400000);
		op.execute(800000);
	}

	private void execute(int n) {
		System.out.println("Meetresultaten voor " + n + ":");

		long total = 0;
		long smallest = Long.MAX_VALUE;
		long largest = 0;
		
		//random list maken
		RandomListGenerator rg = new RandomListGenerator();
	
		for (int x = 0; x < 12; x++) {
			int[] integers = rg.randomList(n);

			int[] part1 = new int[n/2];
			int[] part2 = new int[n/2];
			
			System.arraycopy(integers, 0, part1, 0, part1.length);
			System.arraycopy(integers, part1.length, part2, 0, part2.length);
			
			long startTime = System.currentTimeMillis();
			Thread thread1 = new Thread(new MyRunnable(part1));			
			Thread thread2 = new Thread(new MyRunnable(part2));
				thread1.start(); 
				thread2.start();
				try {
					thread1.join();
					thread2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			merge(part1, part2);	
			
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
	
	/**
	 * Methode voor het mergen van 2 gesorteerde lijsten
	 * @param part1
	 * @param part2
	 * @return
	 */
	public static int[] merge(int[] part1, int[] part2) {

	    int[] answer = new int[part1.length + part2.length];
	    int a = 0;
	    int b = 0;
	    int c = 0;

	    while (a < part1.length && b < part2.length) {
	        if (part1[a] < part2[b]) {      
	            answer[c++] = part1[a++];
	        } else {
	        	answer[c++] = part2[b++];  
	        }              
	    }

	    while (a < part1.length) { 
	        answer[c++] = part1[a++];
	    }    

	    while (b < part2.length) {   
	        answer[c++] = part2[b++];
	    }    
	    return answer;
	}
}