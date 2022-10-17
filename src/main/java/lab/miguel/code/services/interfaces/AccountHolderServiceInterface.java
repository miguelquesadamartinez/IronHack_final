package lab.miguel.code.services.interfaces;

import lab.miguel.code.controllers.DTOs.CreateAccountHolderDTO;
import lab.miguel.code.entity.AccountHolders;

import java.util.List;

public interface AccountHolderServiceInterface {

    AccountHolders createAccountHolder(CreateAccountHolderDTO accountHolders);
    public AccountHolders findById(Long id);
    public List<AccountHolders> findAll();

}
