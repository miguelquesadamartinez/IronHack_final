package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.BalanceDTO;
import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.repositories.AccountRepository;
import lab.miguel.code.services.interfaces.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface {
    @Autowired
    AccountRepository accountRepository;

    @Override

    public BalanceDTO getBalance(Long id) {

        if(!accountRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        BalanceDTO dto = new BalanceDTO(accountRepository.findById(id).get().getBalance());

        return dto ;
    }

    @Override
    public void transferToAccount(Account origin, double amount, Optional<Account> holder1, Optional<Account> holder2) {

        if (origin.getBalance() < amount)
            throw new RuntimeException("Cantidad superior a balance");

        if(holder1.isPresent()) {
            holder1.get().setBalance(holder1.get().getBalance() + amount);
        } else if (holder2.isPresent()){
            holder2.get().setBalance(holder2.get().getBalance() + amount);
        } else {
            throw new RuntimeException("Pues como no me digas a quien lo mandas, vamos bien");
        }
    }


}
