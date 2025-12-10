import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class Transaction_JDBC {
    // 1. Database connection details
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/transaction_db";

    // Credentials (Confirmed by you)
    private static final String USER = "root";
    private static final String PASS = "visheshg12";

    // SQL Statement for 12 columns (3 NEW COLUMNS ADDED: ip_address, location, success_status)
    private static final String INSERT_SQL =
            "INSERT INTO transaction ("
                    + "transaction_id, timestamp, amount, currency, sender_acc, receiver_acc, "
                    + "transaction_type, channel, device_id, ip_address, location, success_status) " // <-- NEW COLUMNS
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // <-- 12 PLACEHOLDERS

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        // --- 3. GENERATE RANDOM DATA FOR INSERTION (INCLUDING NEW COLUMNS) ---

        // 1. Unique ID
        String transactionId = UUID.randomUUID().toString().replace("-", "");

        // 2. Current Timestamp
        Timestamp timestamp = new Timestamp(new Date().getTime());

        // 3. Random Amount
        int amount = 100 + (int)(Math.random() * 4900);

        // 4. Random Currency
        String currency = (Math.random() > 0.5) ? "USD" :
                (Math.random() > 0.5) ? "EUR" : "INR";

        // 5. Random Account Numbers
        String senderAcc = "SNDR" + (int)(Math.random() * 10000000);
        String receiverAcc = "RCVR" + (int)(Math.random() * 10000000);

        // 6. Random Transaction Type
        String transactionType = (Math.random() > 0.6) ? "T" : "W";

        // 7. Random Channel
        String channel = (Math.random() > 0.5) ? "MOBILE" : "WEB";

        // 8. Random Device ID
        String deviceId = "DEV" + (int)(Math.random() * 999999);

        // --- NEW DATA GENERATION ---

        // 9. Random IP Address
        String ipAddress = String.format("%d.%d.%d.%d",
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255));

        // 10. Random Location
        String location = (currency == "INR") ? "Bangalore" :
                (Math.random() > 0.5) ? "London" : "New York";

        // 11. Random Success Status
        // Assume 90% success rate for randomness
        String successStatus = (Math.random() < 0.9) ? "SUCCESS" : "FAILURE";


        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // 2. Open a connection
            System.out.println("Connecting to database: transaction_db...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection successful.");

            // 4. Prepare the SQL INSERT statement
            pstmt = conn.prepareStatement(INSERT_SQL);

            // 5. Set the values for the placeholders (Bind parameters)
            pstmt.setString(1, transactionId);
            pstmt.setTimestamp(2, timestamp);
            pstmt.setInt(3, amount);
            pstmt.setString(4, currency);
            pstmt.setString(5, senderAcc);
            pstmt.setString(6, receiverAcc);
            pstmt.setString(7, transactionType);
            pstmt.setString(8, channel);
            pstmt.setString(9, deviceId);

            // --- BINDING NEW PARAMETERS ---

            pstmt.setString(10, ipAddress);    // New
            pstmt.setString(11, location);     // New
            pstmt.setString(12, successStatus);// New

            // 6. Execute the statement
            System.out.println("Executing INSERT statement...");
            int rowsAffected = pstmt.executeUpdate();

            // 7. Check the result
            if (rowsAffected > 0) {
                System.out.printf("SUCCESS! %d row(s) inserted.\n", rowsAffected);
                System.out.printf("  ID: %s, Amount: %d %s, Location: %s, Status: %s\n",
                        transactionId, amount, currency, location, successStatus);
            } else {
                System.out.println("WARNING! No rows were inserted.");
            }

        } catch (SQLException se) {
            System.err.println("\n--- JDBC Error ---");
            System.err.println("SQL State: " + se.getSQLState());
            System.err.println("Message: " + se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            System.err.println("General Error:");
            e.printStackTrace();
        } finally {
            // 8. Clean-up environment
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException ignore) {}
            try {
                if (conn != null) conn.close();
                System.out.println("Database connection closed.");
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}