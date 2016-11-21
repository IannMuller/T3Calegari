

import java.util.ArrayList;

public class GeneralTreeOfString {


    // Atributos
    private Node root;
    private int count;

    // Metodos
    public GeneralTreeOfString() {
        root = null;
        count = 0;
    }

    public String getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }
    public Node getRootN(){
    	if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root;
    }

    public void setRoot(String linha) {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        root.element = linha;
    }

    public boolean isRoot(String element) {
        if (root != null) {
            if (root.element.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public void clear() {
        root = null;
        count = 0;
    }

    public String getFather(String element) {
        Node n = searchNodeRef(element, root);
        if (n == null || n.father == null) {
            return null;
        } else {
            return n.father.element;
        }
    }

    public boolean contains(String element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    private Node searchNodeRef(String element, Node target) {
        Node res = null;
        if (target != null) {
            if (element.equals(target.element)) {
                res = target;
            } else {
                Node aux = null;
                int i = 0;
                while ((aux == null) && (i < target.getSubtreesSize())) {
                    aux = searchNodeRef(element, target.getSubtree(i));
                    i++;
                }
                res = aux;
            }
        }
        return res;
    }

    public Node add(String element) {
      return add(element, root);
    }
    public Node add(String element, Node father) {
        Node n = new Node(element);
        Node aux = null;
        if (father == null) {   // Insere na raiz 	
            if (root != null) { //Atualiza o pai da raiz
                n.addSubtree(root);
                root.father = n;
            }
            root = n;   //Atualiza a raiz
            return n;	
        } else {        //Insere no meio da Ã?rvore
            aux = searchNodeRef(father.element, root);
            if (aux != null) {
                aux.addSubtree(n);
               
            }
        }
        count++;
        return n;
    }


   public ArrayList<String> positionsPre() {
        ArrayList<String> lista = new ArrayList<>();
        positionsPreAux(root, lista);
        return lista;
    }

    private void positionsPreAux(Node n, ArrayList<String> lista) {
        if (n != null) {
            lista.add(n.element);
            for (int i = 0; i < n.getSubtreesSize(); i++) {
            	System.out.println("\n" + lista.get(i) );
                positionsPreAux(n.getSubtree(i), lista);
            }
        }
    }
   
    public ArrayList<String> positionsWidth() {
        ArrayList<String> lista = new ArrayList<>();

        Queue<Node> fila = new Queue<>();
        Node atual;

        if (root != null) {
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                atual = fila.dequeue();
                lista.add(atual.element);
                for (int i = 0; i < atual.getSubtreesSize(); i++) {
                    fila.enqueue(atual.getSubtree(i));
                }
            }
        }
        return lista;
    }

}
