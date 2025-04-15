package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticeDB {
	public static void main(String[] args) {
		String DATABASE_NAME = "product_management";
		String URL = "jdbc:mysql://localhost/" + DATABASE_NAME;
		String USER = "root";
		String PASSWORD = "Taichi1775";

		Connection connection = null;
		try {
			//MySQLに接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベースへ接続
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			//ステイトメント生成
			Statement stmt = connection.createStatement();
			System.out.println("DB接続成功");
			//SQLを実行
			String sql = "SELECT * FROM products";
			ResultSet rs = stmt.executeQuery(sql);
			//結果行をループ
			System.out.println("\n--productsテーブルの全ての商品情報を表示--");
			while (rs.next()) {
				//レコードの値
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				int category_id = rs.getInt("category_id");
				//表示
				System.out.println("\nid:" + id);
				System.out.println("name:" + name);
				System.out.println("price:" + price);
				System.out.println("stock:" + stock);
				System.out.println("category_id:" + category_id);
			}
			//接続を閉じる
			rs.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("DB接続失敗");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("接続のクローズに失敗しました");
					e.printStackTrace();
				}
			}
		}
	}
}