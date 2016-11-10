import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class Leitor {
	GeneralTreeOfString arvore = new GeneralTreeOfString();
	private BufferedReader br;

	public void ler() throws IOException{
		FileInputStream stream = new FileInputStream("C:\\Users\\13104443\\Downloads\\teste.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		br = new BufferedReader(reader);
		String linha = br.readLine();
		arvore.add(linha);
		linha = br.readLine();
		do{
			if(linha.startsWith("C")){
				Node cap = arvore.add(linha, arvore.getRootN());
				do{
					if(linha.startsWith("P"))
						arvore.add(linha, cap);
					if(linha.startsWith("S")){
						Node sec = arvore.add(linha, cap);
						do{
							if(linha.startsWith("P"))
								arvore.add(linha, sec);
							if(linha.startsWith("SS")){
								Node ssec = arvore.add(linha, sec);
								do{
									if(linha.startsWith("P")){
										arvore.add(linha, ssec);
									}
								}while(!linha.startsWith("SS") ||linha!=null);
							} 
							linha = br.readLine();
						}while(!linha.startsWith("S") || linha!=null);
					}
					linha = br.readLine();
				}while(!linha.startsWith("C") || linha!=null);
			}
			linha = br.readLine();
		}while(!linha.startsWith("L" ) || linha!=null);
		System.out.println();
	}
}

