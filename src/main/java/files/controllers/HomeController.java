package files.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan(basePackages = {"files"})
public class HomeController {

  @GetMapping("/home")
  public String homePage() {
    return "home";
  }

  @GetMapping("/error")
  public String errorPage() {
    return "error";
  }
}
