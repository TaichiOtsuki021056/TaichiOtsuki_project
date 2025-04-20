package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {
	public static void main(String[] args) {
		String DATABASE_NAME = "product_management";
		String URL = "jdbc:mysql://localhost/" + DATABASE_NAME + "?useSSL=false&serverTimezone=UTC";
		String USER = "root";
		String PASSWORD = "Taichi1775";

		System.out.println("--商品の登録--");

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("商品名を入力してください:");
			String name = scanner.nextLine();

			System.out.println("価格を入力してください:");
			int price = Integer.parseInt(scanner.nextLine());

			System.out.println("在庫数を入力してください:");
			int stock = Integer.parseInt(scanner.nextLine());

			System.out.println("カテゴリーIDを入力してください:");
			int category_id = Integer.parseInt(scanner.nextLine());

			Class.forName("com.mysql.cj.jdbc.Driver");
			//VALUSEはInsert文で使用する
			String sql = "INSERT INTO products(name, price, stock, category_id) VALUES (?, ?, ?, ?)";

			// try-with-resources
			try (
					Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

					PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setString(1, name);
				pstmt.setInt(2, price);
				pstmt.setInt(3, stock);
				pstmt.setInt(4, category_id);

				int rowsInsert = pstmt.executeUpdate();

				if (rowsInsert > 0) {
					System.out.println("登録成功件数: " + rowsInsert + "件");
					System.out.println("登録内容:");
					System.out
							.println(
									"商品名: " + name + ", 価格: " + price + ", 在庫: " + stock + ", カテゴリーID: " + category_id);
				} else {
					System.out.println("登録失敗: 0件");
				}

			}

		} catch (Exception e) {
			System.out.println("エラーが発生しました: " + e.getMessage());
		}
	}
}
