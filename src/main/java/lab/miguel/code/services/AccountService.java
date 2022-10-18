package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.AccountIdDTO;
import lab.miguel.code.controllers.DTOs.BalanceDTO;
import lab.miguel.code.controllers.DTOs.TransferDTO;
import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.repositories.AccountHolderRepository;
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
    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Override
    public BalanceDTO getBalance(Long id) {

        if(!accountRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        BalanceDTO dto = new BalanceDTO(accountRepository.findById(id).get().getDoubleBalance());

        return dto ;
    }

    @Override
    public void transferToAccount(TransferDTO transferDTO) {

        if(transferDTO.getAmount() == 0){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        Account originAccount = accountRepository.findById(transferDTO.getIdOrigin()).get();
        AccountHolders acc1 = null;
        AccountHolders acc2 = null;

        acc1 = accountHolderRepository.findById(transferDTO.getIdHolderUno()).get();
        acc2 = accountHolderRepository.findById(transferDTO.getIdHolderDos()).get();

        if (originAccount.getDoubleBalance() < transferDTO.getAmount())
            throw new RuntimeException("Cantidad superior a balance");

        if(accountHolderRepository.findById(transferDTO.getIdHolderUno()).isPresent()) {
            Account workingUnoAccount = accountRepository.findById(transferDTO.getIdHolderUno()).get();

            workingUnoAccount.increaseAmount(transferDTO.getAmount());

        } else if (accountHolderRepository.findById(transferDTO.getIdHolderDos()).isPresent()){
            Account workingDosAccount = accountRepository.findById(transferDTO.getIdHolderDos()).get();
            workingDosAccount.increaseAmount(transferDTO.getAmount());
        } else {
            throw new RuntimeException("Pues como no me digas a quien lo mandas, vamos bien");
        }

        originAccount.decreaseAmoutn(transferDTO.getAmount());

    }


}
