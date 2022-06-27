package files.controllers;

import files.models.Book;
import files.repository.BookDAO;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@ComponentScan(basePackages = {"files"})
public class BookController {

  @Autowired
  private BookDAO bookDAO;

  @GetMapping("/api/books")
  public List<Book> getAllBooks() {
    return bookDAO.getAllBooks();
  }

  @GetMapping("api/books/{id}")
  public Book getById(@PathVariable("id") int id) {
    return bookDAO.getBookById(id);
  }

  @GetMapping("/api/checked-out-books")
  public List<Book> getCheckedOutBooks() {
    return bookDAO.getCheckedOutBooks();
  }

  @PostMapping("api/books")
  public Book create(@ModelAttribute("name") String name) {
    return bookDAO.save(name);
  }

  @DeleteMapping("/api/books/{id}")
  public void deleteEmployee(@PathVariable("id") int id) {
    bookDAO.deleteById(id);
  }
}