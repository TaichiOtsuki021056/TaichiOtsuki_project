package management;

import java.util.ArrayList;
import java.util.List;

public class ProductManagementInfo implements SearchProduct {
	private final List<Product> productsList;

	public ProductManagementInfo() {
		this.productsList = new ArrayList<>();
	}

	// 商品追加
	public void addProduct(Product product) {
		productsList.add(product);
	}

	// 商品情報取得（商品名から）
	public Product getProductInfoByName(String name) {
		for (Product product : productsList) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}

	// 商品情報取得（IDから）
	public Product getProductInfoById(int id) {
		for (Product product : productsList) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	// 商品検索
	public List<Product> search(String name) {
		List<Product> results = new ArrayList<>();
		for (Product product : productsList) {
			if (product.getName().contains(name)) {
				results.add(product);
			}
		}
		return results;
	}

	// 商品削除（ID指定）
	public boolean deleteProduct(int id) {
		return productsList.removeIf(product -> product.getId() == id);
	}

	// 全商品を表示
	public void displayAllProducts() {
		if (productsList.isEmpty()) {
			System.out.println("商品が登録されていません。");
		} else {
			System.out.println("商品を全て表示します");
			for (Product product : productsList) {
				System.out.println(product);
			}
		}
	}
}
