package br.com.dio.persistence.dao;

import br.com.dio.persistence.entity.CardHistoryEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;

public class CardHistoryDAO {
    
    private final Connection connection;

    public CardHistoryDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(CardHistoryEntity history) throws SQLException {
        String sql = "INSERT INTO card_history (card_id, from_column_id, to_column_id, moved_at) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, history.getCardId());
            ps.setLong(2, history.getFromColumnId());
            ps.setLong(3, history.getToColumnId());
            ps.setObject(4, history.getMovedAt());
            ps.executeUpdate();
        }
    }

    public List<CardHistoryDTO> findByCardId(Long cardId) throws SQLException {
        String sql = """
            SELECT ch.id, ch.card_id, bc1.name AS from_column, bc2.name AS to_column, ch.moved_at 
            FROM card_history ch
            JOIN board_column bc1 ON ch.from_column_id = bc1.id
            JOIN board_column bc2 ON ch.to_column_id = bc2.id
            WHERE ch.card_id = ?
            ORDER BY ch.moved_at DESC
            """;
        
        List<CardHistoryDTO> history = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, cardId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                history.add(new CardHistoryDTO(
                    rs.getLong("id"),
                    rs.getLong("card_id"),
                    rs.getString("from_column"),
                    rs.getString("to_column"),
                    rs.getObject("moved_at", OffsetDateTime.class)
                ));
            }
        }
        return history;
    }
}