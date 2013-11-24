package main;

import java.util.ArrayList;

public class CopyOfListSorter {

	public ArrayList<Integer> insertionSort(int[] integers) {
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println();
		
		for(int index = 0; index < integers.length; index++) {
			
			if(list.isEmpty()) {
				list.add(integers[index]);
				System.out.println(list.toString());
			}
			
			else if(integers[index] >= list.get(index-1)) {
				list.add(integers[index]);
				System.out.println(list.toString());
			}
			
			else {
				int n = 0;
				while(integers[index] < list.get(index-1-n) && index-n > 0 ) {
					n++;
					if(index-1-n < 0) break;
				}
				
				list.add(index-n, integers[index]);
				System.out.println(list.toString());
			}
		}
		return list;
	}
}
