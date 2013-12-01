package opdracht1_3;
/**
 * 
 * Class voor het aanmaken van threads in een boom structuur,
 * waarbij de leafs als eerste uitgevoerd worden en daarna de parents daarvan.
 *
 */
public class ThreadTree {

	private ThreadTree left, right;
	private MyRunnable runnable;
	private Thread thread;
	
	public int[] build(int[] integers) {
		if(integers.length > 1000) {
			
			int splitPoint = (integers.length / 2);
			
			int[] part1 = new int[splitPoint];
			int[] part2 = new int[splitPoint];

			System.arraycopy(integers, 0, part1, 0, part1.length);
			System.arraycopy(integers, part1.length, part2, 0, part2.length);
			
			left = new ThreadTree();
			part1 = left.build(part1);
			
			right = new ThreadTree();
			part2 = right.build(part2);
			
			integers = merge(part1, part2);
		}
		System.arraycopy(integers, 0, integers, 0, integers.length);
		
		runnable = new MyRunnable(integers);
		thread = new Thread(runnable);		
		thread.start();
		try {
			thread.join();		
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		return integers;		
	}

	/**
	 * Methode voor het mergen van 2 gesorteerde lijsten
	 * @param part1
	 * @param part2
	 * @return
	 */
	private int[] merge(int[] part1, int[] part2) {
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
