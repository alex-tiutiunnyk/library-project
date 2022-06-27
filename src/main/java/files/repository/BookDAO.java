package files.repository;

import files.models.Book;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookDAO {

  private final JdbcTemplate jdbcTemplate;

  public List<Book> getAllBooks() {
    return jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Book.class));
  }

  public Book getBookById(int id) {
    try {
      return jdbcTemplate.queryForObject("SELECT * FROM books WHERE id=?",
          new BeanPropertyRowMapper<>(Book.class), id);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  public List<Book> getCheckedOutBooks() {
    return jdbcTemplate.query("SELECT * FROM books WHERE available = false",
        new BeanPropertyRowMapper<>(Book.class));
  }

  public void deleteById(int id) {
    String s = "DELETE FROM books WHERE id = ?";
    jdbcTemplate.update(s, id);
//    return jdbcTemplate.update("DELETE FROM books WHERE id=?", new BeanPropertyRowMapper<>(Book.class), id);
  }

  public Book save(String name) {
    Book book = new Book();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    Timestamp instant = new Timestamp(System.currentTimeMillis());
    boolean available = true;
    jdbcTemplate.update(
        connection -> {
          PreparedStatement ps = connection.prepareStatement(
              "INSERT INTO books(name, dateadded, available) VALUES(?, ?, ?)  RETURNING id",
              Statement.RETURN_GENERATED_KEYS);
          ps.setString(1, name);
          ps.setTimestamp(2, instant);
          ps.setBoolean(3, available);
          return ps;
        }, keyHolder);
    int primaryKey = Objects.requireNonNull(keyHolder.getKey()).intValue();
    book.setId(primaryKey);
    book.setName(name);
    book.setDateAdded(instant);
    book.setIsAvailable(available);
    return book;
  }
}
