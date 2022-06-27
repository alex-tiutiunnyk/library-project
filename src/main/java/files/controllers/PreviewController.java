package files.controllers;

import files.models.Caesar;
import files.repository.PreviewDAO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@ComponentScan(basePackages = {"files"})
public class PreviewController {

  @Autowired
  private PreviewDAO previewDAO;

  @GetMapping("/api/preview")
  public String getPreview() {
    String msg = previewDAO.getPreview();
    String new_msg = Caesar.encrypt(msg, 1);
    String back_to_msg = Caesar.decrypt(new_msg, 1);
    return back_to_msg;
  }
}