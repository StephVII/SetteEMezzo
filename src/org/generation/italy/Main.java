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
		int numCarta, i, j;
		
		ArrayList<String> mazzo = new ArrayList<>();
		String[] semi = {"Denari", "Coppe", "Spade", "Bastoni"};
		
		for(j=0; j<4; j++)
		{
			for(i=1; i<=10; i++)
			{
				mazzo.add(i+" di "+semi[j]);
			}
		}
		
		for(i=0; i<40; i++)
		{
			System.out.println(mazzo.get(i));
		}
		
		/*System.out.println("Vuoi estrarre una carta? (si/no)");
		risposta = sc.nextLine();
		if(risposta.equals("si"))
		{
			numCarta = R.nextInt(mazzo.length);
			cartaEstratta = mazzo[numCarta];
			System.out.println("La tua carta è "+cartaEstratta);
		}*/
		
		
	}

}
