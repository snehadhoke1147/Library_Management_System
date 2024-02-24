package net.javaguides.lms.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.lms.model.Book;
import net.javaguides.lms.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController 
{
	private BookService bookService;
	
	public BookController(BookService bookService)
	{
		super();
		this.bookService = bookService;
	}
	
	//build create book rest api
	@PostMapping()
	public ResponseEntity<Book> saveBook(@RequestBody Book book)
	{
		return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.CREATED);
	}
	
	//build get all books rest api
	@GetMapping
	public List<Book> getAllUsers()
	{
		return bookService.getAllBooks();
	}
	
	//build get book by id rest api
	@GetMapping("{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") long bookId)
	{
		return new ResponseEntity<Book>(bookService.getBookById(bookId), HttpStatus.OK);
	}
	
	//build update book rest api
	@PutMapping("{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id")long id, @RequestBody Book book)
	{
		return new ResponseEntity<Book>(bookService.updateBook(id, book), HttpStatus.OK);
	}
	
	//delete book by id in rest api
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") long id)
	{
		bookService.deleteBook(id);
		return new ResponseEntity<String>("Book deleted successfully!.", HttpStatus.OK);
	}
}
