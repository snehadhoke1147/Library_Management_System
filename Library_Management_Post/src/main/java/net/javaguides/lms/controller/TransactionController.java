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

import net.javaguides.lms.model.Transaction;
import net.javaguides.lms.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController 
{
	private TransactionService transactionService;
	
	public TransactionController(TransactionService transactionService)
	{
		super();
		this.transactionService = transactionService;
	}
	
	//create
	@PostMapping()
	public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction)
	{
		return new ResponseEntity<Transaction>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
	}
	
	//get all
	@GetMapping
	public List<Transaction> getAllTransaction()
	{
		return transactionService.getAllTransactions();
	}
	
	//get by id
	@GetMapping("{id}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") long transactionId)
	{
		return new ResponseEntity<Transaction>(transactionService.getTransactionById(transactionId),HttpStatus.OK);
	}
	
	//update
	@PutMapping("{id}")
	public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") long id, @RequestBody Transaction transaction)
	{
		return new ResponseEntity<Transaction>(transactionService.updateTransaction(id, transaction), HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTransaction(@PathVariable("id") long id)
	{
		transactionService.deleteTransaction(id);
		return new ResponseEntity<String> ("user deleted successfully!.", HttpStatus.OK);
	}
	
}






