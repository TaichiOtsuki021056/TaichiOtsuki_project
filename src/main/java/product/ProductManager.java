package product;

import java.util.ArrayList;
import java.util.List;


public class ProductManager implements Searchable {
	//Product.javaに対応したリスト"productsList"を作成
	//紫のProductはジェネリクス
	//ジェネリクスを使用したフィールドや(引数、戻り値を含めた)メソッドにProductが使用できる
	private List<Product> productsList;

	// コンストラクタ
	public ProductManager() {
		this.productsList = new ArrayList<>();
	}

	// 新たなproductを追加する
	public void addProduct(Product product) {
		productsList.add(product);
	}

	// idを引数としてproductを削除する（ラムダ式を使用）
	public void removeProduct(int id) {
		//removeIf()メソッドは、引数として渡された条件でリストのアイテムを削除する
		//今回はproductのidがremoveProductの引数と同じなら削除する
		//removeIf()の中の左のproductにProduct.javaのオブジェクトが格納してある
		productsList.removeIf(product -> product.getId() == id);
	}

	// nameを引数としてproduct名を取得する
	public Product getProductByName(String name) {
		for (Product product : productsList) {
			//equals()はオブジェクト型(String型等)、それに対し==はプリミティブ型(int型等)
			//今回はString型なのでequalsを使用する
			//productのnameがgetProductByNameの引数と同じならproductsListから取得する
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}

	// 商品一覧を取得
	public List<Product> getProductList() {
		return productsList;
	}

	//Searchableインターフェイスの実装
	public List<Product> search(String name) {
		List<Product> results = new ArrayList<>();
		for (Product product : productsList) {
			// 部分一致検索 (name に含まれるかどうか)
			if (product.getName().contains(name)) {
				results.add(product);
			}
		}
		return results;

	}
}