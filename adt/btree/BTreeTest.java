/*
 * Problema 8 - Arvore B
 * Grupo: Barbara Cristina Monteiro Gurjao    21111060
 * 		  Jose Diogo Fonsceca				  21011090
 * 		  Vladwoguer Bezerra				  21111939
 */

package adt.btree;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

//(*) -> Observacao

public class BTreeTest {
	
	BTreeImpl<Integer>  treeOrd3, treeOrd5;
	
	//Arvores de ordem 3 e 5
	@Before
	public void setUp(){
		treeOrd3 = new BTreeImpl<Integer>(3);
		treeOrd5 = new BTreeImpl<Integer>(5);
		
	}

	//Testa o algoritimo de insercao e o split
	@Test
	public void testaInsercao() {
		for(int i = 0; i < 300 ; i++){
			assertTrue(new BNodePosition<Integer>().node == treeOrd3.search(i).node);		
			assertTrue(new BNodePosition<Integer>().position == treeOrd3.search(i).position);		
			assertEquals(-1, treeOrd3.height());
		}
		
		
		treeOrd3.insert(100);
		
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(1, treeOrd3.size());
		assertEquals(0, treeOrd3.height());
		
		treeOrd3.insert(200);
		
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(1, treeOrd3.search(200).position);
		assertEquals(2, treeOrd3.size());
		assertEquals(0, treeOrd3.height());

		treeOrd3.insert(300);

		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(300).position);
		
		assertEquals(3, treeOrd3.size());
		assertEquals(1, treeOrd3.height());

		treeOrd3.insert(50);

		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(1, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(300).position);
		
		assertEquals(4, treeOrd3.size());
		assertEquals(1, treeOrd3.height());

		treeOrd3.insert(150);

		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(1, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(300).position);
		
		assertEquals(5, treeOrd3.size());
		assertEquals(1, treeOrd3.height());

		treeOrd3.insert(250);

		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(1, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(250).position);
		assertEquals(1, treeOrd3.search(300).position);
		
		assertEquals(6, treeOrd3.size());
		assertEquals(1, treeOrd3.height());


