package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepo;
	
	
	public List<Transaction> findAll () {
		List<Transaction> transactionsList = transactionRepo.findAll();
		Collections.sort(transactionsList, (transaction1, transaction2) -> transaction1.getDate().compareTo(transaction2.getDate())); 
		return transactionsList;
	}

	public Transaction findById(Long txnId) {
		Optional<Transaction> transactionOpt = transactionRepo.findAll()
											  .stream()
											  .filter(txn -> txn.getId().equals(txnId))
											  .findAny();
		return transactionOpt.orElse(new Transaction());
	}
}
