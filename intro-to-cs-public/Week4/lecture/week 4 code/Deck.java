
public class Deck {
	public static void main(String[] args) {
		// Builds a deck of cards
		String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "Jack", "Queen", "King", "Ace"   };
		String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
		int Nsuit = suit.length;
		int Nrank = rank.length;
		int N = Nsuit * Nrank;

		String[] deck = new String[N];
		for (int i = 0; i < Nrank; i++)
			for (int j = 0; j < Nsuit; j++)
				deck[Nsuit * i + j] = rank[i] + " of " + suit[j];

		// Shuffles the deck​
		for (int i = 0; i < N; i++) {
			int r = i + (int) (Math.random() * (N-i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}

		// Prints the shuffled deck​
		for (int i = 0; i < N; i++)
			System.out.println(deck[i]);
	}
}
