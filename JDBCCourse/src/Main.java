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
//        String query = "select * from students";
        String query = "INSERT INTO students VALUES(?, ?, ?)";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully");
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                int marks = rs.getInt("marks");
//
//                System.out.println(id + " " + name + " " + marks);
//            }

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, 2);
            ps.setString(2, "Daniel");
            ps.setInt(3, 45);
            int count = ps.executeUpdate();
            System.out.println(count + " rows updated successfully");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
