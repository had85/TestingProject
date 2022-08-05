package swag.labs.test.domain;

import java.util.Collection;
import java.util.stream.Collectors;

public class Checkout {

	private User user;
	
	private Collection<CartItem> itemsToBuy;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<CartItem> getItemsToBuy() {
		return itemsToBuy;
	}
	
	public Collection<String> getItemsToBuyNames() {
		return itemsToBuy
				.stream()
				.map(CartItem::getName)
				.collect(Collectors.toList());
	}

	public void setItemsToBuy(Collection<CartItem> itemsToBuy) {
		this.itemsToBuy = itemsToBuy;
	}

	@Override
	public String toString() {
		return "Checkout [user=" + user + ", itemsToBuy=" + itemsToBuy + "]";
	}
}