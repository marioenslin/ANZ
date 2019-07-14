package au.com.anz.wholesale.engineering;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class AllAccountsController {
    private AccountsRepository repository;

    public AllAccountsController(AccountsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all-accounts")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Accounts> allAccounts() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

}