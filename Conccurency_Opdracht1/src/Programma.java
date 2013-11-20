import java.util.ArrayList;


public class Programma {
	private ArrayList<Integer> integers = new ArrayList<>();
	
	public static void main(String[] args) {
		Programma programma = new Programma();
		programma.genereerGetallen();
		System.out.println(programma.integers.toString());
	}

	private void genereerGetallen() {
			for(int i = 0; i < 25; i++) {
				int random = (int)(Math.random() * 25  + 1);
				integers.add(random);
			}
	}
}
