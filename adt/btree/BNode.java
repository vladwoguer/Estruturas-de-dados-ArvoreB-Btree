/*
 * Problema 8 - Arvore B
 * Grupo: Barbara Cristina Monteiro Gurjao    21111060
 * 		  Jose Diogo Fonsceca				  21011090
 * 		  Vladwoguer Bezerra				  21111939
 */

package adt.btree;

import java.util.Collections;
import java.util.LinkedList;

public class BNode<T extends Comparable<T>> {
	protected LinkedList<T> elements;
	protected LinkedList<BNode<T>> children;
	protected BNode<T> parent;
	protected int maxKeys;
	protected int maxChildren;
	
	/**
	 * Classe que implementa um no de uma Arvore B.
	 * @param order
	 * 				Ordem da arvore (numero maximo de filhos que um no pode ter).
	 */
	public BNode(int order){
		this.maxChildren = order;
		this.maxKeys = order - 1;
		this.elements = new LinkedList<T>();	
		this.children = new LinkedList<BNode<T>>();
	}
	
	/**
	 * Metodo que retorna os elementos em forma de String.
	 */
	@Override
	public String toString() {
		return this.elements.toString();
	}

	/**
	 * Metodo para verificar se um no eh igual a outro.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		if(obj != null){
			if(obj instanceof BNode){
				if(this.size() == ((BNode<T>) obj).size()){
					resp = true;
					int i = 0;
					while(i<this.size() && resp){
						resp = resp && this.getElementAt(i).equals(((BNode<T>) obj).getElementAt(i));
						i++;
					}
				}
			}
		}
		return resp;
	}
	
	/**
	 * Metodo que verifica se a raiz esta vazia.
	 * @return
	 * 		  true se a raiz esta vazia, false caso contrario.
	 */
	public boolean isEmpty(){
		return this.size() == 0;
	}
	
	/**
	 * Verifica o tamanho da arvore.
	 * @return
	 * 		  A quantidade total de elementos que existe na arvore.
	 */
	public int size(){
		return this.elements.size();
	}
	
	/**
	 * Verifica se eh folha.
	 * @return
	 * 		  true se eh folha, false caso contrario.
	 */
	public boolean isLeaf(){
		return this.children.size() == 0;
	}
	
	/**
	 * Verifica se o no ja esta cheio (se o no ja tem o numero maximo de elementos que cada no pode ter,
	 * que eh a ordem - 1.
	 * @return
	 * 		  true se esta cheio, false caso contrario.
	 */
	public boolean isFull(){
		return this.size()== maxKeys;
	}
	
	/**
	 * Adiciona elemento ao no. Depois de adicionar, ordena os elementos que estao dentro do no.
	 * @param element
	 * 				 Elemento a ser adicionado.
	 */
	public void addElement(T element){
		this.elements.add(element);
		Collections.sort(elements);
	}
	
	/**
	 * Remove elemento do no.
	 * @param element
	 * 				 Elemento a ser removido.
	 */
	public void removeElement(T element){
		this.elements.remove(element);
	}
	
	/**
	 * Remove elemento de uma dada posição.
	 * @param position
	 * 				  Posicao do elemento a ser removido.
	 */
	public void removeElement(int position){
		this.elements.remove(position);
	}
	
	/**
	 * Adiciona no filho.
	 * @param position
	 * 				  Posicao onde o no filho sera adicionado.
	 * @param child
	 * 			   No filho a ser adicionado.
	 */
	public void addChild(int position, BNode<T> child){
		this.children.add(position, child);
		child.parent = this;
	}
	
	/**
	 * Remove no filho.
	 * @param child
	 * 			   No filho a ser removido.
	 */
	public void removeChild(BNode<T> child){
		this.children.remove(child);
	}
	
	/**
	 * Verifica a posicao de um no filho.
	 * @param child
	 * 			   No filho.
	 * @return
	 * 		  A posicao do no filho.
	 */
	public int indexOfChild(BNode<T> child){
		return this.children.indexOf(child);
	}
	
	/**
	 * Verifica o elemento que esta na posicao dada.
	 * @param index
	 * 			   Posicao do elemento.
	 * @return
	 * 		  O elemento que esta na dada posicao.
	 */
	public T getElementAt(int index){
		return this.elements.get(index);
	}

	/**
	 * Metodo que retorna todos os elementos.
	 * @return
	 * 		  A lista contendo todos os elementos.
	 */
	public LinkedList<T> getElements() {
		return elements;
	}
	
	/**
	 * Modifica a lista de elementos.
	 * @param elements
	 * 				  A nova lista de elementos.
	 */
	public void setElements(LinkedList<T> elements) {
		this.elements = elements;
	}
	
	/**
	 * Metodo que retorna todos os nos filhos.
	 * @return
	 * 		  Uma lista contendo todos os nos filhos.
	 */
	public LinkedList<BNode<T>> getChildren() {
		return children;
	}
	
	/**
	 * Modifica a lista de nos filhos.
	 * @param children
	 * 				  A nova lista de nos filhos.
	 */
	public void setChildren(LinkedList<BNode<T>> children) {
		this.children = children;
	}
}
