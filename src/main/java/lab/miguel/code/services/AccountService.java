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

import java.util.List;
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
            throw new RuntimeException("No amount enough");
        }

        // TODO: Esto ??

        Account originAccount = accountRepository.findById(transferDTO.getIdOrigin()).get();
        AccountHolders acc1 = null;
        AccountHolders acc2 = null;

        System.out.println("getIdHolderUno: " + transferDTO.getIdHolderUno());

        if (!accountHolderRepository.findById(transferDTO.getIdHolderUno()).isPresent()
            &&
            !accountHolderRepository.findById(transferDTO.getIdHolderDos()).isPresent())
            throw new RuntimeException("No hay a quien mandar");

        acc1 = accountHolderRepository.findById(transferDTO.getIdHolderUno()).get();

        if(accountHolderRepository.findById(transferDTO.getIdHolderDos()).isPresent())
            acc2 = accountHolderRepository.findById(transferDTO.getIdHolderDos()).get();


        if (originAccount.getDoubleBalance() < transferDTO.getAmount())
            throw new RuntimeException("Cantidad superior a balance");

        if(accountHolderRepository.findById(transferDTO.getIdHolderUno()).isPresent()) {
            Account workingUnoAccount = accountRepository.findByPrimaryOwnerId(transferDTO.getIdHolderUno());
            workingUnoAccount.increaseAmount(transferDTO.getAmount());
            accountRepository.save(workingUnoAccount);
        } else if (accountHolderRepository.findById(transferDTO.getIdHolderDos()).isPresent()){
            Account workingDosAccount = accountRepository.findBySecondaryOwnerId(transferDTO.getIdHolderDos());
            workingDosAccount.increaseAmount(transferDTO.getAmount());
            accountRepository.save(workingDosAccount);

        } else {
            throw new RuntimeException("Pues como no me digas a quien lo mandas, vamos bien");
        }

        originAccount.decreaseAmoutn(transferDTO.getAmount());
        accountRepository.save(originAccount);

        System.out.println("\n\nSale en Service - transferToAccount\n\n");
    }

    public List<Account> findAll (){
        return accountRepository.findAll();
    }

}
