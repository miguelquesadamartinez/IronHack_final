package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.AccountIdDTO;
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
        BalanceDTO dto = new BalanceDTO(accountRepository.findById(id).get().getDoubleBalance());

        return dto ;
    }

    @Override
    public void transferToAccount(AccountIdDTO origin, double amount, Optional<AccountIdDTO> holder1, Optional<AccountIdDTO> holder2) {

        if(amount == 0){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        Account workingOriginAccount = accountRepository.findById(origin.getId()).get();


        if (workingOriginAccount.getDoubleBalance() < amount)
            throw new RuntimeException("Cantidad superior a balance");

        if(holder1.isPresent()) {
            Account workingUnoAccount = accountRepository.findById(origin.getId()).get();

            workingUnoAccount.increaseAmount(amount);

        } else if (holder2.isPresent()){
            Account workingDosAccount = accountRepository.findById(origin.getId()).get();
            workingDosAccount.decreaseAmoutn(amount);
        } else {
            throw new RuntimeException("Pues como no me digas a quien lo mandas, vamos bien");
        }
    }


}
