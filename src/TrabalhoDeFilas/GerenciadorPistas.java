package TrabalhoDeFilas;
import java.util.Random;

public class GerenciadorPistas {
	ListaEncadeada filaPousar1;
	ListaEncadeada filaPousar2;
	ListaEncadeada filaDecolar1;
	ListaEncadeada filaDecolar2;
	private int tempo;
	private int somaTempoPousar;
	private int somaTempoDecolar;
	private int totalPousos;
	private int totalDecolagens;
	private int totalEmergencias;
	private GeradorDeAvioes gerador;
	
	public GerenciadorPistas() {
		this.filaPousar1 = new ListaEncadeada();
		this.filaPousar2 = new ListaEncadeada();
		this.filaDecolar1 = new ListaEncadeada();
		this.filaDecolar2 = new ListaEncadeada();
		this.tempo = 0;
		this.somaTempoPousar = 0;
		this.somaTempoDecolar = 0;
		this.totalPousos = 0;
		this.totalDecolagens = 0;
		this.totalEmergencias = 0;
		this.gerador = new GeradorDeAvioes();
	}
	//adicona de 0 a 2 avioes na fila
	public void adicionarAvioes(){
		int numeroPousar = gerador.quantidadeAvioes();
		int numeroDecolar = gerador.quantidadeAvioes();
		
		if(numeroPousar == 0) {
			System.out.println("Nao chegou nenhum aviao para pousar");
		}
		if(numeroDecolar == 0) {
			System.out.println("Nao chegou nenhum aviao para Decolar");
		}
		for(int i = 0; i < numeroPousar; i++) {
			Aviao aviaoPousar = gerador.gerarAviaoPouso(tempo);
			if(filaPousar1.contarLista() <= filaPousar2.contarLista()){
				filaPousar1.inserirFinal(aviaoPousar);
			}else {
				filaPousar2.inserirFinal(aviaoPousar);
			}
			System.out.println("chegou para pousar: " + aviaoPousar.toString());
		}
		for(int i = 0; i < numeroDecolar; i++) {
			Aviao aviaoDecolar = gerador.gerarAviaoDecolagem(tempo);
			if(filaDecolar1.contarLista() <= filaDecolar2.contarLista()){
				filaDecolar1.inserirFinal(aviaoDecolar);
			}else {
				filaDecolar2.inserirFinal(aviaoDecolar);
			}
			System.out.println("chegou para decolar: " + aviaoDecolar.toString());
		}
	}
	// decide se  o aviao vai pousar ou decolar
	public void decolarOuPousar(int pista) {
		int tempoPousar = 0;
		int tempoDecolar = 0;
		
		ListaEncadeada filaPousar;
		ListaEncadeada filaDecolar;
		if(pista == 1) {
			filaPousar = filaPousar1;
			filaDecolar = filaDecolar1;	
		}else {
			filaPousar = filaPousar2;
			filaDecolar = filaDecolar2;	
		}
		Aviao emergencia = filaPousar.buscarEmergencia();
		
		if(emergencia != null) {
			Aviao aviaoEmergencia = filaPousar.removerValor(emergencia);
			tempoPousar = tempo - aviaoEmergencia.getTempo();
			somaTempoPousar += tempoPousar;
			totalPousos++;
			totalEmergencias++;
			System.out.println("Pista: " + pista + " id:" + aviaoEmergencia.getId() + " Pouso de emergencia!!");
			return;
		}
		int numeroPousar = filaPousar.contarLista();
		int numeroDecolar = filaDecolar.contarLista();
		
		if(numeroPousar == 0 && numeroDecolar ==0) {
			System.out.println("Nenhuma açao na pista: " + pista);
			return;
		}
		if(numeroPousar > 0 && numeroDecolar == 0) {
			Aviao aviao = filaPousar.removerInicio();
			tempoPousar = tempo - aviao.getTempo();
			somaTempoPousar += tempoPousar;
			totalPousos++;
			System.out.println("Pista: " + pista + " id:" + aviao.getId() + " Pousou.");
			return;
		}
		if(numeroDecolar > 0 && numeroPousar == 0) {
			Aviao aviao = filaDecolar.removerInicio();
			tempoDecolar = tempo - aviao.getTempo();
			somaTempoDecolar += tempoDecolar;
			totalDecolagens++;
			System.out.println("Pista: " + pista + " id:" + aviao.getId() + " Decolou.");
			return;
		}
		if(numeroPousar >= numeroDecolar) {
			Aviao aviao = filaPousar.removerInicio();
			tempoPousar = tempo - aviao.getTempo();
			somaTempoPousar += tempoPousar;
			totalPousos++;
			System.out.println("Pista: " + pista + " id:" + aviao.getId() + " Pousou.");
			return;
		}else {
			Aviao aviao = filaDecolar.removerInicio();
			tempoDecolar = tempo - aviao.getTempo();
			somaTempoDecolar += tempoDecolar;
			totalDecolagens++;
			System.out.println("Pista: " + pista + " id:" + aviao.getId() + " Decolou.");
			return;
		}
	}
	// aplica o decolarOuPousar nas duas filas pra nao repetir o codigo
	public void acaoNasPistas() {
		 decolarOuPousar(1);
		 decolarOuPousar(2);
	}
	// executar o programa por 20 unidades de tempo e printa as informaçoes
	public void executar() {
		while (tempo < 20) {
			System.out.println("___________________");
			System.out.println("------------------");
			System.out.println("tempo: " + tempo);
			System.out.println("------------------");
			// gerar avioes 
			filaPousar1.diminuirCombustivelTodos();
			filaPousar2.diminuirCombustivelTodos();
			adicionarAvioes();
			System.out.println("------------------");
			//decolar ou pousar avioes
			acaoNasPistas();
			System.out.println("------------------");
			// Mostrar filas
			System.out.println("Filas:");
			System.out.println("Fila pouso pista 1:");
		    filaPousar1.mostrarIds();
	
		    System.out.println("Fila pouso pista 2:");
		    filaPousar2.mostrarIds();
	
		    System.out.println("Fila decolagem pista 1:");
		    filaDecolar1.mostrarIds();
	
		    System.out.println("Fila decolagem pista 2:");
		    filaDecolar2.mostrarIds();
		    System.out.println("___________________");
		    tempo++;
		//mostra os dados de tempo e quantidade de pousos, decolagens e emergencias
			System.out.println("Dados: ");
			System.out.println("Numero de pousos: " + totalPousos);
			System.out.println("Numero de decolagens: " + totalDecolagens);
			if(totalPousos > 0) {
			System.out.printf("Tempo medio para pousar:  %.2f unidade de tempo %n" , ((double)somaTempoPousar/totalPousos));
			}else {
				System.out.println("Tempo medio para pousar: 0");
			}
			if(totalDecolagens > 0) {
				System.out.printf("Tempo medio para decolar:  %.2f unidade de tempo %n" , ((double)somaTempoDecolar/totalDecolagens));
			}else {
				System.out.println("Tempo medio para decolar: 0");
			}
			System.out.println("Numero total emergencias: " + totalEmergencias);
		}
	}
	
}
