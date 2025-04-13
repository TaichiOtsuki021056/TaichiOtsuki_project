package product;

public class Product {
	//フィールド
	private int id;
	private String name;
	private int price;
	private int stock;

	// コンストラクタ(そのクラスのメンバ変数を初期化する)
	public Product(int id, String name, int price, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	//メソッド　 Getter & Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	//オーバーロード(引数を指定する)
	public String toString() {
		return "Product: id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock;
	}
}
