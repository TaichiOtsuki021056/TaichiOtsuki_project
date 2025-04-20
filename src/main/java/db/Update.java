package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {
	public static void main(String[] args) {
		String DATABASE_NAME = "product_management";
		String URL = "jdbc:mysql://localhost/" + DATABASE_NAME + "?useSSL=false&serverTimezone=UTC";
		String USER = "root";
		String PASSWORD = "Taichi1775";

		System.out.println("--商品の価格と在庫の更新--");

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("商品IDを入力してください:");
			int id = Integer.parseInt(scanner.nextLine());

			System.out.println("価格を入力してください:");
			int price = Integer.parseInt(scanner.nextLine());

			System.out.println("在庫数を入力してください:");
			int stock = Integer.parseInt(scanner.nextLine());
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "UPDATE products SET price = ?, stock = ? WHERE id = ?";

			try (
					Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

					PreparedStatement pstmt = connection.prepareStatement(sql)) {

				pstmt.setInt(1, price);
				pstmt.setInt(2, stock);
				pstmt.setInt(3, id);

				int rowsUpdate = pstmt.executeUpdate();
				if (rowsUpdate > 0) {
					System.out.println("更新成功件数: " + rowsUpdate + "件");
					System.out.println("更新内容:");
					System.out
							.println("商品ID: " + id + ", 価格: " + price + ", 在庫: " + stock);
				} else {
					System.out.println("更新失敗: 0件");
				}

			}

		} catch (Exception e) {
			System.out.println("エラーが発生しました: " + e.getMessage());
		}
	}

}
