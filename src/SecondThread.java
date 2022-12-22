
public class SecondThread extends Thread {
	public SecondThread(String str) {
		super(str);
	}
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("No " + i + " Th 2");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
