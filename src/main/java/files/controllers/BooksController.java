package files.controllers;

import files.dao.BookDAO;
import files.models.Book;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@ComponentScan(basePackages = {"files"})
public class BooksController {

    @Autowired
    private BookDAO bookDAO;

    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @GetMapping("/api/checked-out-books")
    public List<Book> getCheckedOutBooks() {
        return bookDAO.getCheckedOutBooks();
    }

    @PostMapping("api/books")
    public Book create(@ModelAttribute("name") String name) {
        return bookDAO.save(name);
    }

//    @GetMapping("/api/books")
//    public String getAllBooks(Model model) {
//        model.addAttribute("books", bookDAO.getAllBooks());
//        return "home";
//    }

    //    @GetMapping("/api/checked-out-books")
//    public String getCheckedOutBooks(Model model) {
//        model.addAttribute("checkedOutBooks", bookDAO.getCheckedOutBooks());
//        return "home";
//    }

//    @PostMapping("api/books")
//    public String create(@ModelAttribute("name") String name, BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return "error";
//        bookDAO.save(name);
//        return "redirect:/home";
//    }
}