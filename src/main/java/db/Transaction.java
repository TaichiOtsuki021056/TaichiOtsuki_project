package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Transaction {
	public static void main(String[] args) {
		String DATABASE_NAME = "product_management";
		String URL = "jdbc:mysql://localhost/" + DATABASE_NAME + "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String USER = "root";
		String PASSWORD = "Taichi1775";
		Scanner scanner = new Scanner(System.in);
		try  {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "UPDATE products SET price = ?, stock = ? WHERE id = ?";
			
			try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
				connection.setAutoCommit(false);
			
					try(PreparedStatement pstmt1 = connection.prepareStatement(sql); 
							PreparedStatement pstmt2 = connection.prepareStatement(sql)){

						System.out.println("--商品の価格と在庫の更新①--");
						System.out.println("商品IDを入力してください:");
						int id1 = Integer.parseInt(scanner.nextLine());

						System.out.println("価格を入力してください:");
						int price1 = Integer.parseInt(scanner.nextLine());

						System.out.println("在庫数を入力してください:");
						int stock1 = Integer.parseInt(scanner.nextLine());
					
						pstmt1.setInt(1, price1);
						pstmt1.setInt(2, stock1);
						pstmt1.setInt(3, id1);
						int rowsUpdate1 = pstmt1.executeUpdate();

						System.out.println("--商品の価格と在庫の更新②--");
						System.out.println("商品IDを入力してください:");
						int id2 = Integer.parseInt(scanner.nextLine());

						System.out.println("価格を入力してください:");
						int price2 = Integer.parseInt(scanner.nextLine());

						System.out.println("在庫数を入力してください:");
						int stock2 = Integer.parseInt(scanner.nextLine());
					
						pstmt2.setInt(1, price2);
						pstmt2.setInt(2, stock2);
						pstmt2.setInt(3, id2);
						
						int rowsUpdate2 = pstmt2.executeUpdate();

						if (rowsUpdate1 > 0&&rowsUpdate2 > 0) {
							connection.commit();
							System.out.println("コミット成功");
							System.out.println("更新成功件数: 2件");
							System.out.println("\n更新内容①:");
							System.out
									.println("商品ID: " + id1 + ", 価格: " + price1 + ", 在庫: " + stock1);
							System.out.println("\n更新内容②:");
							System.out
									.println("商品ID: " + id2 + ", 価格: " + price2 + ", 在庫: " + stock2);
						  } else {
		                        connection.rollback();
		                        System.out.println("更新に失敗したため、ロールバックしました。");
		                    }
		                } catch (SQLException e) {
		                    connection.rollback();
		                    e.printStackTrace();
		                }
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            scanner.close();
		        }
		    }
		}