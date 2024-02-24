package net.javaguides.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.lms.model.Book;


public interface BookRepository extends JpaRepository<Book, Long>
{
}
