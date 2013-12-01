package opdracht1_1;
import java.util.Random;

/**
 * 
 * Class voor het maken van een willekeurige lijst
 *
 */
public class RandomListGenerator {

	/**
	 * Random lijst met mogelijke getallen van 0 t/m n (meerdere van hetzelfde mogelijk)
	 * 
	 * @param n Bovengrens van de lijst
	 */
	public int[] randomList(int n) {

		int[] a = new int[n];

		for (int i = 0; i < a.length; i++) {
			Random r = new Random();
			a[i] = r.nextInt(n);
		}

		return a;
	}
}