		treeOrd3.insert(350);

		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(350).position);
		
		assertEquals(7, treeOrd3.size());
		assertEquals(2, treeOrd3.height());


		treeOrd3.insert(25);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(1, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(350).position);
		
		assertEquals(8, treeOrd3.size());
		assertEquals(2, treeOrd3.height());


		treeOrd3.insert(125);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(1, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(1, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(350).position);
		
		assertEquals(9, treeOrd3.size());
		assertEquals(2, treeOrd3.height());
		
		treeOrd3.insert(225);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(1, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(1, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(225).position);
		assertEquals(1, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(350).position);
		
		assertEquals(10, treeOrd3.size());
		assertEquals(2, treeOrd3.height());
		
		treeOrd3.insert(325);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(1, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(1, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(225).position);
		assertEquals(1, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(325).position);
		assertEquals(1, treeOrd3.search(350).position);
		
		assertEquals(11, treeOrd3.size());
		assertEquals(2, treeOrd3.height());
		
		treeOrd3.insert(75);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(75).position);
		assertEquals(1, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(1, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(225).position);
		assertEquals(1, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(325).position);
		assertEquals(1, treeOrd3.search(350).position);
		
		assertEquals(12, treeOrd3.size());
		assertEquals(2, treeOrd3.height());
		
		treeOrd3.insert(175);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(75).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(175).position);
		assertEquals(1, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(225).position);
		assertEquals(1, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(325).position);
		assertEquals(1, treeOrd3.search(350).position);
		
		assertEquals(13, treeOrd3.size());
		assertEquals(2, treeOrd3.height());
		
		treeOrd3.insert(275);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(75).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(175).position);
		assertEquals(1, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(225).position);
		assertEquals(0, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(275).position);
		assertEquals(1, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(325).position);
		assertEquals(1, treeOrd3.search(350).position);
		
		assertEquals(14, treeOrd3.size());
		assertEquals(2, treeOrd3.height());
		
		treeOrd3.insert(375);

		assertEquals(0, treeOrd3.search(25).position);
		assertEquals(0, treeOrd3.search(50).position);
		assertEquals(0, treeOrd3.search(75).position);
		assertEquals(0, treeOrd3.search(100).position);
		assertEquals(0, treeOrd3.search(125).position);
		assertEquals(0, treeOrd3.search(150).position);
		assertEquals(0, treeOrd3.search(175).position);
		assertEquals(0, treeOrd3.search(200).position);
		assertEquals(0, treeOrd3.search(225).position);
		assertEquals(0, treeOrd3.search(250).position);
		assertEquals(0, treeOrd3.search(275).position);
		assertEquals(0, treeOrd3.search(300).position);
		assertEquals(0, treeOrd3.search(325).position);
		assertEquals(0, treeOrd3.search(350).position);
		assertEquals(0, treeOrd3.search(375).position);
		
		assertEquals(15, treeOrd3.size());
		assertEquals(3, treeOrd3.height());
		
		
		for(int i = 0; i < 300 ; i++){
			assertTrue(new BNodePosition<Integer>().node == treeOrd5.search(i).node);
			assertTrue(new BNodePosition<Integer>().position == treeOrd5.search(i).position);
			assertTrue(Arrays.equals(new BNode[0],treeOrd5.depthLeftOrder()));
			assertEquals(-1, treeOrd5.height());
		}
		
		
		treeOrd5.insert(100);
		
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
		
		treeOrd5.insert(200);
		
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(200).position);
		
		assertEquals(2, treeOrd5.size());
		assertEquals(0, treeOrd5.height());

		treeOrd5.insert(300);

		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(200).position);
		assertEquals(2, treeOrd5.search(300).position);
		
		assertEquals(3, treeOrd5.size());
		assertEquals(0, treeOrd5.height());

		treeOrd5.insert(50);

		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(100).position);
		assertEquals(2, treeOrd5.search(200).position);
		assertEquals(3, treeOrd5.search(300).position);
		
		assertEquals(4, treeOrd5.size());
		assertEquals(0, treeOrd5.height());

		treeOrd5.insert(150);

		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(100).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(300).position);
		
		assertEquals(5, treeOrd5.size());
		assertEquals(1, treeOrd5.height());

		treeOrd5.insert(250);

		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(100).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(250).position);
		assertEquals(2, treeOrd5.search(300).position);
		
		assertEquals(6, treeOrd5.size());
		assertEquals(1, treeOrd5.height());


		treeOrd5.insert(350);

		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(100).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(250).position);
		assertEquals(2, treeOrd5.search(300).position);
		assertEquals(3, treeOrd5.search(350).position);
		
		assertEquals(7, treeOrd5.size());
		assertEquals(1, treeOrd5.height());


		treeOrd5.insert(25);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(100).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(250).position);
		assertEquals(2, treeOrd5.search(300).position);
		assertEquals(3, treeOrd5.search(350).position);
		
		assertEquals(8, treeOrd5.size());
		assertEquals(1, treeOrd5.height());


		treeOrd5.insert(125);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(100).position);
		assertEquals(3, treeOrd5.search(125).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(250).position);
		assertEquals(2, treeOrd5.search(300).position);
		assertEquals(3, treeOrd5.search(350).position);
		
		assertEquals(9, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(225);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(100).position);
		assertEquals(3, treeOrd5.search(125).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(225).position);
		assertEquals(1, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(350).position);
		
		assertEquals(10, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(325);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(100).position);
		assertEquals(3, treeOrd5.search(125).position);
		assertEquals(0, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(225).position);
		assertEquals(1, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(325).position);
		assertEquals(2, treeOrd5.search(350).position);
	
		
		assertEquals(11, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(75);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(1, treeOrd5.search(225).position);
		assertEquals(2, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(325).position);
		assertEquals(2, treeOrd5.search(350).position);
		
		assertEquals(12, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(175);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(200).position);
		assertEquals(2, treeOrd5.search(225).position);
		assertEquals(2, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(325).position);
		assertEquals(2, treeOrd5.search(350).position);
		
		assertEquals(13, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(275);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(200).position);
		assertEquals(2, treeOrd5.search(225).position);
		assertEquals(2, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(275).position);
		assertEquals(1, treeOrd5.search(300).position);
		assertEquals(2, treeOrd5.search(325).position);
		assertEquals(3, treeOrd5.search(350).position);
		
		assertEquals(14, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(375);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(200).position);
		assertEquals(2, treeOrd5.search(225).position);
		assertEquals(2, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(275).position);
		assertEquals(1, treeOrd5.search(300).position);
		assertEquals(3, treeOrd5.search(325).position);
		assertEquals(0, treeOrd5.search(350).position);
		assertEquals(1, treeOrd5.search(375).position);
		
		assertEquals(15, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(205);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(200).position);
		assertEquals(2, treeOrd5.search(205).position);
		assertEquals(3, treeOrd5.search(225).position);
		assertEquals(2, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(275).position);
		assertEquals(1, treeOrd5.search(300).position);
		assertEquals(3, treeOrd5.search(325).position);
		assertEquals(0, treeOrd5.search(350).position);
		assertEquals(1, treeOrd5.search(375).position);
		
		assertEquals(16, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		

		treeOrd5.insert(195);

		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(195).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(0, treeOrd5.search(205).position);
		assertEquals(1, treeOrd5.search(225).position);
		assertEquals(0, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(275).position);
		assertEquals(1, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(325).position);
		assertEquals(0, treeOrd5.search(350).position);
		assertEquals(1, treeOrd5.search(375).position);
		
		assertEquals(17, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
		treeOrd5.insert(376);
		
		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(195).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(0, treeOrd5.search(205).position);
		assertEquals(1, treeOrd5.search(225).position);
		assertEquals(0, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(275).position);
		assertEquals(1, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(325).position);
		assertEquals(0, treeOrd5.search(350).position);
		assertEquals(1, treeOrd5.search(375).position);
		assertEquals(2, treeOrd5.search(376).position);
		
		assertEquals(18, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
		
		treeOrd5.insert(377);
		
		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(195).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(0, treeOrd5.search(205).position);
		assertEquals(1, treeOrd5.search(225).position);
		assertEquals(0, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(275).position);
		assertEquals(1, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(325).position);
		assertEquals(0, treeOrd5.search(350).position);
		assertEquals(1, treeOrd5.search(375).position);
		assertEquals(2, treeOrd5.search(376).position);
		assertEquals(3, treeOrd5.search(377).position);
		
		
		assertEquals(19, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
		//Testa remocaoo em folha
		
		treeOrd5.remove(376);
		
		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(195).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(0, treeOrd5.search(205).position);
		assertEquals(1, treeOrd5.search(225).position);
		assertEquals(0, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(275).position);
		assertEquals(1, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(325).position);
		assertEquals(0, treeOrd5.search(350).position);
		assertEquals(1, treeOrd5.search(375).position);
		assertEquals(2, treeOrd5.search(377).position);
	
		
		assertEquals(18, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
		treeOrd5.remove(377);
		
		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(100).position);
		assertEquals(1, treeOrd5.search(125).position);
		assertEquals(1, treeOrd5.search(150).position);
		assertEquals(0, treeOrd5.search(175).position);
		assertEquals(1, treeOrd5.search(195).position);
		assertEquals(0, treeOrd5.search(200).position);
		assertEquals(0, treeOrd5.search(205).position);
		assertEquals(1, treeOrd5.search(225).position);
		assertEquals(0, treeOrd5.search(250).position);
		assertEquals(0, treeOrd5.search(275).position);
		assertEquals(1, treeOrd5.search(300).position);
		assertEquals(1, treeOrd5.search(325).position);
		assertEquals(0, treeOrd5.search(350).position);
		assertEquals(1, treeOrd5.search(375).position);
		
		
		assertEquals(17, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
	}
	
	//Testa o caso de redistribuicao*
	@Test
	public void testRedistribui01(){
		
		treeOrd5.insert(60);
		treeOrd5.insert(50);
		treeOrd5.insert(70);
		treeOrd5.insert(40);
		treeOrd5.insert(80);
		treeOrd5.insert(82);
		
		treeOrd5.remove(40);
				
		assertEquals(0, treeOrd5.search(70).position);
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(60).position);
		assertEquals(0, treeOrd5.search(80).position);
		assertEquals(1, treeOrd5.search(82).position);
		
		assertEquals(5, treeOrd5.size());
		assertEquals(1, treeOrd5.height());	
		
	}
	
	//Testa o caso de redistribuicao*
	@Test
	public void testRedistribui02(){
		
		treeOrd5.insert(60);
		treeOrd5.insert(50);
		treeOrd5.insert(70);
		treeOrd5.insert(40);
		treeOrd5.insert(80);
		treeOrd5.insert(82);
		
		treeOrd5.remove(50);
				
		assertEquals(0, treeOrd5.search(70).position);
		assertEquals(0, treeOrd5.search(40).position);
		assertEquals(1, treeOrd5.search(60).position);
		assertEquals(0, treeOrd5.search(80).position);
		assertEquals(1, treeOrd5.search(82).position);
		
		
		
		assertEquals(5, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
	}
	
	//Testa o caso de redistribuicao*
	@Test
	public void testRedistribui03(){
		treeOrd5.insert(60);
		treeOrd5.insert(50);
		treeOrd5.insert(70);
		treeOrd5.insert(40);
		treeOrd5.insert(80);
		treeOrd5.insert(30);
		
		treeOrd5.remove(70);
		
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(60).position);
		assertEquals(1, treeOrd5.search(80).position);
		
		assertEquals(5, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		
	}
	//Testa o caso de redistribuicao*
	@Test
	public void testRedistribui04(){
		
		treeOrd5.insert(60);
		treeOrd5.insert(50);
		treeOrd5.insert(70);
		treeOrd5.insert(40);
		treeOrd5.insert(80);
		treeOrd5.insert(30);
		
		treeOrd5.remove(80);
		
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(60).position);
		assertEquals(1, treeOrd5.search(70).position);
		
		assertEquals(5, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		
	}
	
	//Testa o caso de redistribuicao com novas isercoes e remocoes em folha*
	@Test
	public void testRedistribui05(){
		treeOrd5.insert(60);
		treeOrd5.insert(50);
		treeOrd5.insert(70);
		treeOrd5.insert(40);
		treeOrd5.insert(80);
		treeOrd5.insert(82);
		treeOrd5.insert(75);
		treeOrd5.insert(77);
		treeOrd5.insert(79);
		
		treeOrd5.remove(75);
		
		assertEquals(0, treeOrd5.search(60).position);
		assertEquals(1, treeOrd5.search(79).position);
		assertEquals(0, treeOrd5.search(40).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(70).position);
		assertEquals(1, treeOrd5.search(77).position);
		assertEquals(0, treeOrd5.search(80).position);
		assertEquals(1, treeOrd5.search(82).position);
		
		assertEquals(8, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(75);
		treeOrd5.remove(40);
		
		assertEquals(0, treeOrd5.search(70).position);
		assertEquals(1, treeOrd5.search(79).position);
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(60).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(1, treeOrd5.search(77).position);
		assertEquals(0, treeOrd5.search(80).position);
		assertEquals(1, treeOrd5.search(82).position);
		
		assertEquals(8, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(76);
		treeOrd5.insert(71);
		treeOrd5.insert(72);
		treeOrd5.insert(78);
		treeOrd5.remove(71);
		
		assertEquals(0, treeOrd5.search(70).position);
		assertEquals(1, treeOrd5.search(76).position);
		assertEquals(2, treeOrd5.search(79).position);
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(60).position);
		assertEquals(0, treeOrd5.search(72).position);
		assertEquals(1, treeOrd5.search(75).position);
		assertEquals(0, treeOrd5.search(77).position);
		assertEquals(1, treeOrd5.search(78).position);
		assertEquals(0, treeOrd5.search(80).position);
		assertEquals(1, treeOrd5.search(82).position);
		
		assertEquals(11, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(73);
		
		treeOrd5.remove(60);
		
		
	}
	//Testa concatenacao em que o no se transforma em raiz*
	@Test
	public void testConcatenaRaiz01(){
		treeOrd5.insert(20);
		treeOrd5.insert(30);
		treeOrd5.insert(35);
		treeOrd5.insert(40);
		treeOrd5.insert(50);	
		
		treeOrd5.remove(30);
		
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(35).position);
		assertEquals(2, treeOrd5.search(40).position);
		assertEquals(3, treeOrd5.search(50).position);
		
		
		assertEquals(4, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
	}
	
	//Testa concatenacao em que o no se transforma em raiz*
	@Test
	public void testConcatenaRaiz02(){
		treeOrd5.insert(20);
		treeOrd5.insert(30);
		treeOrd5.insert(35);
		treeOrd5.insert(40);
		treeOrd5.insert(50);	
		
		treeOrd5.remove(40);
		
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(2, treeOrd5.search(35).position);
		assertEquals(3, treeOrd5.search(50).position);
		
		
		assertEquals(4, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
	}
	
	//Testa concatenacao em que o no se transforma em raiz*
	@Test
	public void testConcatenaRaiz03(){
		treeOrd5.insert(20);
		treeOrd5.insert(30);
		treeOrd5.insert(35);
		treeOrd5.insert(40);
		treeOrd5.insert(50);	
		
		treeOrd5.remove(20);
		
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(35).position);
		assertEquals(2, treeOrd5.search(40).position);
		assertEquals(3, treeOrd5.search(50).position);
		
		
		assertEquals(4, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
	}
	
	//Testa concatenacao em que o no se transforma em raiz , insercoes e remocao total de elementos*
	@Test
	public void testConcatenaRaiz04(){
		treeOrd5.insert(20);
		treeOrd5.insert(30);
		treeOrd5.insert(35);
		treeOrd5.insert(40);
		treeOrd5.insert(50);	
		
		treeOrd5.remove(50);
		
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(2, treeOrd5.search(35).position);
		assertEquals(3, treeOrd5.search(40).position);
			
		assertEquals(4, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
		
		treeOrd5.remove(40);
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(2, treeOrd5.search(35).position);
		assertEquals(3, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
		
		treeOrd5.remove(20);
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(35).position);
		assertEquals(2, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
		
		treeOrd5.remove(30);
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
		
		treeOrd5.remove(35);
		assertEquals(0, treeOrd5.size());
		assertEquals(-1, treeOrd5.height());
				
	}
	
	//Testa concatenacao em no Medio insercoes e remocoes variadas*
	@Test
	public void testConcatena01(){
		treeOrd5.insert(50);
		treeOrd5.insert(40);
		treeOrd5.insert(60);
		treeOrd5.insert(30);
		treeOrd5.insert(70);
		treeOrd5.insert(87);
		treeOrd5.insert(89);
		treeOrd5.insert(92);
		
		treeOrd5.remove(40);
		
		assertEquals(0, treeOrd5.search(87).position);
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(60).position);
		assertEquals(3, treeOrd5.search(70).position);
		assertEquals(0, treeOrd5.search(89).position);
		assertEquals(1, treeOrd5.search(92).position);
		
		assertEquals(7, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(92);
		
		assertEquals(0, treeOrd5.search(70).position);
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(60).position);
		assertEquals(0, treeOrd5.search(87).position);
		assertEquals(1, treeOrd5.search(89).position);
		
		assertEquals(6, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(60);
		
		assertEquals(0, treeOrd5.search(70).position);
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(87).position);
		assertEquals(1, treeOrd5.search(89).position);
		
		assertEquals(5, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(89);
		
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(70).position);
		assertEquals(3, treeOrd5.search(87).position);
		
		assertEquals(4, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
		
		treeOrd5.insert(89);
		
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(70).position);
		assertEquals(0, treeOrd5.search(87).position);
		assertEquals(1, treeOrd5.search(89).position);
		
		assertEquals(5, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(30);
		
	
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(70).position);
		assertEquals(2, treeOrd5.search(87).position);
		assertEquals(3, treeOrd5.search(89).position);
		
		
		assertEquals(4, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
		
		treeOrd5.remove(300);
		
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(70).position);
		assertEquals(2, treeOrd5.search(87).position);
		assertEquals(3, treeOrd5.search(89).position);
		
		
		assertEquals(4, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
		
		treeOrd5.insert(30);
		treeOrd5.insert(35);
		treeOrd5.insert(37);
		treeOrd5.insert(40);
		treeOrd5.insert(45);
		treeOrd5.insert(47);
		treeOrd5.insert(48);
		
		treeOrd5.remove(45);
		
		assertEquals(0, treeOrd5.search(47).position);
		assertEquals(1, treeOrd5.search(70).position);
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(35).position);
		assertEquals(2, treeOrd5.search(37).position);
		assertEquals(3, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(48).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(0, treeOrd5.search(87).position);
		assertEquals(1, treeOrd5.search(89).position);
		
		assertEquals(10, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(39);
		
		treeOrd5.remove(50);
		
		assertEquals(0, treeOrd5.search(37).position);
		assertEquals(1, treeOrd5.search(70).position);
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(35).position);
		assertEquals(0, treeOrd5.search(39).position);
		assertEquals(1, treeOrd5.search(40).position);
		assertEquals(2, treeOrd5.search(47).position);
		assertEquals(3, treeOrd5.search(48).position);
		assertEquals(0, treeOrd5.search(87).position);
		assertEquals(1, treeOrd5.search(89).position);
		
		assertEquals(10, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(50);
		
		treeOrd5.remove(30);
		treeOrd5.remove(89);
		
		assertEquals(0, treeOrd5.search(47).position);
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(37).position);
		assertEquals(2, treeOrd5.search(39).position);
		assertEquals(3, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(48).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(70).position);
		assertEquals(3, treeOrd5.search(87).position);
		
		assertEquals(9, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(37);
		
		assertEquals(0, treeOrd5.search(47).position);
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(39).position);
		assertEquals(2, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(48).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(70).position);
		assertEquals(3, treeOrd5.search(87).position);
		
		assertEquals(8, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
						
	}
	
	//Testa concatenacao em no Medio insercoes e remocoes variadas*
	@Test
	public void testConcatena02(){
		treeOrd5.insert(10);
		treeOrd5.insert(15);
		treeOrd5.insert(20);
		treeOrd5.insert(25);
		treeOrd5.insert(30);
		treeOrd5.insert(35);
		treeOrd5.insert(40);
		treeOrd5.insert(45);
		treeOrd5.insert(50);
		treeOrd5.insert(55);
		treeOrd5.insert(60);
		treeOrd5.insert(65);
		treeOrd5.insert(70);
		treeOrd5.insert(75);
		
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(35).position);
		assertEquals(2, treeOrd5.search(50).position);
		assertEquals(3, treeOrd5.search(65).position);
		assertEquals(0, treeOrd5.search(10).position);
		assertEquals(1, treeOrd5.search(15).position);
		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(0, treeOrd5.search(40).position);
		assertEquals(1, treeOrd5.search(45).position);
		assertEquals(0, treeOrd5.search(55).position);
		assertEquals(1, treeOrd5.search(60).position);
		assertEquals(0, treeOrd5.search(70).position);
		assertEquals(1, treeOrd5.search(75).position);
		
		assertEquals(14, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(55);
		
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(35).position);		
		assertEquals(2, treeOrd5.search(65).position);
		
				
		assertEquals(0, treeOrd5.search(10).position);
		assertEquals(1, treeOrd5.search(15).position);
		
		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(30).position);
		
		assertEquals(0, treeOrd5.search(40).position);
		assertEquals(1, treeOrd5.search(45).position);
		assertEquals(2, treeOrd5.search(50).position);
		assertEquals(3, treeOrd5.search(60).position);
		assertEquals(0, treeOrd5.search(70).position);
		assertEquals(1, treeOrd5.search(75).position);
		
		assertEquals(13, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(55);
		
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(35).position);
		assertEquals(2, treeOrd5.search(50).position);
		assertEquals(3, treeOrd5.search(65).position);
		assertEquals(0, treeOrd5.search(10).position);
		assertEquals(1, treeOrd5.search(15).position);
		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(0, treeOrd5.search(40).position);
		assertEquals(1, treeOrd5.search(45).position);
		assertEquals(0, treeOrd5.search(55).position);
		assertEquals(1, treeOrd5.search(60).position);
		assertEquals(0, treeOrd5.search(70).position);
		assertEquals(1, treeOrd5.search(75).position);
		
		assertEquals(14, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(40);
		
		assertEquals(0, treeOrd5.search(20).position);		
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(65).position);
		
		
		assertEquals(0, treeOrd5.search(10).position);
		assertEquals(1, treeOrd5.search(15).position);
		
		assertEquals(0, treeOrd5.search(25).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(2, treeOrd5.search(35).position);
		assertEquals(3, treeOrd5.search(45).position);
		
		assertEquals(0, treeOrd5.search(55).position);
		assertEquals(1, treeOrd5.search(60).position);
		assertEquals(0, treeOrd5.search(70).position);
		assertEquals(1, treeOrd5.search(75).position);
		
		assertEquals(13, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		
	}
	
	//Testa concatenacao em no Medio insercoes e remocoes variadas*
	@Test
	public void testConcatena03(){
		for(int i = 1; i <= 17 ; i ++){
			treeOrd5.insert(i);
		}
		
		assertEquals(0, treeOrd5.search(9).position);
		assertEquals(0, treeOrd5.search(3).position);
		assertEquals(1, treeOrd5.search(6).position);
		assertEquals(0, treeOrd5.search(1).position);
		assertEquals(1, treeOrd5.search(2).position);
		assertEquals(0, treeOrd5.search(4).position);
		assertEquals(1, treeOrd5.search(5).position);
		assertEquals(0, treeOrd5.search(7).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(0, treeOrd5.search(12).position);
		assertEquals(1, treeOrd5.search(15).position);
		assertEquals(0, treeOrd5.search(10).position);
		assertEquals(1, treeOrd5.search(11).position);
		assertEquals(0, treeOrd5.search(13).position);
		assertEquals(1, treeOrd5.search(14).position);
		assertEquals(0, treeOrd5.search(16).position);
		assertEquals(1, treeOrd5.search(17).position);
		
		assertEquals(17, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
		treeOrd5.remove(17);
		
	
		assertEquals(0, treeOrd5.search(3).position);
		assertEquals(1, treeOrd5.search(6).position);
		assertEquals(2, treeOrd5.search(9).position);
		assertEquals(3, treeOrd5.search(12).position);
		assertEquals(0, treeOrd5.search(1).position);
		assertEquals(1, treeOrd5.search(2).position);
		assertEquals(0, treeOrd5.search(4).position);
		assertEquals(1, treeOrd5.search(5).position);
		assertEquals(0, treeOrd5.search(7).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(0, treeOrd5.search(10).position);
		assertEquals(1, treeOrd5.search(11).position);
		assertEquals(0, treeOrd5.search(13).position);
		assertEquals(1, treeOrd5.search(14).position);
		assertEquals(2, treeOrd5.search(15).position);
		assertEquals(3, treeOrd5.search(16).position);
		
		assertEquals(16, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(17);
		
		assertEquals(0, treeOrd5.search(9).position);
		assertEquals(0, treeOrd5.search(3).position);
		assertEquals(1, treeOrd5.search(6).position);
		assertEquals(0, treeOrd5.search(1).position);
		assertEquals(1, treeOrd5.search(2).position);
		assertEquals(0, treeOrd5.search(4).position);
		assertEquals(1, treeOrd5.search(5).position);
		assertEquals(0, treeOrd5.search(7).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(0, treeOrd5.search(12).position);
		assertEquals(1, treeOrd5.search(15).position);
		assertEquals(0, treeOrd5.search(10).position);
		assertEquals(1, treeOrd5.search(11).position);
		assertEquals(0, treeOrd5.search(13).position);
		assertEquals(1, treeOrd5.search(14).position);
		assertEquals(0, treeOrd5.search(16).position);
		assertEquals(1, treeOrd5.search(17).position);
		
		assertEquals(17, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
		treeOrd5.remove(4);
		
		assertEquals(0, treeOrd5.search(6).position);
		assertEquals(1, treeOrd5.search(9).position);
		assertEquals(2, treeOrd5.search(12).position);
		assertEquals(3, treeOrd5.search(15).position);
		assertEquals(0, treeOrd5.search(1).position);
		assertEquals(1, treeOrd5.search(2).position);
		assertEquals(2, treeOrd5.search(3).position);
		assertEquals(3, treeOrd5.search(5).position);
		assertEquals(0, treeOrd5.search(7).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(0, treeOrd5.search(10).position);
		assertEquals(1, treeOrd5.search(11).position);
		assertEquals(0, treeOrd5.search(13).position);
		assertEquals(1, treeOrd5.search(14).position);
		assertEquals(0, treeOrd5.search(16).position);
		assertEquals(1, treeOrd5.search(17).position);
		
		assertEquals(16, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
				
	}
	
	//Testa concatenacao em no Medio insercoes e remocoes variadas*
	@Test
	public void testConcatena04(){
		for(int i = 10; i < 100; i += 10)
			treeOrd5.insert(i);
		for(int i = 15; i < 100; i+= 10)
			treeOrd5.insert(i);
		treeOrd5.insert(5);
		treeOrd5.insert(99);
		
		assertEquals(0, treeOrd5.search(45).position);
		assertEquals(0, treeOrd5.search(15).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(0, treeOrd5.search(60).position);
		assertEquals(1, treeOrd5.search(75).position);
		assertEquals(2, treeOrd5.search(90).position);
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(10).position);
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(25).position);
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(55).position);
		assertEquals(0, treeOrd5.search(65).position);
		assertEquals(1, treeOrd5.search(70).position);
		assertEquals(0, treeOrd5.search(80).position);
		assertEquals(1, treeOrd5.search(85).position);
		assertEquals(0, treeOrd5.search(95).position);
		assertEquals(1, treeOrd5.search(99).position);
		
		assertEquals(20, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
		treeOrd5.remove(70);
		
		assertEquals(0, treeOrd5.search(45).position);
		assertEquals(0, treeOrd5.search(15).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(1, treeOrd5.search(90).position);
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(10).position);
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(25).position);
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(55).position);
		assertEquals(2, treeOrd5.search(60).position);
		assertEquals(3, treeOrd5.search(65).position);
		assertEquals(0, treeOrd5.search(80).position);
		assertEquals(1, treeOrd5.search(85).position);
		assertEquals(0, treeOrd5.search(95).position);
		assertEquals(1, treeOrd5.search(99).position);
		
		
		assertEquals(19, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
		treeOrd5.remove(10);
		
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(45).position);
		assertEquals(2, treeOrd5.search(75).position);
		assertEquals(3, treeOrd5.search(90).position);
		
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(15).position);
		assertEquals(2, treeOrd5.search(20).position);
		assertEquals(3, treeOrd5.search(25).position);
		
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(55).position);
		assertEquals(2, treeOrd5.search(60).position);
		assertEquals(3, treeOrd5.search(65).position);
		
		assertEquals(0, treeOrd5.search(80).position);
		assertEquals(1, treeOrd5.search(85).position);
		
		assertEquals(0, treeOrd5.search(95).position);
		assertEquals(1, treeOrd5.search(99).position);
		
		assertEquals(18, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(7);
		
		assertEquals(0, treeOrd5.search(45).position);
		assertEquals(0, treeOrd5.search(15).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(1, treeOrd5.search(90).position);
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(7).position);
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(25).position);
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(55).position);
		assertEquals(2, treeOrd5.search(60).position);
		assertEquals(3, treeOrd5.search(65).position);
		assertEquals(0, treeOrd5.search(80).position);
		assertEquals(1, treeOrd5.search(85).position);
		assertEquals(0, treeOrd5.search(95).position);
		assertEquals(1, treeOrd5.search(99).position);
		
		assertEquals(19, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
		treeOrd5.remove(65);
		
		assertEquals(0, treeOrd5.search(45).position);
		assertEquals(0, treeOrd5.search(15).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(1, treeOrd5.search(90).position);
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(7).position);
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(25).position);
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(55).position);
		assertEquals(2, treeOrd5.search(60).position);
		assertEquals(0, treeOrd5.search(80).position);
		assertEquals(1, treeOrd5.search(85).position);
		assertEquals(0, treeOrd5.search(95).position);
		assertEquals(1, treeOrd5.search(99).position);
		
		assertEquals(18, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
		treeOrd5.remove(85);
		
		assertEquals(0, treeOrd5.search(45).position);
		assertEquals(0, treeOrd5.search(15).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(0, treeOrd5.search(60).position);
		assertEquals(1, treeOrd5.search(90).position);
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(7).position);
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(25).position);
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(60).position);
		assertEquals(1, treeOrd5.search(90).position);
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(55).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(1, treeOrd5.search(80).position);
		assertEquals(0, treeOrd5.search(95).position);
		assertEquals(1, treeOrd5.search(99).position);
		
		assertEquals(17, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
		treeOrd5.remove(7);
		
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(45).position);
		assertEquals(2, treeOrd5.search(60).position);
		assertEquals(3, treeOrd5.search(90).position);
		
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(15).position);
		assertEquals(2, treeOrd5.search(20).position);
		assertEquals(3, treeOrd5.search(25).position);
		
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(55).position);
		
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(1, treeOrd5.search(80).position);
		
		assertEquals(0, treeOrd5.search(95).position);
		assertEquals(1, treeOrd5.search(99).position);
		
		assertEquals(16, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.insert(8);
		
		assertEquals(0, treeOrd5.search(45).position);
		assertEquals(0, treeOrd5.search(15).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(0, treeOrd5.search(60).position);
		assertEquals(1, treeOrd5.search(90).position);
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(25).position);
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(55).position);
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(1, treeOrd5.search(80).position);
		assertEquals(0, treeOrd5.search(95).position);
		assertEquals(1, treeOrd5.search(99).position);
		
		assertEquals(17, treeOrd5.size());
		assertEquals(2, treeOrd5.height());
		
		treeOrd5.remove(99);
		
		assertEquals(0, treeOrd5.search(15).position);
		assertEquals(1, treeOrd5.search(30).position);
		assertEquals(2, treeOrd5.search(45).position);
		assertEquals(3, treeOrd5.search(60).position);
		
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(1, treeOrd5.search(80).position);
		assertEquals(2, treeOrd5.search(90).position);
		assertEquals(3, treeOrd5.search(95).position);
		
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(8).position);
		
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(25).position);
		
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(55).position);
		
		assertEquals(16, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(25);
		
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(45).position);
		assertEquals(2, treeOrd5.search(60).position);
		
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(2, treeOrd5.search(15).position);
		assertEquals(3, treeOrd5.search(20).position);
		
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(1, treeOrd5.search(80).position);
		assertEquals(2, treeOrd5.search(90).position);
		assertEquals(3, treeOrd5.search(95).position);
		
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		
		assertEquals(0, treeOrd5.search(50).position);
		assertEquals(1, treeOrd5.search(55).position);
		
		assertEquals(15, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(50);
	
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(45).position);
		assertEquals(2, treeOrd5.search(75).position);
		
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(2, treeOrd5.search(15).position);
		assertEquals(3, treeOrd5.search(20).position);
		
		assertEquals(0, treeOrd5.search(80).position);
		assertEquals(1, treeOrd5.search(90).position);
		assertEquals(2, treeOrd5.search(95).position);
		
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		
		assertEquals(0, treeOrd5.search(55).position);
		assertEquals(1, treeOrd5.search(60).position);
		
		assertEquals(14, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(80);
		
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(45).position);
		assertEquals(2, treeOrd5.search(75).position);
		
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(2, treeOrd5.search(15).position);
		assertEquals(3, treeOrd5.search(20).position);
		
		assertEquals(0, treeOrd5.search(90).position);
		assertEquals(1, treeOrd5.search(95).position);
		
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		
		assertEquals(0, treeOrd5.search(55).position);
		assertEquals(1, treeOrd5.search(60).position);
		
		assertEquals(13, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(55);
		
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(75).position);
		
		assertEquals(0, treeOrd5.search(90).position);
		assertEquals(1, treeOrd5.search(95).position);
		
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		assertEquals(2, treeOrd5.search(45).position);
		assertEquals(3, treeOrd5.search(60).position);
		
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(2, treeOrd5.search(15).position);
		assertEquals(3, treeOrd5.search(20).position);
		
		assertEquals(12, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(90);
		
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(2, treeOrd5.search(15).position);
		assertEquals(3, treeOrd5.search(20).position);
		
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		assertEquals(2, treeOrd5.search(45).position);
		
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(60).position);
		
		assertEquals(0, treeOrd5.search(75).position);
		assertEquals(1, treeOrd5.search(95).position);
	
		
		assertEquals(11, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(75);
		
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(45).position);
		assertEquals(0, treeOrd5.search(35).position);
		assertEquals(1, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(60).position);
		assertEquals(1, treeOrd5.search(95).position);
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(2, treeOrd5.search(15).position);
		assertEquals(3, treeOrd5.search(20).position);
		
		assertEquals(10, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(40);
		
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(45).position);
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(35).position);
		assertEquals(0, treeOrd5.search(60).position);
		assertEquals(1, treeOrd5.search(95).position);
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(2, treeOrd5.search(15).position);
		
		assertEquals(9, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(60);
		
		assertEquals(0, treeOrd5.search(20).position);
		
		assertEquals(0, treeOrd5.search(30).position);
		assertEquals(1, treeOrd5.search(35).position);
		assertEquals(2, treeOrd5.search(45).position);
		assertEquals(3, treeOrd5.search(95).position);
		
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(2, treeOrd5.search(15).position);
		
		assertEquals(8, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(95);
		treeOrd5.remove(45);
		treeOrd5.remove(30);
		
		assertEquals(0, treeOrd5.search(15).position);
		assertEquals(0, treeOrd5.search(5).position);
		assertEquals(1, treeOrd5.search(8).position);
		assertEquals(0, treeOrd5.search(20).position);
		assertEquals(1, treeOrd5.search(35).position);
		
		assertEquals(5, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
		treeOrd5.remove(5);
		
		assertEquals(0, treeOrd5.search(8).position);
		assertEquals(1, treeOrd5.search(15).position);
		assertEquals(2, treeOrd5.search(20).position);
		assertEquals(3, treeOrd5.search(35).position);
		
		assertEquals(4, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
		
		for(int i = 0; i < 100 ; i++)
			treeOrd5.remove(i);
		assertEquals(0, treeOrd5.size());
		assertEquals(-1, treeOrd5.height());
		
		treeOrd5.insert(1000);
		
		assertEquals(0, treeOrd5.search(1000).position);
		
		
		assertEquals(1, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
		
	
		
		
	}
	
	//Testa remocoes de elementos em no interno*
	@Test
	public void testaRemocaoInterna01(){
		treeOrd5.insert(50);
		treeOrd5.insert(40);
		treeOrd5.insert(22);
		treeOrd5.insert(78);
		treeOrd5.insert(37);
		
		treeOrd5.remove(40);
	
		
		assertEquals(0, treeOrd5.search(22).position);
		assertEquals(1, treeOrd5.search(37).position);
		assertEquals(2, treeOrd5.search(50).position);
		assertEquals(3, treeOrd5.search(78).position);
		
		assertEquals(4, treeOrd5.size());
		assertEquals(0, treeOrd5.height());
		
	}
	
	//Testa remocoes de elementos em no interno*
	@Test
	public void testaRemocaoInterna02(){
		treeOrd5.insert(50);
		treeOrd5.insert(40);
		treeOrd5.insert(22);
		treeOrd5.insert(78);
		treeOrd5.insert(37);
		treeOrd5.insert(45);
		treeOrd5.insert(49);
		treeOrd5.insert(60);
		
		treeOrd5.remove(50);
		
		assertEquals(0, treeOrd5.search(40).position);
		assertEquals(0, treeOrd5.search(22).position);
		assertEquals(1, treeOrd5.search(37).position);
		assertEquals(0, treeOrd5.search(45).position);
		assertEquals(1, treeOrd5.search(49).position);
		assertEquals(2, treeOrd5.search(60).position);
		assertEquals(3, treeOrd5.search(78).position);
		
		assertEquals(7, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
	}
	
	//Testa remocoes de elementos em no interno*
	@Test
	public void testaRemocaoInterna03(){
		treeOrd5.insert(50);
		treeOrd5.insert(40);
		treeOrd5.insert(22);
		treeOrd5.insert(78);
		treeOrd5.insert(37);
		treeOrd5.insert(45);
		treeOrd5.insert(49);
		treeOrd5.insert(60);
		
		treeOrd5.remove(40);
		
		assertEquals(0, treeOrd5.search(50).position);
	
		assertEquals(0, treeOrd5.search(60).position);
		assertEquals(1, treeOrd5.search(78).position);
		assertEquals(0, treeOrd5.search(22).position);
		assertEquals(1, treeOrd5.search(37).position);
		assertEquals(2, treeOrd5.search(45).position);
		assertEquals(3, treeOrd5.search(49).position);
		
		assertEquals(7, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
	}
	
	//Testa remocoes de elementos em no interno*
	@Test
	public void testaRemocaoInterna04(){
		treeOrd5.insert(50);
		treeOrd5.insert(40);
		treeOrd5.insert(22);
		treeOrd5.insert(78);
		treeOrd5.insert(37);
		treeOrd5.insert(45);
		treeOrd5.insert(49);
		treeOrd5.insert(60);
		treeOrd5.insert(70);
		treeOrd5.insert(80);
		treeOrd5.insert(90);
		treeOrd5.insert(65);
		treeOrd5.insert(63);
		treeOrd5.insert(67);
		treeOrd5.insert(10);
		treeOrd5.insert(9);
		treeOrd5.insert(8);
		
		treeOrd5.remove(40);
		
		
		assertEquals(0, treeOrd5.search(10).position);
		assertEquals(1, treeOrd5.search(50).position);
		assertEquals(2, treeOrd5.search(65).position);
		assertEquals(3, treeOrd5.search(78).position);
		assertEquals(0, treeOrd5.search(8).position);
		assertEquals(1, treeOrd5.search(9).position);
		assertEquals(0, treeOrd5.search(60).position);
		assertEquals(1, treeOrd5.search(63).position);
		assertEquals(0, treeOrd5.search(67).position);
		assertEquals(1, treeOrd5.search(70).position);
		assertEquals(0, treeOrd5.search(80).position);
		assertEquals(1, treeOrd5.search(90).position);
		assertEquals(0, treeOrd5.search(22).position);
		assertEquals(1, treeOrd5.search(37).position);
		assertEquals(2, treeOrd5.search(45).position);
		assertEquals(3, treeOrd5.search(49).position);
		
		assertEquals(16, treeOrd5.size());
		assertEquals(1, treeOrd5.height());
		
	}
		
	//Verifica o aumento e diminuicao do tamanho para arvores gigantes
	@Test
	public void testeSize(){
		
		for(int i = 1; i < 1000; i++){
			treeOrd3.insert(i);
		}
		
		for(int i = 1; i < 1000; i++){
			assertEquals(1000-i, treeOrd3.size());
			treeOrd3.remove(i);
		}
		
		for(int i = 1; i < 1000; i++){
			treeOrd3.insert(i);
		}
		
		for(int i = 999; i > 0; i--){
			assertEquals(i, treeOrd3.size());
			treeOrd3.remove(i);
		}
	
		for(int i = 1; i < 10000; i++){
			treeOrd5.insert(i);
		}
		
		for(int i = 1; i < 10000; i++){
			assertEquals(10000-i, treeOrd5.size());
			treeOrd5.remove(i);
		}
		
		for(int i = 1; i < 10000; i++){
			treeOrd5.insert(i);
		}
		
		for(int i = 9999; i > 0; i--){
			assertEquals(i, treeOrd5.size());
			treeOrd5.remove(i);
		}
		
	}
	
	//Testa o metodo DepthLeftOrder
	@Test
	public void testDepthLeftOrder(){
//		
// 													 								[50]
//														[20]  												    	[80]
//										[10]						[30 , 40]				    	 [65,70] 						[90]
//									[5]		 [15]			    [25]   [35]   [45]				 [55] [60] [75] 				[85] 	[95]
//
//		
// Ordem de insercao dos elementos: 50, 80, 30, 75, 95, 90, 70, 5, 10, 45, 20, 60, 85, 25, 55, 15, 40, 35, 65
		
		BNode<Integer> node_50 = new BNode<Integer>(3), 
				node_20 = new BNode<Integer>(3), 
				node_80 = new BNode<Integer>(3), 
				node_10 = new BNode<Integer>(3), 
				node_30_40 = new BNode<Integer>(3),
				node_65_70 = new BNode<Integer>(3),
				node_90 = new BNode<Integer>(3),
				node_5 = new BNode<Integer>(3),
				node_15 = new BNode<Integer>(3),
				node_25 = new BNode<Integer>(3), 
				node_35 = new BNode<Integer>(3),
				node_45 = new BNode<Integer>(3), 
				node_55 = new BNode<Integer>(3),
				node_60 = new BNode<Integer>(3),
				node_75 = new BNode<Integer>(3), 
				node_85 = new BNode<Integer>(3), 
				node_95 = new BNode<Integer>(3);
		
			
				
				LinkedList<BNode<Integer>> height_0 = new LinkedList<BNode<Integer>>(); height_0.addLast(node_20); height_0.addLast(node_80);
				LinkedList<BNode<Integer>> height_1_1 = new LinkedList<BNode<Integer>>(); height_1_1.addLast(node_10); height_1_1.addLast(node_30_40);
				LinkedList<BNode<Integer>> height_1_2 = new LinkedList<BNode<Integer>>(); height_1_2.addLast(node_65_70); height_1_2.addLast(node_90);
				LinkedList<BNode<Integer>> height_2_1 = new LinkedList<BNode<Integer>>(); height_2_1.addLast(node_5); height_2_1.addLast(node_15);
				LinkedList<BNode<Integer>> height_2_2 = new LinkedList<BNode<Integer>>(); height_2_2.addLast(node_25); height_2_2.addLast(node_35); height_2_2.addLast(node_45);
				LinkedList<BNode<Integer>> height_2_3 = new LinkedList<BNode<Integer>>(); height_2_3.addLast(node_55); height_2_3.addLast(node_60); height_2_3.addLast(node_75);
				LinkedList<BNode<Integer>> height_2_4 = new LinkedList<BNode<Integer>>(); height_2_4.addLast(node_85); height_2_4.addLast(node_95);
				
				node_50.setChildren(height_0);
				node_20.setChildren(height_1_1);
				node_80.setChildren(height_1_2);
				node_10.setChildren(height_2_1);
				node_30_40.setChildren(height_2_2);
				node_65_70.setChildren(height_2_3);
				node_90.setChildren(height_2_4);
				
				node_50.addElement(50); 
				node_20.addElement(20);  
				node_80.addElement(80);   
				node_10.addElement(10);  
				node_30_40.addElement(30); node_30_40.addElement(40);   
				node_65_70.addElement(65); node_65_70.addElement(70);    
				node_90.addElement(90); 
				node_5.addElement(5); 
				node_15.addElement(15);  
				node_25.addElement(25);  
				node_35.addElement(35);  
				node_45.addElement(45);  
				node_55.addElement(55);  
				node_60.addElement(60);  
				node_75.addElement(75); 
				node_85.addElement(85); 
				node_95.addElement(95); 

				BNode[] DepthLeftOrder = {node_50, 
						node_20, 
						node_10,
						node_5,
						node_15,
						node_30_40,
						node_25,
						node_35,
						node_45,
						node_80,
						node_65_70,
						node_55,
						node_60,
						node_75,
						node_90,
						node_85,
						node_95};
				
				treeOrd3.root = node_50;
				
				BNode[] DepthLeftOrderBTree = treeOrd3.depthLeftOrder();
				
				assertTrue(Arrays.equals(DepthLeftOrder, DepthLeftOrderBTree));
				}

}



/*Observacoes:
 * 
 * Na Arvore B existem tres casos de remocao:
 * -Em folha
 * -O no fica no limite inferior de elementos podendo acontecer de pegar um elemento do pai e um do irmao(Redistribuicao) se este nao ficar 
 * o irmao tambem abaixo do limite inferior, ou se o irmao a esquerda e a direita estao no limite inferior fazer a concatenacao de nos
 * (fusao do no + elemento do pai + irmao do no) verificando se o pai esta abaixo do limite inferior se estiver procede recursivamente
 * ate que todos os nos estejam satisfazendo a propriedade.
 * 
 * 
 */

