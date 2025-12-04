package L20.MauMauGeneric;

import java.util.List;

public interface Deck<T> {
	public List<T> get_deck();
	public List<T> get_hand();
}
