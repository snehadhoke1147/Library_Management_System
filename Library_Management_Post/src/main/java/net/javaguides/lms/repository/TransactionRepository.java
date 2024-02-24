package net.javaguides.lms.repository;
import net.javaguides.lms.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long>
{

}
