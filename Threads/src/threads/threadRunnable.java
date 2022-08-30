package threads;

public class threadRunnable implements Runnable{

		private String nome;
		private int tempo;
		
	
	public threadRunnable(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
	}
	
	@Override
	public void run() {
		try {
			for(int i = 1; i < 6; i++) {
				System.out.println(nome + " - contador " + i);
				Thread.sleep(tempo);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
