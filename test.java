
interface StringFunction {

		void run(int r1);
		}

public class test {
		  public static void main(String[] args) {
			StringFunction exclaim = (s) -> System.out.println(s + "!");;
			StringFunction ask = (s) -> System.out.print(s);
			ask.run(1);

		  }	
}