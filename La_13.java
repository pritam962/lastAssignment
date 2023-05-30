
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class La_13 {
	    // JDBC driver and database URL
	    static final String JDBC_DRIVER = "org.postgresql.Driver";
	    static final String DB_URL = "jdbc:postgresql://localhost/your_database_name";

	    // Database credentials
	    static final String USER = "your_username";
	    static final String PASS = "your_password";

	    public static void main(String[] args) {
	        Connection conn = null;
	        PreparedStatement pstmt = null;

	        try {
	            // Register JDBC driver
	            Class.forName(JDBC_DRIVER);

	            // Open a connection
	            System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);

	            // Prepare the SQL statement for batch update
	            String sql = "INSERT INTO your_table_name (column1, column2, column3) VALUES (?, ?, ?)";
	            pstmt = conn.prepareStatement(sql);

	            // Read input data from file and add batch updates
	            String filePath = "path_to_your_input_file.txt";
	            BufferedReader br = new BufferedReader(new FileReader(filePath));
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(",");

	                // Set the values for the prepared statement
	                pstmt.setString(1, data[0]);
	                pstmt.setString(2, data[1]);
	                pstmt.setString(3, data[2]);

	                // Add the prepared statement to the batch
	                pstmt.addBatch();
	            }
	            br.close();

	            // Execute the batch update
	            int[] batchResults = pstmt.executeBatch();

	            // Process the batch results
	            int totalUpdates = 0;
	            for (int result : batchResults) {
	                if (result == java.sql.Statement.SUCCESS_NO_INFO) {
	                    // The statement was executed successfully, but the number of affected rows is not known
	                    totalUpdates++;
	                } else if (result >= 0) {
	                    // The statement was executed successfully, and the result represents the number of affected rows
	                    totalUpdates += result;
	                } else if (result == java.sql.Statement.EXECUTE_FAILED) {
	                    // The statement failed to execute
	                    // Handle or log the error as needed
	                }
	            }

	            System.out.println("Batch update executed successfully!");
	            System.out.println("Total records inserted: " + totalUpdates);
	        } catch (SQLException se) {
	            // Handle errors for JDBC
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Handle errors for Class.forName
	            e.printStackTrace();
	        } finally {
	            // Close resources in a finally block to ensure they get closed even if an exception occurs
	            try {
	                if (pstmt != null)
	                    pstmt.close();
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
	}
