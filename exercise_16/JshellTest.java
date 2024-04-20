long f1(int n) {
	long startTime = System.currentTimeMillis();
	String s = "";
	for (int i = 0; i < n; i++)
		if (StdRandom.bernoulli(0.5)) s += "0";
		else s += "1";
	return System.currentTimeMillis() - startTime;
}

long f2(int n) {
	long startTime = System.currentTimeMillis();
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < n; i++)
		if (StdRandom.bernoulli(0.5)) sb.append("0");
		else sb.append("1");
	String s = sb.toString();
	return System.currentTimeMillis() - startTime;
}
