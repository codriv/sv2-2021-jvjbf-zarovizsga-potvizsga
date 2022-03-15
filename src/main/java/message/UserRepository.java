package message;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public UserRepository(MariaDbDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertUser(String username) {
        jdbcTemplate.update("insert into users (username) values (?)", username);
    }

    public Optional<User> findUserByName(String username) {
        List<User> users = jdbcTemplate.query("select id from users where username = ?", (rs, rowNum) -> {
            long id = rs.getLong("id");
            return new User(id, username);
        }, username);
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }
}
