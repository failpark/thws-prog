package L20.MauMauGeneric;

import java.util.ArrayList;
import java.util.List;

public class Skat implements Deck<French_Suited> {
	List<French_Suited> deck;

	public Skat() {
		this.deck = s_get_deck();
	}

	public List<French_Suited> get_deck() {
		return this.deck;
	}

	public static List<French_Suited> s_get_deck() {
		ArrayList<French_Suited> out = new ArrayList<>();
		for (Kind k : Kind.values()) {
			for (Weight w : Weight.values()) {
				out.add(new French_Suited(k, w));
			}
		}
		return out;
	}

	public List<French_Suited> get_hand() {
		List<French_Suited> hand = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			hand.add(deck.remove((int)(Math.random() * deck.size())));
		}
		return hand;
	}
}
