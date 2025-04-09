package product;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		ProductManager manager = new ProductManager();

		// 商品を追加
		manager.addProduct(new Product(1, "冷蔵庫", 50000, 10));
		manager.addProduct(new Product(2, "ソファ", 30000, 5));
		manager.addProduct(new Product(3, "米", 2000, 3));
		manager.addProduct(new Product(4, "小説", 1500, 4));
		manager.addProduct(new Product(5, "Tシャツ", 1500, 5));

		// 商品一覧を表示
		System.out.println("\n---商品を追加して全てを表示する---");
		for (Product product : manager.getProductList()) {
			System.out.println(product);
		}

		// 商品の削除
		manager.removeProduct(1);

		System.out.println("\n---商品を1つ削除して全てを表示する---");
		for (Product product : manager.getProductList()) {
			System.out.println(product);
		}

		// 商品の検索
		System.out.println("\n---商品名「米」の情報を表示する---");
		Product foundProduct = manager.getProductByName("米");
		if (foundProduct != null) {
			//foundProductがnullではない
			System.out.println(foundProduct);
		} else {
			System.out.println("商品が見つかりませんでした。");
		}

		//商品の割引を表示する
		System.out.println("\n---商品名「ソファ」の情報と割引率30%の情報を表示する---");
		DiscountedProduct discountedSofa = new DiscountedProduct(2, "ソファ", 30000, 5);
		System.out.println(discountedSofa);

		// 商品の検索（部分一致）
		System.out.println("\n---商品名「Tシャツ」を検索して表示する---");
		List<Product> searchResults = manager.search("Tシャツ");

		for (Product product : searchResults) {
			System.out.println(product);
		}

	}
}
