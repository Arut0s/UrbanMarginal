package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modele.Mur;



class MurTest {
	
	Mur mur1 = new Mur();
	Mur mur2 = new Mur();

	@Test
	void testToucheObjetGauche() {
		//mur 2 touche à gauche mur1
		mur1.setPosX(50);
		mur1.setPosY(50);
		mur2.setPosX(40);
		mur2.setPosY(50);
		assertTrue(mur1.toucheObjet(mur2));
	}
	
	@Test
	void testToucheObjetDroite() {
		//mur 2 touche à droite mur1
				mur1.setPosX(50);
				mur1.setPosY(50);
				mur2.setPosX(60);
				mur2.setPosY(50);
				assertTrue(mur1.toucheObjet(mur2));
	}
	
	@Test
	void testToucheObjetHaut() {
		//mur 2 touche en haut mur1
				mur1.setPosX(50);
				mur1.setPosY(50);
				mur2.setPosX(50);
				mur2.setPosY(40);
				assertTrue(mur1.toucheObjet(mur2));
	}
	
	@Test
	void testToucheObjetBas() {
		//mur 2 touche en bas mur1
				mur1.setPosX(50);
				mur1.setPosY(50);
				mur2.setPosX(50);
				mur2.setPosY(60);
				assertTrue(mur1.toucheObjet(mur2));
	}
	@Test
	void testNonToucheObjetGauche() {
		//mur 2 ne touche ppas à gauche mur1
		mur1.setPosX(50);
		mur1.setPosY(50);
		mur2.setPosX(10);
		mur2.setPosY(50);
		assertFalse(mur1.toucheObjet(mur2));
	}
	
	@Test
	void testNonToucheObjetDroite() {
		//mur 2 ne touche pas à droite mur1
				mur1.setPosX(50);
				mur1.setPosY(50);
				mur2.setPosX(90);
				mur2.setPosY(50);
				assertFalse(mur1.toucheObjet(mur2));
	}
	
	@Test
	void testNonToucheObjetHaut() {
		//mur 2 ne touche pas en haut mur1
				mur1.setPosX(50);
				mur1.setPosY(50);
				mur2.setPosX(50);
				mur2.setPosY(10);
				assertFalse(mur1.toucheObjet(mur2));
	}
	
	@Test
	void testNonToucheObjetBas() {
		//mur 2 ne touche pas en bas mur1
				mur1.setPosX(50);
				mur1.setPosY(50);
				mur2.setPosX(50);
				mur2.setPosY(90);
				assertFalse(mur1.toucheObjet(mur2));
	}
}
