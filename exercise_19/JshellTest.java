public static String reverse1(String s) throws InterruptedException
{
	int n = s.length();
	String reverse = "";
	for (int i = 0; i < n; i++) {
		reverse = s.charAt(i) + reverse;
		Thread.currentThread().sleep(1);
	}
	return reverse;
}

public static String reverse2(String s) throws InterruptedException
{
	int n = s.length();
	if (n <= 1) return s;
	String left = s.substring(0, n/2);
	String right = s.substring(n/2, n);
	Thread.currentThread().sleep(1);
	return reverse2(right) + reverse2(left);
}

public static long speed1(String s) throws InterruptedException
{
	long startTime = System.currentTimeMillis();
	reverse1(s);
	return System.currentTimeMillis() - startTime;
}

public static long speed2(String s) throws InterruptedException
{
	long startTime = System.currentTimeMillis();
	reverse2(s);
	return System.currentTimeMillis() - startTime;
}
