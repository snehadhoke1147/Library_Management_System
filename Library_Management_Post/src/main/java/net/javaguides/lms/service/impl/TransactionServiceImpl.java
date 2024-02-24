package net.javaguides.lms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.lms.exception.ResourceNotFoundException;
import net.javaguides.lms.model.Transaction;
import net.javaguides.lms.repository.TransactionRepository;
import net.javaguides.lms.service.TransactionService;


@Service
public class TransactionServiceImpl implements TransactionService
{
		private TransactionRepository transactionRepository;
		
		public TransactionServiceImpl(TransactionRepository transactionRepository) {
			super();
			this.transactionRepository = transactionRepository;
		}

		@Override
		public Transaction saveTransaction(Transaction transaction) {
			// TODO Auto-generated method stub
			return transactionRepository.save(transaction);
		}

		@Override
		public List<Transaction> getAllTransactions() {
			// TODO Auto-generated method stub
			return transactionRepository.findAll();
		}

		@Override
		public Transaction getTransactionById(long id) {
			// TODO Auto-generated method stub
			return transactionRepository.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("Transaction", "Id", id));
		}
		
		@Override
		public Transaction updateTransaction(long id, Transaction transaction) {
			// TODO Auto-generated method stub
			Transaction existingTransaction = transactionRepository.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("Transaction", "Id", id));
			
			existingTransaction.setUserName(transaction.getUserName());
			existingTransaction.setIssueDate(transaction.getIssueDate());
			existingTransaction.setExpiryDate(transaction.getExpiryDate());
			
			//save 
			transactionRepository.save(existingTransaction);
			return existingTransaction;
		}

		@Override
		public void deleteTransaction(long id) 
		{
			// TODO Auto-generated method stub
			transactionRepository.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Transaction", "Id", id));
			transactionRepository.deleteById(id);
		}
		
		
	
}
