package threads;
public class Dispatcher {
	public static void main(String[] args) throws InterruptedException {
		Thread myThread = Thread.currentThread();
		System.out.println(myThread.getName());
		myThread.setName("MyThread");
		System.out.println(myThread.getName());
		System.out.println(myThread.getPriority());
		myThread.setPriority(9);
		System.out.println(myThread.getPriority());
		System.out.println(myThread.isAlive());
		Thread other = new Thread(new OtherThread());
		other.start();
		new Thread (new OtherThread()).start();
		for(int i = 0; i < 5; i++) {
			Thread.sleep(2000);
			System.out.println("i = " + i);
			if (i == 2) {
				other.join();
			}
		}
	}
}
class OtherThread implements Runnable{
	public void run() {
		for(int j = 0; j < 5; j++) {
			try {
				Thread.sleep(2000);
				System.out.println("j = " + j);
			}catch (InterruptedException e) {}
		}
	}
}