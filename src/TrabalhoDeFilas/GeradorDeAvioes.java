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
	/**
	 * Retorna um numero aleatorio de 0 a 2 para definir quantos avioes vao chegar nessa unidade de tempo.
	 * @return quantidade de avioes (0, 1 ou 2)
	 */
	public int quantidadeAvioes() {
		int numero= random.nextInt(3);
		return numero;
	}
	/**
	 * Cria um aviao com objetivo de pousar, com id impar e combustivel aleatorio entre 1 e 20.
	 * @param tempo atual da simulacao
	 * @return aviao gerado para pousar
	 */
	public Aviao gerarAviaoPouso(int tempo) {
		int combustivel =  random.nextInt(20)+1;
		Aviao aviao = new Aviao(idPousar, "pousar", combustivel, tempo);
		idPousar += 2;
		return aviao;
	}
	/**
	 * Cria um aviao com objetivo de decolar com id par. O combustivel e 0 pois so avioes de pouso tem emergencia.
	 * @param tempo atual da simulacao
	 * @return aviao gerado para decolar
	 */
	public Aviao gerarAviaoDecolagem(int tempo) {
		Aviao aviao = new Aviao(idDecolar, "decolar", 0, tempo);
		idDecolar += 2;
		return aviao;
	}
}
