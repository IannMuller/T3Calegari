import java.io.IOException;
import java.util.ArrayList;
public class Build {

	public void Buildar() throws IOException{
		Leitor leitor = new Leitor();
		GeneralTreeOfString arvore =  new GeneralTreeOfString();
		ArrayList<String> livro = leitor.ler();
		Node L = arvore.add(livro.get(0));
		for(int i=1; i<livro.size();i++){
			if(livro.get(i).startsWith("C")){
				Node C = arvore.add(livro.get(i), L);
				int aux= i++;
				while(!livro.get(aux).startsWith("C")){
					if(livro.get(i++).startsWith("S")){
						Node S = arvore.add(livro.get(aux), C);
						aux = aux++;
						while(!livro.get(aux).startsWith("S")){
							if(livro.get(aux).startsWith("SS")){
								Node SS = arvore.add(livro.get(aux), S);
								aux= aux++;
								while(!livro.get(aux).startsWith("SS")){
									arvore.add(livro.get(aux), SS);
									aux = aux++;
								}
							}
							else{
								arvore.add(livro.get(aux), S);
								aux=aux++;
							}
						}
					}
					else{
						arvore.add(livro.get(aux), C);
						aux = aux++;
					}
				}	
			}
		}
		System.out.println(arvore.positionsWidth());
	}
}
