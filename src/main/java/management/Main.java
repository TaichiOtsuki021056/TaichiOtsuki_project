package management;

import java.util.List;
import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private static final ProductManagementInfo productManager = new ProductManagementInfo();

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n---メニュー---");
			System.out.println("1: 商品追加");
			System.out.println("2: 商品情報取得");
			System.out.println("3: 商品検索");
			System.out.println("4: 商品全て表示");
			System.out.println("5: 商品削除");
			System.out.println("0: 終了");

			System.out.println("\nメニューから操作を選択してください");
			String choice = scanner.nextLine();

			switch (choice) {
			case "1":
				addProduct();
				break;
			case "2":
				getProductInfo();
				break;
			case "3":
				searchProduct();
				break;
			case "4":
				productManager.displayAllProducts();
				break;
			case "5":
				deleteProduct();
				break;
			case "0":
				System.out.println("終了します");
				return;
			default:
				System.out.println("無効な選択肢です。もう一度入力してください。");
			}
		}
	}

	// 商品追加
	private static void addProduct() {
		try {
			System.out.println("商品IDを入力してください: ");
			String idInput = scanner.nextLine();
			int id = Integer.parseInt(idInput);
			System.out.println("入力されたID:" + id);

			System.out.println("商品名を入力してください: ");
			String name = scanner.nextLine();
			if (name == null || name.trim().isEmpty()) {
				System.out.println("無効な入力です。入力された商品名:" + name);
				throw new Exception("無効な入力です。商品名を正しく入力してください。");
			}
			System.out.println("入力された商品名:" + name);

			System.out.println("価格を入力してください: ");
			String priceInput = scanner.nextLine();
			int price = Integer.parseInt(priceInput);
			if (price < 0) {
				System.out.println("無効な入力です。入力された価格:" + price);
				throw new Exception("無効な入力です。価格を正しく入力してください。");
			}
			System.out.println("入力された価格:" + price);

			System.out.println("在庫数を入力してください:");
			String stockInput = scanner.nextLine();
			int stock = Integer.parseInt(stockInput);
			if (stock < 0) {
				System.out.println("無効な入力です。入力された在庫数:" + stock);
				throw new Exception("無効な入力です。在庫を正しく入力してください。");
			}
			System.out.println("入力された在庫" + stock);

			Product product = new Product(id, name, price, stock);
			productManager.addProduct(product);
			System.out.println(product + "を登録しました。");
		} catch (NumberFormatException e) {
			System.out.println("数値を正しく入力してください。");
		} catch (IllegalArgumentException e) {
			System.out.println("入力エラー: " + e.getMessage());
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	// 商品情報取得（商品名から検索）
	private static void getProductInfo() {
		System.out.print("商品情報を取得する商品名を入力してください:");
		String name = scanner.nextLine();
		Product product = productManager.getProductInfoByName(name);

		if (product != null) {
			System.out.println("取得した商品は、" + product + "です。");
		} else {
			System.out.println("商品が見つかりませんでした。");
		}
	}

	// 商品検索
	private static void searchProduct() {
		System.out.print("検索する商品名を入力してください: ");
		String name = scanner.nextLine();
		List<Product> results = productManager.search(name);
		if (results.isEmpty()) {
			System.out.println("該当する商品は見つかりませんでした。");
		} else {
			System.out.println("検索結果:");
			for (Product product : results) {
				System.out.println(product);
			}
		}
	}

	// 商品削除（ID指定）
	private static void deleteProduct() {
		System.out.print("削除する商品IDを入力してください: ");
		String idInput = scanner.nextLine();
		int id = Integer.parseInt(idInput);

		boolean deleted = productManager.deleteProduct(id);
		if (deleted) {
			System.out.println("商品IDが" + id + "を削除しました。");
		} else {
			System.out.println("該当する商品は見つかりませんでした。");
		}
	}
}
