package Classes;

import java.util.stream.*;
import java.util.*;

/**
 * @author Deiner.Souza
 */
public class Main {

	public static void main(String[] args) {
		
		Set<Pessoas> listaPessoas = new HashSet<>();
		Map<Integer, Set<Pessoas>> listaGeneros = new HashMap<>();
		
		
		listaPessoas = CadastroPessoas();
		listaGeneros = filtroGenero(listaPessoas);
		
		System.out.println("------------ Imprimindo Mulheres ------------\n");
		imprimirPessoas(listaGeneros.get(1));
		
		System.out.println("\n\n------------ Imprimindo Homens ------------\n");
		imprimirPessoas(listaGeneros.get(2));
		
		
		
	}
	
	
	/**
	 * <h1>Saída</h1>
	 * <ol> 
	 * 		<li>Recebe CHAVE da listaGenero que representa uma lista de cada genero</li>
	 * 		<li>Utilizando um forEach para percorrer pela lista imprimindo os atributos de cada objeto</li>
	 * </ol>
	 * 
	 * @param listaGeneroPessoas
	 */
	private static void imprimirPessoas(Set<Pessoas> listaGeneroPessoas) {
		listaGeneroPessoas.forEach(e -> System.out.println("Nome: "+e.getNome() + "Genero: "+e.getGenero()+"\n\n"));
	}
	
	
	/**
	 * <h1>Filtro</h1>
	 * <ol> 
	 * 		<li>Recebe listaPessoas</li>
	 * 		<li>Instancia um Map listaGenero, CHAVE: Integer e o VALOR: lista de objetos Pessoa</li>
	 * 		<li>Utilizando Stream() para filtrar a listaPessoas em duas novas listas, listaHomens e listaMulheres</li>
	 * 		<li>Atribuimos listaHomens e listaMulheres na listaGenero</li>
	 * 		<li>Retornamos listaGenero</li>
	 * </ol>
	 * @param Set listaPessoas
	 * @return Map listaGenero 
	 */
	private static Map<Integer, Set<Pessoas>> filtroGenero(Set<Pessoas> listaPessoas ) {
		
		Map<Integer, Set<Pessoas>> listaGeneros = new HashMap<>();
		
		Set<Pessoas> listaHomens = listaPessoas.stream().filter(p -> p.getGenero().equalsIgnoreCase("h")).collect(Collectors.toSet());
		Set<Pessoas> listaMulheres = listaPessoas.stream().filter(p -> p.getGenero().equalsIgnoreCase("m")).collect(Collectors.toSet());
		
		listaGeneros.put(1, listaMulheres);
		listaGeneros.put(2, listaHomens);
		
		return listaGeneros; 
	}


	/**
	 * <h1>Cadastro</h1>
	 * <ol> 
	 * 		<li>Instancia HashSet listaPessoas</li>
	 * 		<li>Instancia O Scanner com bloco try_with_resources</li>
	 * 		<li>Declara varial que conterá condição de entrada e saída do bloco while</li>
	 * 		<li>Declara while, continuar execultando enquando porta igual "sim" </li>
	 * 		<li>Recebe do console nome e genero</li>
	 * 		<li>Faz validação do genero com blocos if else</li>
	 * 		<li>Inicia construtorPessoas com as variaveis coletadas no scan</li>
	 * 		<li>Atribui a construção do objeto à listaPessoas</li>
	 * 		<li>Informa se a opração foi concluida e se gostaria de cadastrar outro</li>
	 * 		<li>Retorna a lista de cadastro</li>
	 * </ol>
	 * 
	 * @return Set ListaPessoas
	 */
	private static Set<Pessoas> CadastroPessoas() {
		
		Set<Pessoas> ListaPessoas = new HashSet<>();
		
			try (Scanner scan = new Scanner(System.in)) {
				String porta = "sim"; 
				
				
				System.out.println("Bem vindo ao sistema de cadastro de pessoas\n\n");
				while(porta.equalsIgnoreCase("sim")) {
					System.out.println("Informe o nome da pessoa à ser cadastrada: \n");
					String nome = scan.nextLine();
					System.out.println("Informe o genero da pessoa à ser cadastrado: \n");
					String genero = scan.nextLine();
					
					if(genero.equalsIgnoreCase("homen")) {
						genero = "H";
						
					}else if(genero.equalsIgnoreCase("mulher")) {
						genero = "M";
						
					}else if(genero != "M" || genero != "m" || genero != "h" || genero != "H")  {
						System.out.println("Genero informado não está na base de dados\n");
						continue;				
					}
					
					Pessoas construtorPessoas = new Pessoas(nome, genero);
					
					ListaPessoas.add(construtorPessoas);
					System.out.println("Cadastro concluido!\n");
					
					System.out.println("Deseja continuar cadastrando pessoas? Sim ou Não?");
					porta = scan.nextLine();
				}
			} 
			return ListaPessoas;
	}
	
	
	

}
