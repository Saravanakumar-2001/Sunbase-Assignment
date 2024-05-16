import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupabaseDatabase {
    private static final String DB_URL = postgres;// postgres.ejtjafagumohgazwloeo:Saravana@200110@aws-0-ap-south-1.pooler.supabase.com:5432/postgres;
    private static final String USER = "postgres.ejtjafagumohgazwloeo";
    private static final String PASSWORD = "Saravana@200110";

    // Method to insert an embedding into the Supabase database
    public void insertEmbedding(String textInput, float[] embedding) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "INSERT INTO embeddings (text_input, embedding) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, textInput);
                pstmt.setArray(2, conn.createArrayOf("FLOAT", embedding));
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve embeddings from the Supabase database
    public float[] getEmbedding(String textInput) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "SELECT embedding FROM embeddings WHERE text_input = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, textInput);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return (float[]) rs.getArray("embedding").getArray();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
