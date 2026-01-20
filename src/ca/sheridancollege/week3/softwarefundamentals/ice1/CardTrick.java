/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then
 * asks the user to pick a card and searches the array of cards for the match to
 * the user's card. To be used as starting code in ICE 1
 *
 * @author Ishfaq Chamerally 991827128
 */
public class CardTrick {

	public static void main(String[] args) {
		Card[] magicHand = new Card[7];
		Card luckyCard = new Card();
		luckyCard.setValue(3);
		luckyCard.setSuit(Card.SUITS[2]);

		for (int i = 0; i < magicHand.length; i++) {
			Card c = new Card();
			c.setValue((int) (Math.random() * 13 + 1));
			c.setSuit(Card.SUITS[(int) (Math.random() * 3 + 1)]);

			magicHand[i] = c;
		}

		//insert code to ask the user for Card value and suit, create their card
		// and search magicHand here
		//Then report the result here
		Scanner input = new Scanner(System.in);
		String suit = null;
		do {
			System.out.print("Enter suit: ");
			suit = input.nextLine();
			if(!Arrays.asList(Card.SUITS).contains(suit.toLowerCase())) {
				System.out.println("Invalid suit.");
				suit = null;
			}
		} while (suit == null);

		int val = -1;
		do {
			try {
				System.out.print("Enter value: ");
				val = input.nextInt();
				if (val > 13) System.out.println("Invalid number");
			} catch(InputMismatchException ex) {
				System.out.println("Invalid number");
				input.next();
				val = -1;
			}
		} while (val < 0 || val > 13);

		boolean found = false;
		for (int i = 0; i < magicHand.length; ++i) {
			if (magicHand[i].equals(new Card(suit, val))) {
				System.out.println("Found in magic hand");
				found = true;
				break;
			}
		}
		
		if (!found) {
			System.out.println("Your card is not in found in magic hand");
		}
	}

}

