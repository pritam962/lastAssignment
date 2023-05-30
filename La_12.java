
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class La_12 {
	    // JDBC driver and database URL
	    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    static final String DB_URL = "jdbc:mysql://localhost/your_database_name";

	    // Database credentials
	    static final String USER = "your_username";
	    static final String PASS = "your_password";

	    public static void main(String[] args) {
	        Connection conn = null;
	        Statement stmt = null;
	        Scanner scanner = new Scanner(System.in);

	        try {
	            // Register JDBC driver
	            Class.forName(JDBC_DRIVER);

	            // Open a connection
	            System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);

	            // Create a statement
	            stmt = conn.createStatement();

	            while (true) {
	                System.out.println("1. Add record");
	                System.out.println("2. View records");
	                System.out.println("3. Update record");
	                System.out.println("4. Delete record");
	                System.out.println("5. Exit");
	                System.out.print("Enter your choice: ");
	                int choice = scanner.nextInt();

	                switch (choice) {
	                    case 1:
	                        addRecord(stmt, scanner);
	                        break;
	                    case 2:
	                        viewRecords(stmt);
	                        break;
	                    case 3:
	                        updateRecord(stmt, scanner);
	                        break;
	                    case 4:
	                        deleteRecord(stmt, scanner);
	                        break;
	                    case 5:
	                        System.out.println("Exiting...");
	                        scanner.close();
	                        stmt.close();
	                        conn.close();
	                        System.exit(0);
	                    default:
	                        System.out.println("Invalid choice!");
	                }
	            }
	        } catch (SQLException se) {
	            // Handle errors for JDBC
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Handle errors for Class.forName
	            e.printStackTrace();
	        } finally {
	            // Close resources in a finally block to ensure they get closed even if an exception occurs
	            try {
	                if (stmt != null)
	                    stmt.close();
	            } catch (SQLException se2) {
	                se2.printStackTrace();
	            }
	            try {
	                if (conn != null)
	                    conn.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    }

	    private static void addRecord(Statement stmt, Scanner scanner) throws SQLException {
	        System.out.print("Enter name: ");
	        String name = scanner.next();

	        // Execute the INSERT query
	        String sql = "INSERT INTO your_table_name (name) VALUES ('" + name + "')";
	        stmt.executeUpdate(sql);

	        System.out.println("Record added successfully!");
	    }

	    private static void viewRecords(Statement stmt) throws SQLException {
	        // Execute the SELECT query
	        String sql = "SELECT * FROM your_table_name";
	        ResultSet rs = stmt.executeQuery(sql);

	        // Process and display the result set
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            System.out.println("ID: " + id + ", Name: " + name);
	        }

	        rs.close();
	    }

	    private static void updateRecord(Statement stmt, Scanner scanner) throws SQLException {
	        System.out.print("Enter record ID to update: ");
	        int id = scanner.nextInt();
	        System.out.print("Enter new name: ");
	        String name = scanner.next();

	        // Execute the UPDATE query
	        String sql = "UPDATE your_table_name SET name='" + name + "' WHERE id=" + id;
	        int rowsAffected = stmt.executeUpdate(sql);

	        if (rowsAffected > 0) {
	            System.out.println("Record updated successfully!");
	        } else {
	            System.out.println("No record found with ID: " + id);
	        }
	    }

	    private static void deleteRecord(Statement stmt, Scanner scanner) throws SQLException {
	        System.out.print("Enter record ID to delete: ");
	        int id = scanner.nextInt();

	        // Execute the DELETE query
	        String sql = "DELETE FROM your_table_name WHERE id=" + id;
	        int rowsAffected = stmt.executeUpdate(sql);

	        if (rowsAffected > 0) {
	            System.out.println("Record deleted successfully!");
	        } else {
	            System.out.println("No record found with ID: " + id);
	        }
	    }
	}
