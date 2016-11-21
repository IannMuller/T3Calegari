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
		if(linha.startsWith("C") && linha!=null){
			
			Node cap = arvore.add(linha, arvore.getRootN());
			linha = br.readLine();
			do{
				if(linha.startsWith("P") && linha!=null){
					arvore.add(linha, cap);
					linha = br.readLine();
				}
				if(linha.startsWith("S") && linha!=null){
					Node sec = arvore.add(linha, cap);
					linha = br.readLine();
					do{
						if(linha.startsWith("P") && linha!=null){
							arvore.add(linha, sec);
							linha = br.readLine();
						}
						if(linha.startsWith("SS") && linha!=null){
							Node ssec = arvore.add(linha, sec);
							linha = br.readLine();
							do{
								if(linha.startsWith("P") && linha!=null){
									arvore.add(linha, ssec);
									linha = br.readLine();
								}
							}while(linha!=null && !linha.startsWith("S") && !linha.startsWith("SS"));
						}
					}while(linha!=null && !linha.startsWith("C") && !linha.startsWith("S"));
				}
			}while(linha!=null && !linha.startsWith("C"));
		}	
		}while(linha!=null);
		arvore.positionsPre();
	}
}

