boolean young(int num, int[][] tableau) {
	int index = 0;
	for (int i = tableau.length - 1; i > -1; i--) {
		if (tableau[i][i] <= num) {
			index = i;
			break;
		}
	}

	for (int i = index; i < tableau.length; i++) {
		if (tableau[index][i] == num) {
			return true;
		} else if (tableau[i][index] == num) {
			return true;
		}
	}

	return false;
}
