package swag.labs.test.domain;

import java.util.Collection;
import java.util.stream.Collectors;

public class CartItems {
	
	private Collection<CartItem> cartItems;
	
	public Collection<CartItem> getCartItems() {
		return cartItems;
	}
	
	public Collection<String> getNamesOfCartItems() {
		return cartItems
				.stream()
				.map(CartItem::getName)
				.collect(Collectors.toList());
	}

	public void setItemsToBuy(Collection<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
}