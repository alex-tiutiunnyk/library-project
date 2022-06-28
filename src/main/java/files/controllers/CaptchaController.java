package files.controllers;

import files.repository.CaptchaDAO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@ComponentScan(basePackages = {"files"})
public class CaptchaController {

  @Autowired
  private CaptchaDAO captchaDAO;

  @GetMapping("/api/captcha")
  public String getAllBooks() {
    return captchaDAO.getFileName();
  }
}
