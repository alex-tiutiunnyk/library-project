package files.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PreviewDAO {

  private final JdbcTemplate jdbcTemplate;

  public String getPreview() {
    String statement = "SELECT preview FROM previews WHERE id=1";
    return jdbcTemplate.queryForObject(statement, String.class);
  }
}
