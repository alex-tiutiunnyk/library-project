package files.repository;

import java.util.Random;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CaptchaDAO {

  private final String[] fileName = new String[] {"1.png", "2.png", "3.png"};

  public String getFileName() {
    int min = 0;
    int max = 2;
    int chosenFileName = new Random().nextInt(max - min + 1) + min;
    return fileName[chosenFileName];
  }
}
