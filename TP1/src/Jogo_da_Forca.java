
import java.util.Scanner;

import javax.print.DocFlavor.STRING;


public class Jogo_da_Forca {
 //vari�veis globais
	static String [] [] tabela = new String [51] [51];
	static int comando_tela_inicial;
	static String comando_temas;
	static String verifica_tabela;
	static boolean condicao = false;
	static int cont;
	static String remove_tabela;
	static String busca_tema;

	public static void main(String[] args) {
		
		// Menu inicial do Jogo
		System.out.print("Jogo da Forca\n ");
		System.out.print("----------------- \n");
		System.out.print("1. Gerenciar Temas\n");
		System.out.print("2. Gerenciar Palavras\n");
		System.out.print("3. Jogar \n");
		System.out.print("4. Sair \n");  
		System.out.print("Digite o n�mero correspondente com as a��es acima: \n");
		Scanner ler = new Scanner(System.in);
		comando_tela_inicial = ler.nextInt();
		
		switch (comando_tela_inicial) {
		case 1: Jogo_da_Forca.gerenciador_Temas(tabela);
		  		break;
		case 2: Jogo_da_Forca.gerenciador_Palavras(tabela);
				break;
		case 4: System.exit(0);
			    break;
		default: System.out.println("N�mero inv�lido! ");
				 Jogo_da_Forca.main(null);
		}

	} // final do Escopo main

 // GERENCIANDO TEMAS --------------------------------------------------------------------------------------------------------	
	public static String [] [] gerenciador_Temas(String [] [] tabela) {
		// Menu Inicial para gerenciar temas
		System.out.println("---------------------------------------------");
		System.out.print("Escolha uma op��o de gerenciamento de temas: \n");
		System.out.print("Digite a) para cadastrar um tema \n");
		System.out.print("Digite b) para excluir um tema \n");
		System.out.print("Digite c) para buscar por um tema \n");
		System.out.print("Digite d) para voltar ao menu inicial \n");
		Scanner ler = new Scanner(System.in);
		comando_temas = ler.next();
		
		switch (comando_temas) {
		case "a": Jogo_da_Forca.cadastro_Temas(tabela);
				  break;
		case "b": Jogo_da_Forca.removedor_Temas(tabela);
				  break;
		case "c": Jogo_da_Forca.buscador_Temas(tabela);
				  break;
		case "d": Jogo_da_Forca.main(null);
				  break;
		default: System.out.print("Valor inv�lido \n");
				 return Jogo_da_Forca.gerenciador_Temas(tabela);
			}
		return Jogo_da_Forca.gerenciador_Temas(tabela);
		} // Final do Escopo gerenciador_Temas
		
	
	
		// Esta fun��o serve para cadastrar os temas assim que quiser
		public static String [] [] cadastro_Temas(String [] [] tabela) {
			Scanner ler = new Scanner(System.in);
			do {
				condicao = false;
				System.out.print("Cadastre um tema: \n");
				verifica_tabela = ler.next(); //vai verificar o tema
				for (int i = 0; i < cont+1; i++) {  // Loop para passar por cada elemento da tabela e verificar a exist�ncia dos temas iguais.
						  if (verifica_tabela.equals(tabela[i][0])) {
								System.out.println("Tema j� cadastrado! Tente novamente...");
								while (verifica_tabela.equals(tabela[i][0])) { // Repetir o loop at� que o usu�rio insira um valor que n�o tenha na tabela
									System.out.println("Cadastre um tema: \n");
									verifica_tabela = ler.next();					
								}
							} else {
								condicao = true;
						}	
				 }
			} while (false);
				tabela[cont][0] = verifica_tabela; // Inserindo os temas dentro da Tabela, de fato.
				System.out.println("---------------------------------------");
				System.out.println("Tema registrado!");
				cont++;
				
				System.out.print("Deseja cadastrar mais algum tema? S/N \n");
				System.out.println("---------------------------------------");
				comando_temas = ler.next();
						
				switch (comando_temas) {
					case "S": return Jogo_da_Forca.cadastro_Temas(tabela);
					case "N":    cont = 0; // reset do contador para futuros preenchimentos de temas
								 System.out.println("----------------------------");
								 System.out.println(tabela [0] [0]); // Verificando se est� cadastrando os temas 
								 System.out.println(tabela [1] [0]); // Verificando se est� cadastrando os temas 
								 System.out.println(tabela [2] [0]); // Verificando se est� cadastrando os temas 
								 System.out.println("----------------------------");
								 return Jogo_da_Forca.gerenciador_Temas(tabela);
					default: System.out.print("Digito inv�lido");
							    Jogo_da_Forca.cadastro_Temas(tabela);
						
					}
			
			
			return Jogo_da_Forca.cadastro_Temas(tabela);
	  } // Final do escopo cadastro_Temas
		
		
		// Fun��o para excluir temas
	public static String [] [] removedor_Temas(String [] [] tabela) {
		int cont = 0;
		Scanner ler = new Scanner(System.in);
		System.out.println("Qual tema deseja excluir? ");
		System.out.println("----------------------------");
		System.out.println("Temas dispon�veis: ");
		for (int i = 0; i <51; i++) {
			if (tabela [i][0] == null) {
				continue;
			}
			System.out.println(tabela [i][0]);
			
			
		}
		System.out.println("----------------------------");
		remove_tabela = ler.next();
		for (int i = 0; i <51; i++) {
			if (remove_tabela.equals(tabela [i][0])) {
				tabela[i][0] = null;
			} else {
				continue;
			}
		}
		System.out.println("-----------------");
		System.out.print("Tema removido!\n" );
		System.out.println(tabela [0] [0]); // Verificando se est� cadastrando os temas 
		 System.out.println(tabela [1] [0]); // Verificando se est� cadastrando os temas 
		 System.out.println(tabela [2] [0]); // Verificando se est� cadastrando os temas 
		
		// Saber se o usu�rio deseja remover mais temas
		System.out.print("Deseja remover mais algum tema? S/N \n");
		comando_temas = ler.next();
		System.out.println("---------------------------------------");
		
		switch (comando_temas) {
		case "S": return Jogo_da_Forca.removedor_Temas(tabela);
		case "N":  return Jogo_da_Forca.gerenciador_Temas(tabela);
		default: System.out.print("Digito inv�lido");
				    Jogo_da_Forca.cadastro_Temas(tabela);
			
		}
		
		
		return Jogo_da_Forca.gerenciador_Temas(tabela);
		
	}// Final do escopo do removedor_Temas
	
