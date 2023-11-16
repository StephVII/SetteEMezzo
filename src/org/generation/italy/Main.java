package org.generation.italy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random R = new Random();
		
		String risposta, cartaEstratta;
		int numCarta, i, conta;
		double n, punti, puntiBanco;
		Boolean sballo;
		
		ArrayList<String> mazzo = new ArrayList<>();
		ArrayList<Double> punteggio = new ArrayList<>();
		
		String[] valore = {"Asso", "2", "3", "4", "5", "6", "7", "Donna", "Cavallo", "Re"};
		String[] semi = {"Denari", "Coppe", "Spade", "Bastoni"};
		
		conta = 0;
		punti = 0;
		puntiBanco = 0;
		sballo = false;
		
		for(String seme : semi)
		{
			for(i=0; i<10; i++)
			{
				mazzo.add(valore[i]+" di "+seme);
				
				if(i >= 0 && i < 7)
				{
					n = i+1;
					punteggio.add(n);
				}
				else if(i >= 7 && i <= 9)
				{
					punteggio.add(0.5);
				}
			}
		}
		
		
		do 
		{
			
			numCarta = R.nextInt(mazzo.size());
			cartaEstratta = mazzo.get(numCarta);
			punti = punti + punteggio.get(numCarta);
			if(conta == 0)
			{
				System.out.println("La tua prima carta è "+cartaEstratta);
				System.out.println("Attualmente hai "+punti+" punti.");
				conta++;
			}
			else if(conta > 0)
			{
				System.out.println("La tua nuova carta è "+cartaEstratta);
				System.out.println("Attualmente hai "+punti+" punti.");
			}
			mazzo.remove(numCarta);
			punteggio.remove(numCarta);
			
			if(punti > 7.5)
			{
				System.out.println("Hai sballato.");
				sballo = true;
				break;
			}
			else if(punti == 7.5)
			{
				break;
			}
			else
			{
				System.out.println("Vuoi estrarre un'altra carta? (si/no)");
				risposta = sc.nextLine();
			}
			
		} 
		while(risposta.equals("si"));
		
		System.out.println("\n\n");
		
		while(puntiBanco < 5 && sballo == false)
		{
			numCarta = R.nextInt(mazzo.size());
			cartaEstratta = mazzo.get(numCarta);
			puntiBanco = puntiBanco + punteggio.get(numCarta);
			System.out.println("\nLa carta del banco è "+cartaEstratta+".");
			System.out.println("\nIl punteggio attuale del banco è "+puntiBanco+".");
			mazzo.remove(numCarta);
			punteggio.remove(numCarta);
			
			if(puntiBanco > 7.5)
			{
				System.out.println("Il banco ha sballato.");
			}
		} 
		
		if(puntiBanco > punti && puntiBanco <= 7.5)
			System.out.println("Ha vinto il banco.");
		else if(!(punti==puntiBanco)&&sballo == false)
			System.out.println("Hai vinto tu.");
		else
			System.out.println("Ha vinto il banco.");
		
		System.out.println("\n\nPartita finita, hai chiuso con "+punti+" punti. \n Il banco ha chiuso con "+puntiBanco+".");
	}

}
