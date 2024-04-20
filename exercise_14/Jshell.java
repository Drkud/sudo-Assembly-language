public static int getCoupon(int n)
{ // Return a random integer between 0 and n-1.
return (int) (Math.random() * n);
}

public static int collectCoupons(int n) throws InterruptedException
{ // Collect coupons until getting one of each value
// and return the number of coupons collected.
boolean[] isCollected = new boolean[n];
int count = 0, distinct = 0;
while (distinct < n)
{
Thread.currentThread().sleep(1);
int r = getCoupon(n);
count++;
if (!isCollected[r])
distinct++;
isCollected[r] = true;
}
return count;
}

long speedTest(int n) throws InterruptedException {
	long start = System.currentTimeMillis();
	collectCoupons(n);
	return System.currentTimeMillis() - start;
}