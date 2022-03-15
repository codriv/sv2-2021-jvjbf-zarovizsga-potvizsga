package message;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MessageRepository {

    private JdbcTemplate jdbcTemplate;

    public MessageRepository(MariaDbDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void sendMessage(long senderId, long receiverId, String message) {
        jdbcTemplate.update("insert into messages (sender_id, receiver_id, message) values (?, ?, ?)", senderId, receiverId, message);
    }

    public List<String> findMessagesBySenderId(long senderId) {
        return jdbcTemplate.query("select message from messages where sender_id = ?", (rs, rowNum) -> {
            String message = rs.getString("message");
            return message;
        }, senderId);
    }
}
