package threads;

public class runnable {
	
	//Implemente a interface Runnable
	//Faça um exemplo usando o método sleep nas Threads;
	//Faça um exemplo do método join da Thread;
	public static void main(String[] args) {
		
		threadRunnable thread1 = new threadRunnable("1", 500);
		Thread t1 = new Thread(thread1);
		t1.start();

		threadRunnable thread2 = new threadRunnable("2", 800);
		Thread t2 = new Thread(thread2);
		t2.start();
		
		
		//usar metodo join para esperar a execução de uma determinada thread
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
