import java.sql.*;

public class Main {
    public static void main(String[] args) {
        /*
        1. import package
        2. load and register drivers
        3. create connection
        4. create statement
        5. execute statement
        6. process the results
        7. Close
         */
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "postgres";
        String query = "select * from students";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                System.out.println(id + " " + name + " " + marks);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
