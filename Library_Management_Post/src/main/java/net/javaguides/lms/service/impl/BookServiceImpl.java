package net.javaguides.lms.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.lms.exception.ResourceNotFoundException;
import net.javaguides.lms.model.Book;
import net.javaguides.lms.repository.BookRepository;
import net.javaguides.lms.service.BookService;


@Service
public class BookServiceImpl implements BookService{

	
	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(long id) {
		// TODO Auto-generated method stub
		 return bookRepository.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Book", "Id", id));
		
	}
	
	@Override
	public Book updateBook(long id, Book book)
	{
		// TODO Auto-generated method stub
		Book existingBook = bookRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Book", "Id", id));
		
		existingBook.setIsbn(book.getIsbn());
		existingBook.setBookName(book.getBookName());
		existingBook.setAuthor(book.getAuthor());
		
		//save existing book to db
		bookRepository.save(existingBook);
		return existingBook;
	}

	@Override
	public void deleteBook(long id) {
		// TODO Auto-generated method stub
		bookRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Book", "Id", id));
		bookRepository.deleteById(id);
	}

}
	

