class Test {
	// exponential time?
	public static int f(int n) {
		if (n == 0) return 1;
		return f(n-1) + f(n-1);
	}

	// yes it is exponential time
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		f(Integer.parseInt(args[0]));
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
