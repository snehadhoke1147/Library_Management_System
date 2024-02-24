package net.javaguides.lms.service;

import java.util.List;

import net.javaguides.lms.model.Transaction;

public interface TransactionService 
{
	Transaction saveTransaction(Transaction transaction);
	
	List<Transaction> getAllTransactions();
	
	Transaction getTransactionById(long id);
		
	Transaction updateTransaction( long id, Transaction transaction);
	
	void deleteTransaction(long id);

	
	
}
