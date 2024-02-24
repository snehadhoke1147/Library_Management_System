package net.javaguides.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import net.javaguides.lms.model.Book;

@Data
@Entity
@Table(name="book")

public class Book
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "isbn", nullable = false)
	private String isbn;
	
	@Column(name = "book_name", nullable = false)
	private String bookName;
	
	@Column(name = "author")
	private String author;
	 
}
