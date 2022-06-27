package files.controllers;

import files.repository.LicenseDAO;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@ComponentScan(basePackages = {"files"})
public class LicenseController {

  @Autowired
  private LicenseDAO licenseDAO;

  @GetMapping("/api/license")
  public int getDaysLeft() {
    LocalDate dateCreated = licenseDAO.getLicenseDate();
    return licenseDAO.daysLeft(dateCreated);
  }

  @GetMapping("api/license/check")
  public boolean getLicenseCheck() {
    LocalDate dateCreated = licenseDAO.getLicenseDate();
    int daysLeft = licenseDAO.daysLeft(dateCreated);
    return licenseDAO.isLicensed(daysLeft);
  }
}
