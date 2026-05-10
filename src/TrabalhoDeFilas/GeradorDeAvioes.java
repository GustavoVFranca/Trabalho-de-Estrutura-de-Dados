package TrabalhoDeFilas;
import java.util.Random;

public class GeradorDeAvioes {
	private Random random;
	private int idPousar;
	private int idDecolar;
	
	public GeradorDeAvioes() {
		this.random = new Random();
		this.idPousar = 1;
		this.idDecolar = 2;
	}
	public int quantidadeAvioes() {
		int numero= random.nextInt(3);
		return numero;
	}
	public Aviao gerarAviaoPouso(int tempo) {
		int combustivel =  random.nextInt(20)+1;
		Aviao aviao = new Aviao(idPousar, "pousar", combustivel, tempo);
		idPousar += 2;
		return aviao;
	}
	public Aviao gerarAviaoDecolagem(int tempo) {
		Aviao aviao = new Aviao(idDecolar, "decolar", 0, tempo);
		idDecolar += 2;
		return aviao;
	}
}
