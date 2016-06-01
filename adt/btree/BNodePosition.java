/*
 * Problema 8 - Arvore B
 * Grupo: Barbara Cristina Monteiro Gurjao    21111060
 * 		  Jose Diogo Fonsceca				  21011090
 * 		  Vladwoguer Bezerra				  21111939
 */

package adt.btree;

public class BNodePosition<T extends Comparable<T>> {
	protected BNode<T> node;
	protected int position;

	/**
	 * Classe para um no com uma dada posicao.
	 * @param node
	 * 			  No.
	 * @param position
	 * 				  Posicao do no.
	 */
	public BNodePosition(BNode<T> node, int position) {
		this.node = node;
		this.position = position;
	}
	
	public BNodePosition() {
	}
}
