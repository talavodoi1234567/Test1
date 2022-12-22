
public class ThreadDemo {
	public static void main(String[] args) {
		Thread t1 = new FirstThread("");
		Thread t2 = new SecondThread("");
		t1.start();
		t2.start();
	}
}
