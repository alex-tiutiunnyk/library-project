package files.models;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
  private int id;
  private String name;
  private Timestamp dateAdded;
  private boolean available;

  public void setIsAvailable(boolean isAvailable) {
    available = isAvailable;
  }
}
