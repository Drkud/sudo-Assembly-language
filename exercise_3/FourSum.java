import stdlib.StdIn;
import java.util.ArrayList;

class FourSum {
	//should take 2^225 elements for it to take an hour or more to execute
	public static void main(String[] args) {
		ArrayList<Long> longs = new ArrayList<Long>();
		while (!StdIn.isEmpty()) {
			longs.add(StdIn.readLong());
		}
		
		long startTime = System.currentTimeMillis();	
		int count = 0;

		for (int i = 0; i < longs.size(); i++) {
			for (int j = 0; j < longs.size(); j++) {
				for (int k = 0; k < longs.size(); k++) {
					for (int r = 0; r < longs.size(); r++) {
						if (longs.get(i) + longs.get(j) + longs.get(k) + longs.get(r) == 0) {
							count++;
						}
					}
				}
			}
		}

		System.out.println(count);
		System.out.println("Took: " + (System.currentTimeMillis() - startTime) + "ms");
	}
}
