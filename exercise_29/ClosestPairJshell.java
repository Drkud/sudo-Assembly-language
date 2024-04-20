int[] closestPair(int[] integers) {
	int[] pair = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
	
	for (int i = 0; i < integers.length; i++) {
		for (int j = i + 1; j < integers.length; j++) {
			if (Math.abs(integers[i] - integers[j]) < Math.abs((double)pair[0] - pair[1])) {
				pair = new int[] { integers[i], integers[j] };
			}
		}
	}

	return pair;
}
