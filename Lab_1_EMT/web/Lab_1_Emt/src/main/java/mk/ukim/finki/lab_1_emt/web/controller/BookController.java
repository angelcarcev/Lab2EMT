//package mk.ukim.finki.lab_1_emt.web.controller;
//
//
//import mk.ukim.finki.lab_1_emt.model.BookType;
//import mk.ukim.finki.lab_1_emt.service.AuthorService;
//import mk.ukim.finki.lab_1_emt.service.BookService;
//import mk.ukim.finki.lab_1_emt.service.CountryService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class BookController {
//
//    private final BookService bookService;
//    private final AuthorService authorService;
//    private final CountryService countryService;
//
//    public BookController(BookService bookService, AuthorService authorService, CountryService countryService) {
//        this.bookService = bookService;
//        this.authorService = authorService;
//        this.countryService = countryService;
//    }
//
//    @GetMapping(path = {"/","/books"})
//    public String showList(Model model) {
//        model.addAttribute("books",bookService.listAll());
//        model.addAttribute("authors",authorService.listAll());
//        model.addAttribute("countries",countryService.listAll());
//        return "list";
//    }
//
//    @GetMapping("/books/add")
//    public String showAdd(Model model) {
//        model.addAttribute("book",bookService.listAll());
//        model.addAttribute("author",authorService.listAll());
//        model.addAttribute("country",countryService.listAll());
//        model.addAttribute("type", BookType.values());
//        return "form";
//    }
//
//    @GetMapping("/books/{id}/edit")
//    public String showEdit(@PathVariable Long id, Model model) {
//        model.addAttribute("book",bookService.findById(id));
//        model.addAttribute("author",authorService.listAll());
//        model.addAttribute("country",countryService.listAll());
//        model.addAttribute("type", BookType.values());
//        return "form";
//    }
//
//    @PostMapping("/books")
//    public String create( @RequestParam String name,
//                          @RequestParam BookType type,
//                          @RequestParam List<Long> authors,
//                          @RequestParam Integer availableCopies) {
//        this.bookService.create(name, type, authors, availableCopies);
//        return "redirect:/books";
//    }
//
//    @PostMapping("/books/{id}")
//    public String update(@PathVariable Long id,
//                         @RequestParam String name,
//                         @RequestParam BookType type,
//                         @RequestParam List<Long> authors,
//                         @RequestParam Integer availableCopies) {
//        this.bookService.update(id, name, type, authors, availableCopies);
//        return "redirect:/books";
//    }
//
//    @PostMapping("/books/{id}/delete")
//    public String delete(@PathVariable Long id) {
//        this.bookService.delete(id);
//        return "redirect:/books";
//    }
//
//    @PostMapping("/books/{id}/tag")
//    public String tag(@PathVariable Long id) {
//        this.bookService.tag(id);
//        return "redirect:/books";
//    }
//}
