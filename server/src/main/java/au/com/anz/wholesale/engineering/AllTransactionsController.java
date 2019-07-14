package au.com.anz.wholesale.engineering;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class AllTransactionsController {
    private TransactionsRepository repository;

    public AllTransactionsController(TransactionsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all-transactions")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Transactions> allTransactions() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
    
    @GetMapping("/transactions")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Transactions> getTransactionsByAccountNumber(@RequestParam String accountNumber) {
    	Collection<Transactions> result = new ArrayList<Transactions>();
    	Collection<Transactions> transactionList = repository.findAll().stream().collect(Collectors.toList());
    	
    	for (Transactions transaction : transactionList) {
    		if(transaction.getAccountNumber().equals(accountNumber)) {
    			result.add(transaction);
    		}
		}
    	
    	return result;
    }

}