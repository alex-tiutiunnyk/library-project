package files.repository;

import files.models.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper {
  @Override
  public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
    Book book = new Book();

    book.setId(resultSet.getInt("id"));
    book.setName(resultSet.getString("name"));
    book.setDateAdded(resultSet.getTimestamp("dateAdded"));
    book.setIsAvailable(resultSet.getBoolean("isAvailable"));

    return book;
  }
}