	// Fun��o para pesquisar por temas, individualmente.
	public static String [] [] buscador_Temas(String [] [] tabela) {
		System.out.print("Qual tema deseja buscar? \n");
		Scanner ler = new Scanner(System.in);
		busca_tema = ler.next();
		for (int i = 0; i <51; i++) {
			if (busca_tema.equals(tabela[i][0])) {
				System.out.println("Voc� buscou pelo seguinte tema: " + busca_tema);
				System.out.println("----------------------------");
				System.out.print("Deseja procurar por mais algum tema? S/N \n");
				comando_temas = ler.next();
				
				switch (comando_temas) {
				case "S": return Jogo_da_Forca.buscador_Temas(tabela);
				case "N":  return Jogo_da_Forca.gerenciador_Temas(tabela);
				default: System.out.print("Digito inv�lido");
						    Jogo_da_Forca.buscador_Temas(tabela);
					
				} 
			} else {
				System.out.print("O tema que voc� buscou n�o existe :/ \n");
				System.out.println("----------------------------");
				System.out.print("Deseja procurar por mais algum tema? S/N \n");
				comando_temas = ler.next();
				
				switch (comando_temas) {
				case "S": return Jogo_da_Forca.buscador_Temas(tabela);
				case "N":  return Jogo_da_Forca.gerenciador_Temas(tabela);
				default: System.out.print("Digito inv�lido");
						    Jogo_da_Forca.buscador_Temas(tabela);
					
				} 
			}
		}
		return Jogo_da_Forca.buscador_Temas(tabela);
	} // Final do escopo do buscador_Temas
// FIM DAS FUN��ES TEMAS ------------------------------------------------------------------------------------------------------

// FUN��ES QUE GERENCIAM AS PALAVRAS ------------------------------------------------------------------------------------------
	
	public static String [] [] gerenciador_Palavras(String [] [] tabela) {
		// Menu Inicial para gerenciar temas
		System.out.println("---------------------------------------------");
		System.out.print("Escolha uma op��o de gerenciamento de palavras: \n");
		System.out.print("Digite a) para cadastrar uma palavra em algum tema \n");
		System.out.print("Digite b) para excluir uma palavra de algum tema \n");
		System.out.print("Digite c) para buscar por uma palavra \n");
		System.out.print("Digite d) para listagem(ver todas as palavras registradas em um tema) \n");
		System.out.print("Digite e) para voltar ao menu inicial \n");
		Scanner ler = new Scanner(System.in);
		comando_temas = ler.next();
		
		switch (comando_temas) {
		case "a": Jogo_da_Forca.cadastro_Palavras(tabela);
				  break;
		//case "b": Jogo_da_Forca.removedor_Palavras(tabela);
		//		  break;
		//case "c": Jogo_da_Forca.buscador_Palavras(tabela);
				  //break;
		case "e": Jogo_da_Forca.main(null);
				  break;
		default: System.out.print("Valor inv�lido \n");
				 return Jogo_da_Forca.gerenciador_Palavras(tabela);
			}
		return Jogo_da_Forca.gerenciador_Palavras(tabela);
	} // Final do escopo do gerenciador_Palavras
	
	public static String [] [] cadastro_Palavras(String [] [] tabela) {
		
		return Jogo_da_Forca.gerenciador_Palavras(tabela);
	}
		
	} // Final do escopo do Jogo_da_Forca


