package threads.models;

import java.util.HashMap;
import java.util.Map;

public class Caminhao implements Runnable {

	public Caminhao(String nome, int intervalo) {
		this.nome = nome;
		this.intervalo = intervalo * 1000;
	}

	private String nome;
	private int intervalo;
	
	private Map<Integer, Integer> limiteDeCadaCaixa = new HashMap<Integer,Integer>();
	
	private final int MAX_CAIXAS = 4;

	@Override
	public void run() {
		
		System.out.println("Caminhão " + this.nome + " começou a ser carregado");
		
		setarLimiteDeCadaCaixa();
		
		int numeroDaCaixa = 1;
		while(numeroDaCaixa <= MAX_CAIXAS) {
			
			carregarACaixa(numeroDaCaixa);
			
			System.out.println("A caixa " + numeroDaCaixa + " do caminhão " + this.nome + " terminou de ser carregado");
			
			numeroDaCaixa += 1;
		}
		
		System.out.println("Caminhão " + this.nome + " terminou de ser carregado");
	}
	
	private void setarLimiteDeCadaCaixa() {
		
		limiteDeCadaCaixa.put(1, 4);
		limiteDeCadaCaixa.put(2, 2);
		limiteDeCadaCaixa.put(3, 5);
		limiteDeCadaCaixa.put(4, 6);
	}
	
	private void carregarACaixa(int numeroDaCaixa) {
		
		int capacidadeDaCaixa = limiteDeCadaCaixa.get(numeroDaCaixa);
		
		for (int i = 0; i < capacidadeDaCaixa; i++) {
			
			try {
				Thread.sleep(this.intervalo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("O pão " + i + " foi inserido na caixa de número " + numeroDaCaixa + " no caminhão " + this.nome);
		}
		
	}

}
