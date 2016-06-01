/*
 * Problema 8 - Arvore B
 * Grupo: Barbara Cristina Monteiro Gurjao    21111060
 * 		  Jose Diogo Fonsceca				  21011090
 * 		  Vladwoguer Bezerra				  21111939
 */

package adt.btree;

import java.util.Collections;
import java.util.LinkedList;

public class BTreeImpl<T extends Comparable<T>> implements
        BTree<T> {

    protected BNode<T> root;
    protected int order;
   
    /**
     * Classe que implementa uma Arvore B.
     * @param order
     * 			   Ordem da arvore.
     */
    public BTreeImpl(int order) {
        this.order = order;
        this.root = new BNode<T>(order);
    }
   
    /**
     * Retorna a raiz da arvore.
     */
    @Override
    public BNode<T> getRoot() {
        return this.root;
    }

    /**
     * Verifica se a arvore esta vazia.
     */
    @Override
    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    /**
     * Retorna a altura da arvore.
     */
    @Override
    public int height() {
        return height(this.root);
    }
    
    /**
     * Verifica a altura a partir de um dado no.
     * @param node
     * 			  No.
     * @return
     * 		  Retorna a altura a partir do no dado.
     */
    private int height(BNode<T> node){
        int resp = -1;
        if(!node.isEmpty()){
            if(node.isLeaf()){
                resp = 0;
            }else{
                resp = 1 + height(node.children.get(0));           
            }
        }
        return resp;
    }
    
 
    @Override
    public BNode<T>[] depthLeftOrder() {
    	  if(isEmpty())
          	return new BNode[0];
    	LinkedList<BNode<T>> array = new LinkedList<BNode<T>>();
        fazArray(array,root);
        BNode<T>[] a = new BNode[array.size()];
        for(int i = 0;i < array.size();i++){
        	a[i] = array.get(i);
        }
        
        return a;
        
    }
 
    /**
     * Adiciona todos os nos em uma lista.
     * @param array
     * 			   Lista onde os nos serao adicionados.
     * @param no
     * 			No a ser adicionado na lista.
     */
    private void fazArray(LinkedList<BNode<T>> array, BNode<T> no){
    	if(no.isLeaf()){
    		array.add(no);
    	}
    	else{
    		array.add(no);
    		for(BNode<T> n : no.children)
    			fazArray(array,n);
    	}
    }
    

    /**
     * Retorna tamanho da arvore
     */
    @Override
    public int size() {
        return tamanho(root);
    }
    
    /**
     * Retorna tamanho de um dado no.
     * @param no
     * 			No.
     * @return
     * 		  Tamanho do no.
     */
    private int tamanho(BNode<T> no){
    	if(no.isLeaf())
    		return no.elements.size();
    	else{
    		int i = no.elements.size();
    		for(BNode<T> a : no.children)
    			i += tamanho(a);
    		
    		return i;
    	}
    		
    }

    /**
     * Procura um elemento.
     */
    @Override
    public BNodePosition<T> search(T element) {
       
        return procura(root,element);
    }
   
    /**
     * Procura um no.
     * @param no
     * 			No a ser procurado.
     * @param key
     * 			 Chave do no a ser procurado.
     * @return
     * 		  O no e sua posicao.
     */
    private BNodePosition<T> procura(BNode<T> no, T key){
       
        int i = 0;
        while(i < no.getElements().size() && (key.compareTo(no.getElements().get(i)) > 0)){
            i++;
        }
       
        if(i < no.size() && key.equals(no.getElements().get(i)))
            return new BNodePosition<T>(no, i);
        if(no.getChildren().size() == 0)
            return new BNodePosition<T>();
       
        return    procura(no.getChildren().get(i), key);
       
    }

    /**
     * Insere elemento na arvore.
     */
    @Override
    public void insert(T element) {
        inserir(root, element);

    }
   
    /**
     * Insere uma chave em um dado no.
     * @param no
     * 			No onde a chave esta sendo inserida.
     * @param key
     * 			 Chave a ser inserida no no.
     */
    private void inserir(BNode<T> no,T key){
        int i = 0;
        while(i < no.getElements().size() && (key.compareTo(no.getElements().get(i)) > 0)){
            i++;
        }
     
        if(no.isLeaf())
             {
                no.getElements().add(key);
                Collections.sort(no.elements);
                if(no.getElements().size() == no.maxChildren){
                    split(no);
                }
                return;
             }
       
       
        inserir(no.getChildren().get(i),key);
    }
    
   /**
    * Split (divisao) do no. Quando o no atinge sua capacidade maxima e tem que ser dividido,
    * separa o no de acordo com a mediana dos elementos. 
    * @param no
    * 		   No que vai ser dividido.
    */
   public void split(BNode<T> no){
    	if(no == root && no.isLeaf()){
    		splitRaizFolha(no);
    		return;
    	}
    	if(no == root && !no.isLeaf()){
    		splitRaizMedio(no);
    		return;
    	}
    	if(no.isLeaf()){
    		splitFolha(no);
    		return;
    	}
    	if(!no.isLeaf()){
    		splitFolhaMedia(no);
    		return;
    	}
    	
    }
    
   /**
    * Split se a raiz for folha.
    * @param no
    * 		   No a ser dividido.
    */
   private void splitRaizFolha(BNode<T> no){
    	if(no != root){
    		return;
    	}
    	
    		int indiceMediana = no.elements.size()/2;
    		BNode<T> esquerda = new BNode<T>(no.maxChildren);
    		for(int i = 0; i < indiceMediana ; i++ ){
    			esquerda.addElement(no.getElementAt(i));
    		}
    		BNode<T> direita = new BNode<T>(no.maxChildren);
    		for(int i = indiceMediana + 1; i < no.getElements().size() ; i++ ){
    			direita.addElement(no.getElementAt(i));
    		}
    		
    		no.getElements().removeAll(esquerda.getElements());
    		no.getElements().removeAll(direita.getElements());
    		
    		if(esquerda.getElements().size() != 0)
    			no.addChild(0, esquerda);
    		if(direita.getElements().size() != 0)
    			no.addChild(1, direita);
    		
    	
    		
    }
   
   /**
    * Split se a raiz for um no medio.
    * @param no
    * 		   No a ser dividido.
    */
   private void splitRaizMedio(BNode<T> no){
	   if(no != root){
   		return;
	   }
	   
		int indiceMediana = no.elements.size()/2;
		BNode<T> esquerda = new BNode<T>(no.maxChildren);
		for(int i = 0; i < indiceMediana ; i++ ){
			esquerda.addElement(no.getElementAt(i));
			if(i < no.getChildren().size())
				esquerda.addChild(i, no.getChildren().get(i));
			
			
			if(indiceMediana - i == 1){
				if(i + 1 < no.getChildren().size())
					esquerda.addChild(i + 1, no.getChildren().get(i + 1));
			}
		}
		BNode<T> direita = new BNode<T>(no.maxChildren);
		int i;
		for(i = indiceMediana + 1; i < no.getElements().size() ; i++ ){
			direita.addElement(no.getElementAt(i));
			if(i < no.getChildren().size())
				direita.addChild(i - (indiceMediana + 1) , no.getChildren().get(i));
			
		}
		
		direita.addChild(i - (indiceMediana + 1) , no.getChildren().get(i));
		
		no.getElements().removeAll(esquerda.getElements());
		no.getElements().removeAll(direita.getElements());
		no.getChildren().removeAll(esquerda.getChildren());
		no.getChildren().removeAll(direita.getChildren());
		
		if(esquerda.getElements().size() != 0)
			no.addChild(0, esquerda);
		if(direita.getElements().size() != 0)
			no.addChild(1, direita);
   }
   
   /**
    * Split se o no for uma folha media.
    * @param no
    * 		   No a ser dividido.
    */
   private void splitFolhaMedia(BNode<T> no){
	   int indiceMediana = no.elements.size()/2;
		
		BNode<T> esquerda = new BNode<T>(no.maxChildren);
		for(int i = 0; i < indiceMediana ; i++ ){
			esquerda.addElement(no.getElementAt(i));
			if(i < no.getChildren().size())
				esquerda.addChild(i, no.getChildren().get(i));
			
			
			if(indiceMediana - i == 1){
				if(i + 1 < no.getChildren().size())
					esquerda.addChild(i + 1, no.getChildren().get(i + 1));
			}
		}
		BNode<T> direita = new BNode<T>(no.maxChildren);
		int i;
		for(i = indiceMediana + 1; i < no.getElements().size() ; i++ ){
			direita.addElement(no.getElementAt(i));
			if(i < no.getChildren().size())
				direita.addChild(i - (indiceMediana + 1), no.getChildren().get(i));
		}
		direita.addChild(i - (indiceMediana + 1), no.getChildren().get(i));
		
		//Eh preciso definir onde vai ser inserido o elemento
		
		int pos = posicao(no.parent,no.getElements().get(indiceMediana));
		
		no.parent.getElements().add(pos,no.getElements().get(indiceMediana));
		
		if(direita.getElements().size() != 0)
			no.parent.addChild(pos, direita);
		
		if(esquerda.getElements().size() != 0)
			no.parent.addChild(pos, esquerda);
		
		
		no.parent.removeChild(no);
		
		if(no.parent.getElements().size() == no.parent.maxChildren){
			split(no.parent);
		}
   }
    
   	/**
    * Split se o no for uma folha.
    * @param no
    * 		   No a ser dividido.
    */
    private void splitFolha(BNode<T> no){ 	
    		int indiceMediana = no.elements.size()/2;
    		BNode<T> esquerda = new BNode<T>(no.maxChildren);
    		for(int i = 0; i < indiceMediana ; i++ ){
    			esquerda.addElement(no.getElementAt(i));
    		}
    		BNode<T> direita = new BNode<T>(no.maxChildren);
    		for(int i = indiceMediana + 1; i < no.getElements().size() ; i++ ){
    			direita.addElement(no.getElementAt(i));
    		}
    		
    		no.getElements().removeAll(esquerda.getElements());
    		no.getElements().removeAll(direita.getElements());
    		
    		//Eh preciso definir onde vai ser inserido o elemento
    		
    		
    		int pos = posicao(no.parent,no.getElements().get(0));
    		
    		no.parent.getElements().add(pos,no.getElements().get(0));
    		
    		
    		if(direita.getElements().size() != 0)
    			no.parent.addChild(pos,direita);
    		if(esquerda.getElements().size() != 0)
    			no.parent.addChild(pos,esquerda); 	
    		
    		no.parent.removeChild(no);

    		if(no.parent.getElements().size() == no.parent.maxChildren){
    			split(no.parent);
    		}
    		
    }
    
    /**
     * Posicao de um valor de um no..
     * @param no
     * 			No.
     * @param valor
     * 			   Valor do no.
     * @return
     * 		  A posicao do valor dentro do no..
     */
    private int posicao(BNode<T> no,T valor){
    	int i = 0;
        while(i < no.size() && (valor.compareTo(no.getElements().get(i)) > 0)){
            i++;
        }
    	return i;
    }
    
    //NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
    @Override
    public BNode<T> maximum(BNode<T> node) {
        //NAO PRECISA IMPLEMENTAR
        return null;
    }
    @Override
    public BNode<T> minimum(BNode<T> node) {
        //NAO PRECISA IMPLEMENTAR
        return null;
    }
    
    /**
     * Remove um elemento.
     */
    @Override
    public void remove(T element) {
        BNodePosition<T> noPos = search(element);
        if(noPos.node != null)
        	remover(noPos);
    }
    
    /**
     * Remover elemento a partir da posicao de um no.
     * @param noPos
     * 			   Posicao do no.
     */
    private void remover(BNodePosition<T> noPos){
    	BNode<T> no = noPos.node;
    	Integer position = noPos.position;
    	if(no != null){
    	if(no.isLeaf()){
    		no.getElements().removeFirstOccurrence(no.getElements().get(position));
    		if(no.getElements().size() < no.maxChildren / 2 && no.parent != null){
    			redistribuiOuConcatena(no);
    		
    		}
    	}
    	else{
    		
    		BNodePosition<T> suc = sucessor(noPos);
    		T element = noPos.node.getElements().get(noPos.position);
    		T suce = suc.node.getElements().get(suc.position);
    		remove(suce);//Remove o sucessor
    		
    		BNodePosition<T> procurado = search(element);
    		procurado.node.getElements().removeFirstOccurrence(element);
    		procurado.node.addElement(suce);//Substitui o elemento pelo sucessor
    			
    	}
    	}
    }
    
    /**
     * Verifica se eh preciso redistribuir os elementos ou concatenar um no.
     * @param no
     * 			No.
     */
    private void redistribuiOuConcatena(BNode<T> no){
    	Integer pos = no.parent.getChildren().indexOf(no);
    	BNode<T> irmaoEsquerdo;
    	BNode<T> irmaoDireito;
    	if(pos == 0)//Nao tem irmao a esquerda
    		irmaoEsquerdo = null;
    	else
    		irmaoEsquerdo = no.parent.getChildren().get(pos - 1);
    	
    	if(pos == no.parent.getChildren().size() - 1)//Nao tem irmao a direita
    		irmaoDireito = null;
    	else
    		irmaoDireito = no.parent.getChildren().get(pos + 1);
    	
    	if((irmaoEsquerdo != null && irmaoEsquerdo.getElements().size() > (irmaoEsquerdo.maxChildren / 2)) || (irmaoDireito != null && irmaoDireito.getElements().size() > (irmaoDireito.maxChildren / 2)))
    	{
    		if(irmaoEsquerdo != null && irmaoEsquerdo.getElements().size() > (irmaoEsquerdo.maxChildren / 2))
    			redistribui(no,irmaoEsquerdo,true);
    		else
    			redistribui(no,irmaoDireito,false);
    	}
    	else{
    		if(irmaoEsquerdo != null)
    			concatena(no,irmaoEsquerdo,true);
    		else
    			if(irmaoDireito != null)
    				concatena(no,irmaoDireito,false);
    	}
    	
    }
    
    /**
     * Redistribui os elementos entre dois nos.
     * @param no
     * 			No
     * @param noIrmao
     * 				 No irmao
     * @param esquerdo
     * 				  true se eh esquerdo, false se eh direito.
     */
    private void redistribui(BNode<T> no, BNode<T> noIrmao, boolean esquerdo){
    	if(esquerdo){
    		int pos = noIrmao.parent.getChildren().indexOf(noIrmao);
    		T ele = noIrmao.getElements().getLast();
    		T ele2 = noIrmao.parent.getElementAt(pos);
    	
    		noIrmao.removeElement(ele);
    		noIrmao.parent.addElement(ele);
    		noIrmao.parent.removeElement(ele2);
    		
    		no.addElement(ele2);
    		
    		if(noIrmao.getChildren().size() != 0){
    			no.getChildren().addFirst(noIrmao.getChildren().getLast());
    			noIrmao.getChildren().removeLast();
    			no.getChildren().getFirst().parent = no;
    			}
    		
    		
    	}else{
    		int pos = noIrmao.parent.getChildren().indexOf(noIrmao);
    		T ele = noIrmao.getElements().getFirst();
    		T ele2 = noIrmao.parent.getElementAt(pos - 1);
    	
    		noIrmao.removeElement(ele);
    		noIrmao.parent.addElement(ele);
    		noIrmao.parent.removeElement(ele2);
    		
    		no.addElement(ele2);	
    		
    		if(noIrmao.getChildren().size() != 0){
    			no.getChildren().addLast(noIrmao.getChildren().getFirst());
    			noIrmao.getChildren().removeFirst();
    			
    			no.getChildren().getLast().parent = no;
    		}
    	}
    	
    }
    
    /**
     * Concatena dois nos.
     * @param no
     * 			No
     * @param noIrmao
     * 				 No irmao
     * @param esquerdo
     * 				  true se eh esquerdo, false se eh direito.
     */
    private void concatena(BNode<T> no, BNode<T> noIrmao, boolean esquerdo){
    	if(esquerdo){
    		int pos = noIrmao.parent.getChildren().indexOf(noIrmao);
    		T ele2 = noIrmao.parent.getElementAt(pos);
    		noIrmao.addElement(ele2);		
    		noIrmao.parent.removeElement(ele2);
    		noIrmao.getElements().addAll(no.getElements());
    		noIrmao.getChildren().addAll(no.getChildren());
    		for(BNode<T> a : no.getChildren())
    			a.parent = noIrmao;
    		noIrmao.parent.removeChild(no);
    		
    		
    		
    		if(noIrmao.parent == root && noIrmao.parent.getElements().size() == 0){
    			root = noIrmao;
    			root.parent = null;
    		}
    		
    		if(noIrmao.parent != null && noIrmao.parent != root && noIrmao.parent.getElements().size() < noIrmao.parent.maxChildren / 2){
    			redistribuiOuConcatena(noIrmao.parent);
    		}
    		
 
    	}else{
    		int pos = noIrmao.parent.getChildren().indexOf(noIrmao);
    		T ele2 = noIrmao.parent.getElementAt(pos - 1);
    		noIrmao.addElement(ele2);
    		noIrmao.parent.removeElement(ele2);
    		noIrmao.getElements().addAll(0,no.getElements());
    		noIrmao.getChildren().addAll(0,no.getChildren());

    		for(BNode<T> a : no.getChildren())
    			a.parent = noIrmao;
    		noIrmao.parent.removeChild(no);
    		
    		if(noIrmao.parent == root && noIrmao.parent.getElements().size() == 0){
    			root = noIrmao;
    			root.parent = null;
    		}
    		
    		if(noIrmao.parent != null && noIrmao.parent != root && noIrmao.parent.getElements().size() < noIrmao.parent.maxChildren / 2){
    			redistribuiOuConcatena(noIrmao.parent);
    		}
    	}
    }
    
    /**
     * Sucessor de um no.    
     * @param pos
     * 			 Posicao de um no.
     * @return
     * 		  O sucessor do no que esta na posicao dada.
     */
    private BNodePosition<T> sucessor(BNodePosition<T> pos){
    	if(pos.node.isLeaf())
    		return pos;
    	
    	else
    		return varredura(new BNodePosition<T>(pos.node.getChildren().get(pos.position + 1),0));
    }

    private BNodePosition<T> varredura(BNodePosition<T> pos){
    	
    	if(pos.node.isLeaf())
    		return pos;
    	 			
    	return varredura(new BNodePosition<T>(pos.node.getChildren().get(pos.position),0));
    }
    
    /**
     * Troca o no com o sucessor.
     * @param no
     * 			No.
     * @param suc
     * 			Sucessor.
     */
    private void troca(BNodePosition<T> no,BNodePosition<T> suc){
    	BNode<T> no1 = no.node;
    	int position1 = no.position;
    	BNode<T> no2 = suc.node;
    	int position2 = suc.position;
    	
    	T element1 = no1.getElements().get(position1);
    	T element2 = no2.getElements().get(position2);
    	no1.getElements().removeFirstOccurrence(element1);
    	no2.getElements().removeFirstOccurrence(element2);
    	no1.getElements().add(position1,element2);
    	
    }
}
