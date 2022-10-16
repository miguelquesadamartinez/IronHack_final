package lab.miguel.code.services;

import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.repositories.AccountHolderRepository;
import lab.miguel.code.services.interfaces.AccountHolderServiceInterface;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountHolderService implements AccountHolderServiceInterface {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    public AccountHolders createAccountHolder(AccountHolders accountHolder){

        if (accountHolder.getName() == ""){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        } else if (accountHolder.getDateOFBirth() == "") {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        return accountHolderRepository.save(accountHolder);

    }
    public List<AccountHolders> findAll(){
        return accountHolderRepository.findAll();
    }
    public AccountHolders findById(Long id){
        if(!accountHolderRepository.findById(id).isPresent())
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        return accountHolderRepository.findById(id).get();
    }




}
