package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.CreateAccountHolderDTO;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Address;
import lab.miguel.code.repositories.AccountHolderRepository;
import lab.miguel.code.repositories.AddressRepository;
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
    @Autowired
    AddressRepository addressRepository;

    public AccountHolders createAccountHolder(CreateAccountHolderDTO accountHolder){

        if (accountHolder.getName() == ""){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        } else if (accountHolder.getDateOFBirth() == "") {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        Address addr1 = addressRepository.findById(accountHolder.getPrimaryAddress()).get();
        Address addr2 = addressRepository.findById(accountHolder.getMailingAddress()).get();

        return accountHolderRepository.save(
                new AccountHolders(
                        accountHolder.getName(),
                        accountHolder.getDateOFBirth(),
                        addr1,
                        addr2
                )
        );

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
