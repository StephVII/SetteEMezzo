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
		int numCarta, i, j, conta;
		double n, punti;
		
		ArrayList<String> mazzo = new ArrayList<>();
		ArrayList<Double> punteggio = new ArrayList<>();
		
		String[] semi = {"Denari", "Coppe", "Spade", "Bastoni"};
		
		conta = 0;
		punti = 0;
		
		for(j=0; j<4; j++)
		{
			for(i=1; i<=10; i++)
			{
				mazzo.add(i+" di "+semi[j]);
				
				if(i >= 1 && i < 8)
				{
					n = i;
					punteggio.add(n);
				}
				else if(i >= 8 && i <= 10)
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
				System.out.println("Hai sballato. Vince il banco.");
				break;
			}
			else
			{
				System.out.println("Vuoi estrarre un'altra carta? (si/no)");
				risposta = sc.nextLine();
			}
			
		} 
		while(risposta.equals("si"));
		
		System.out.println("\n\nPartita finita, hai chiuso con "+punti+" punti.");
	}

}
