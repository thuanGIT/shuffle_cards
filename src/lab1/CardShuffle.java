package lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class CardShuffle{

	public static final String[] SUITS = {"Spades", "Hearts", "Clubs", "Diamonds"};
	public static final String[] RANKS = {"Ace", "2", "3", "4","5","6","7","8","9","10","Jack","Queen","King"};

	public static void main(String[] args) {
		/* DO NOT EDIT MAIN METHOD */
		
		//Create a new deck
		ArrayList<String> deck = makeDeck();
		System.out.println("The new deck is "+deck);

		//Shuffle and print it  
		shuffle(deck);
		System.out.println("The shuffled deck is "+deck);

		//Get information about number of hands to deal, and of what size
		Scanner keyboard = new Scanner(System.in);
		System.out.print("How many hands should be dealt? ");
		int numHands = keyboard.nextInt();
		System.out.print("How many cards in each hand? ");
		int numCards = keyboard.nextInt();
		keyboard.close();

		if(numHands*numCards > SUITS.length*RANKS.length) {
			System.out.println("ERROR: There are not "+(numHands*numCards)+" cards in the deck.");
			return;
		}
		
		//Deal the hands and print them.
		ArrayList<String>[] theHands = deal(deck,numHands,numCards);
		System.out.println("The hands are:");
		for(int i=0; i<numHands; i++)
			System.out.println("Hand "+(i+1)+": "+theHands[i]);
		System.out.println("The remaining deck: "+deck);

	}

	public static ArrayList<String> makeDeck(){
		// Create an arraylist to hold the names of cards
		ArrayList<String> deck = new ArrayList<>();

		// A deck has 52 cards so we add 52 Strings into the list	
		for (int i = 0; i < 52; i++){
			// i/13 to get the index of 0...13 and i%13 to get index in suit 0,1,2,3
				deck.add(RANKS[i%13] + " of " + SUITS[i/13]);
		}
		return deck;
	}

	public static void shuffle(ArrayList<String> deck){
		for (int i = 0; i < deck.size()-1; i++){
			// Choose a random index in i..deck.size()-1
			int index = (int)(Math.random()*(deck.size()-i))+i;

			// Swap the chosen card with the current pointed card
			// Create a temp variable to hold the value at index i
			String temp = deck.get(i);
			//Set value at index i to be the value at the chosen index
			deck.set(i,deck.get(index));
			// Set the value at the chosen random index to be that of i
			deck.set(index, temp);
		
	
		}
	}

	public static ArrayList<String>[] deal(ArrayList<String> deck, int numHands, int numCards){
		ArrayList<String>[] deal = new ArrayList[numHands]; 
		// I see it has a warming about type safety but there is not a way i can think of to fix it.
		// Could you suggest a way to fix this? I am stuck for hours.

		// Intialize the # of ArrayList ==  the # of hands playing
		for (int i = 0; i < deal.length; i++)
			deal[i] = new ArrayList<>();

		for (int i = 0; i < numCards*numHands; i++) {
			// We use i%numHands so that each times the last person receives the card. It is reset to 0
			// Same logic when we add the cards to the deck
			// Working the same as stack pop()
			deal[i%numHands].add(deck.remove(deck.size()-1));
		}
		return deal;
	}
}