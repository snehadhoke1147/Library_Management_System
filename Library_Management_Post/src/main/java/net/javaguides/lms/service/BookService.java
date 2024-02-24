package net.javaguides.lms.service;


import java.util.List;

import net.javaguides.lms.model.Book;


public interface BookService 
{
	 Book saveBook(Book book);
	 
	 List<Book>getAllBooks();
	 
	 Book getBookById(long id);
	
	 Book updateBook(long id,Book book);
	
	 void deleteBook(long id);
	
	 
	
	
	
	
}
