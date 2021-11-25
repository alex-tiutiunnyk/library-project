package files.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

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
