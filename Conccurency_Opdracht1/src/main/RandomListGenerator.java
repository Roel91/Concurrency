package main;
import java.util.Random;


public class RandomListGenerator {

	/**
	 * Random lijst met alle mogelijke getallen van 0 t/m n
	 * 
	 * @param n Bovengrens van de lijst
	 */
	public int[] randomList(int n) {

		int[] a = new int[n];

		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}

		Random r = new Random();
		for (int i = 0; i < a.length; i++) {

			int randomInt = r.nextInt(n);
			int temp = a[randomInt];

			a[randomInt] = a[i];
			a[i] = temp;
		}
		return a;
	}
}
