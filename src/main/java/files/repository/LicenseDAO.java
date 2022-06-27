package files.repository;

import java.time.LocalDate;
import java.time.Period;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LicenseDAO {
  private final JdbcTemplate jdbcTemplate;

  public LocalDate getLicenseDate() {
    String statement = "SELECT date_created FROM license WHERE id=1";
    return jdbcTemplate.queryForObject(statement, LocalDate.class);
  }

  public int daysLeft(LocalDate dateCreated) {
    LocalDate nowDate = LocalDate.now();
    LocalDate dateExpiration = dateCreated.plusDays(10);
    Period period = Period.between(dateExpiration, nowDate);
    return period.getDays();
  }

  public boolean isLicensed(int daysLeft) {
    return daysLeft < 0;
  }
}
