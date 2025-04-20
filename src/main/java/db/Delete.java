package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete {
	public static void main(String[] args) {
		String DATABASE_NAME = "product_management";
		String URL = "jdbc:mysql://localhost/" + DATABASE_NAME + "?useSSL=false&serverTimezone=UTC";
		String USER = "root";
		String PASSWORD = "Taichi1775";

		System.out.println("--商品の削除--");

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("商品IDを入力してください:");
			int id = Integer.parseInt(scanner.nextLine());
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "DELETE FROM products WHERE id=?";

			try (
					Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

					PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				int rowsDelete = pstmt.executeUpdate();

				if (rowsDelete > 0) {
					System.out.println("削除成功件数: " + rowsDelete + "件");

					System.out
							.println("商品ID " + id + " を削除しました");
				} else {
					System.out.println("削除失敗: 0件");
				}

			}

		} catch (Exception e) {
			System.out.println("エラーが発生しました: " + e.getMessage());
		}
	}

}

