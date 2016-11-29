import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class Leitor {
	GeneralTreeOfString arvore = new GeneralTreeOfString();
	private BufferedReader br;

	public ArrayList<String> ler() throws IOException{
		ArrayList<String> livro = new ArrayList<String>();
		FileInputStream stream = new FileInputStream("C:\\Users\\13104443.PORTOALEGRE\\Downloads\\teste.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		br = new BufferedReader(reader);
		String linha = br.readLine();
		while(linha!=null){
			livro.add(linha);
			linha = br.readLine();
		}
		return livro;
		
	}
}

