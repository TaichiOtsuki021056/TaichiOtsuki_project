package product;

public class DiscountedProduct extends Product {
	public double discountRate = 0.3;

	public DiscountedProduct(int id, String name, int price, int stock) {
		super(id, name, price, stock);

	}

	public int calculateDiscountedPrice() {

		return (int) (getPrice() * (1 - discountRate));
	}

	public String toString() {
		return super.toString() + ", 割引率=" + discountRate + ", 割引後価格=" + calculateDiscountedPrice();
	}
}
