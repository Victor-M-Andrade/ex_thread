package threads;

import threads.models.Caminhao;

public class Main {

	public static void main(String[] args) {

		Main app = new Main();
		app.start();

	}

	private void start() {
		
		Caminhao primeiroCaminhao = new Caminhao("Jadlog", 1);
		Caminhao segundoCaminhao = new Caminhao("Sedex", 2);
		
		Thread threadDoPrimeiroCaminhao = new Thread(primeiroCaminhao);
		Thread threadDoSegundoCaminhao = new Thread(segundoCaminhao);
		
		threadDoPrimeiroCaminhao.start();
		threadDoSegundoCaminhao.start();
		
		System.out.println("A aplicação ja esta livre para trabalhar em outras coisas, caso necessário, enquanto as threads estão la trabalhando como escravas :)");
	}

}
