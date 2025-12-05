package L20.MauMauGeneric;

import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Skat skat = new Skat();
		List<French_Suited> hand = skat.get_hand();
		print_hand(hand);
		Collections.sort(hand);
		print_hand(hand);
	}

	public <T extends Comparable<T>> void print_deck(Deck<? extends Card<T>> deck) {
		print_hand(deck.get_deck());
	}

	public static <T extends Comparable<T>> void print_hand(List<? extends Card<T>> hand) {
		System.out.println("———————————");
		for (Card<T> c : hand) {
			System.out.println(c);
		}
		System.out.println("———————————");
	}
}
